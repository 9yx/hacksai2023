from ultralytics import YOLO

if __name__ == '__main__':
    model = YOLO("yolov8m-cls.pt")

    model.train(
        data="lebedi-class",
        epochs=100,
        verbose=True,
        imgsz=640
    )

    model.val()

