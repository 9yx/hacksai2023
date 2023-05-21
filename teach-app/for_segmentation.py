import os

from ultralytics import YOLO
import numpy as np
import cv2
import sys
import torch
from PIL import Image
from pathlib import Path

sys.path.append("..")
from segment_anything import sam_model_registry, SamPredictor
import matplotlib.pyplot as plt

# отрисовка bbox
def show_box(box, ax):
    x0, y0 = box[0], box[1]
    w, h = box[2] - box[0], box[3] - box[1]
    ax.add_patch(plt.Rectangle((x0, y0), w, h, edgecolor='green', facecolor=(0, 0, 0, 0), lw=2))

# отрисовка маски
def show_mask(mask, ax, random_color=False):
    if random_color:
        color = np.concatenate([np.random.random(3), np.array([0.6])], axis=0)
    else:
        color = np.array([30 / 255, 144 / 255, 255 / 255, 0.6])
    h, w = mask.shape[-2:]
    mask_image = mask.reshape(h, w, 1) * color.reshape(1, 1, -1)
    ax.imshow(mask_image)

# поиск bbox используя нашу модель
def yolov8_detection(model, image_path):

    image = cv2.imread(image_path)
    image = cv2.cvtColor(image, cv2.COLOR_BGR2RGB)
    results = model(image, stream=True)  

    for result in results:
        boxes = result.boxes 

    bbox = boxes.xyxy.tolist()
    bbox = [[int(i) for i in box] for box in bbox]
    return bbox, image

# сегментация с использованием найденного bbox и facebook sam
def yolo8_segmentation(image_path, model):
    image = cv2.imread(image_path)
    image = cv2.cvtColor(image, cv2.COLOR_BGR2RGB)

    yolov8_boxex, image = yolov8_detection(model, image_path)

    sam_checkpoint = "sam_vit_l_0b3195.pth"
    model_type = "vit_l"
    device = 0

    sam = sam_model_registry[model_type](checkpoint=sam_checkpoint)
    sam.to(device=device)

    predictor = SamPredictor(sam)
    predictor.set_image(image)
    input_boxes = torch.tensor(yolov8_boxex, device=predictor.device)

    transformed_boxes = predictor.transform.apply_boxes_torch(input_boxes, image.shape[:2])
    masks, _, _ = predictor.predict_torch(
        point_coords=None,
        point_labels=None,
        boxes=transformed_boxes,
        multimask_output=False,
    )

    for i, mask in enumerate(masks):
        binary_mask = masks[i].cpu().squeeze().numpy().astype(np.uint8)
        contours, hierarchy = cv2.findContours(binary_mask, cv2.RETR_EXTERNAL, cv2.CHAIN_APPROX_SIMPLE)
        largest_contour = max(contours, key=cv2.contourArea)
        bbox = [int(x) for x in cv2.boundingRect(largest_contour)]

        segmentation = largest_contour.flatten().tolist()
        mask = segmentation

        # загрузка изображения
        img = Image.open(image_path)
        width, height = img.size
        mask = np.array(mask).reshape(-1, 2)

        # нормализация 
        mask_norm = mask / np.array([width, height])

        # вычисление нового bbox
        xmin, ymin = mask_norm.min(axis=0)
        xmax, ymax = mask_norm.max(axis=0)
        bbox_norm = np.array([xmin, ymin, xmax, ymax])

        # конвертация yolo формат для тренировки
        yolo = np.concatenate([bbox_norm, mask_norm.reshape(-1)])
        
        with open("labels/" + Path(image_path).with_suffix('.txt').name, 'a') as f:
            x, y, w, h = bbox[0], bbox[1], bbox[2], bbox[3]
            f.write('1 {:.6f} {:.6f} {:.6f} {:.6f} '.format((x + w / 2) / image.shape[1], (y + h / 2) / image.shape[0],
                                                            w / image.shape[1], h / image.shape[0]))
            for val in yolo:
                f.write("{:.6f} ".format(val))
            f.write('\n')


model = YOLO('/home/rustam/PyProjects/swans_classifier /runs/detect/train2/weights/best.pt')
folder_dir = "/home/rustam/Test/klikun/images/"

for images in os.listdir(folder_dir):
    try:
        if images.endswith(".jpg") or images.endswith(".png"):
            yolo8_segmentation(folder_dir + "/" + images, model)
    except:
        print("An exception occurred")
