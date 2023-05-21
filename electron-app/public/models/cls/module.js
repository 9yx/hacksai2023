const sharp = require("sharp");
const ort = require("onnxruntime-node");
const path = require("path");

const yolo_classes = ['Кликун', 'Малый', 'Шипун'];

module.exports = async function class_objects_on_image(buf) {
    const [input] = await prepare_input(buf);
    const output = await run_model(input);
    const max = Math.max(...output);
    const index = output.indexOf(max);
    return yolo_classes[index];
}

async function prepare_input(buf) {
    const img = sharp(buf);
    const md = await img.metadata();
    const [img_width, img_height] = [md.width, md.height];
    const pixels = await img.removeAlpha()
        .resize({width: 640, height: 640, fit: 'fill'})
        .raw()
        .toBuffer();

    const red = [], green = [], blue = [];
    for (let index = 0; index < pixels.length; index += 3) {
        red.push(pixels[index] / 255.0);
        green.push(pixels[index + 1] / 255.0);
        blue.push(pixels[index + 2] / 255.0);
    }

    const input = [...red, ...green, ...blue];
    return [input, img_width, img_height];
}

async function run_model(input) {
    const model = await ort.InferenceSession.create(path.join(__dirname, './best-of-best.onnx'));
    input = new ort.Tensor(Float32Array.from(input), [1, 3, 640, 640]);
    const outputs = await model.run({images: input});
    return outputs["output0"].data;
}