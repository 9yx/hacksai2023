from ultralytics import YOLO
from flask import request, Response, Flask
from waitress import serve
from PIL import Image
import json
import torch

app = Flask(__name__)

model = YOLO("model/best.pt")
#model_big_cls = YOLO("model/best-big.pt")
model_best_of_best_cls = YOLO("model/best-of-best.pt")
# model_cls = YOLO("model/best-cls.pt")

#model_best_of_best_cls.export(format='onnx')


@app.route("/detect", methods=["POST"])
def detect():
    buf = request.files["file"]
    boxes = detect_objects_on_image(Image.open(buf.stream))
    return Response(
        json.dumps(boxes),
        mimetype='application/json'
    )


@app.route("/cls", methods=["POST"])
def cls():
    buf = request.files["file"]
    resp = class_objects_on_image(Image.open(buf.stream))
    return Response(
        json.dumps(resp),
        mimetype='application/json'
    )


def class_objects_on_image(buf):
    results = model_best_of_best_cls.predict(buf)
    return results[0].probs.numpy().tolist()


def detect_objects_on_image(buf):
    results = model.predict(buf)
    result = results[0]
    output = []
    for box in result.boxes:
        x1, y1, x2, y2 = [
            round(x) for x in box.xyxy[0].tolist()
        ]
        class_id = box.cls[0].item()
        prob = round(box.conf[0].item(), 2)
        output.append([
            x1, y1, x2, y2, result.names[class_id], prob
        ])
    return output


serve(app, host='0.0.0.0', port=8088)
