const path = require('path');
const fs = require('fs');

const {app, BrowserWindow, ipcMain} = require('electron');
const isDev = (process.argv || []).indexOf('--dev') !== -1


const detect_objects_on_image = require("./models/detect/module");
const class_objects_on_image = require("./models/cls/module");

function createWindow() {
    // Create the browser window.
    const win = new BrowserWindow({
        width: 750,
        height: 880,
        webPreferences: {
            nodeIntegration: true,
            preload: path.join(__dirname, 'preload.js')
        },
    });

    // and load the index.html of the app.
    // win.loadFile("index.html");
    win.loadURL(
        isDev
            ? 'http://localhost:3000'
            : `file://${path.join(__dirname, './index.html')}`
    );
    // Open the DevTools.
    if (isDev) {
        win.webContents.openDevTools({mode: 'detach'});
    }
}

const getDetect = async (event, filePath) => {
    const buf = fs.readFileSync(filePath);
    return detect_objects_on_image(buf);
}

const getClass = async (event, filePath) => {
    const buf = fs.readFileSync(filePath);
    return class_objects_on_image(buf);
}

const setClass = async (event, fileClassPath) => {
    const copyList = fileClassPath.map(([cls, pth]) => {
        const dirName = path.dirname(pth);
        const fileName = path.basename(pth);
        const clsPath = path.join(dirName, cls, fileName);
        return [pth, clsPath]
    });
    return Promise.all(copyList.map(([pth, clsPath]) => fs.cpSync(pth, clsPath, {recursive: true})));
}
app.whenReady().then(() => {
    createWindow();
});

ipcMain.handle('get-detect', getDetect);

ipcMain.handle('get-class', getClass);

ipcMain.handle('set-class', setClass);
app.on('window-all-closed', () => {
    if (process.platform !== 'darwin') {
        app.quit();
    }
});
app.on('activate', () => {
    if (BrowserWindow.getAllWindows().length === 0) {
        createWindow();
    }
});