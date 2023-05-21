from ultralytics import YOLO

if __name__ == '__main__':
    model = YOLO("yolov8n.pt")  # загрузка предобученной модели

    model.train(
        data="lebedi.yaml",
        epochs=100,
        verbose=True,
        imgsz=640,
        batch=42
    )  # обучение модели

    model.val()  # оцените производительность модели на наборе проверки

