const { contextBridge, ipcRenderer } = require('electron')

contextBridge.exposeInMainWorld('electronAPI', {
    getDetect: (filePath) => ipcRenderer.invoke('get-detect', filePath),
    getClass: (filePath) => ipcRenderer.invoke('get-class', filePath),
    setClass: (filePaths) => ipcRenderer.invoke('set-class', filePaths)
})