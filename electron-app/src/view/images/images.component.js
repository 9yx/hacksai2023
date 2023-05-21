import {InboxOutlined, SaveOutlined} from '@ant-design/icons';
import {Badge, Button, Layout, Modal, Popconfirm, Space, Spin, Statistic, Tag, Upload} from 'antd';
import React, {useCallback, useState} from 'react';

const {getDetect, getClass, setClass} = window.electronAPI;

const BadgeSwan = (props) => {
    return (
        <Badge.Ribbon
            text={props.cls}
            color={(() => {
                switch (props.cls) {
                    case "Кликун":
                        return "rgb(14,164,9)";
                    case "Малый":
                        return "rgb(57,12,220)";
                    case "Шипун":
                        return "rgba(225,95,10)";
                    default:
                        return "black"
                }
            })()}
            placement={props.placement}
        >
            {props.children}
        </Badge.Ribbon>
    )
}
const getBase64 = (file) =>
    new Promise((resolve, reject) => {
        const reader = new FileReader();
        reader.readAsDataURL(file);
        reader.onload = () => resolve(reader.result);
        reader.onerror = (error) => reject(error);
    });
export const ImagesUpload = () => {
    const [selectedFile, setSelectedFile] = useState(null);
    const [fileList, setFileList] = useState([]);
    const [loading, setLoading] = useState(false);
    const handleCancel = useCallback(() => {
        const files = [...fileList].map(item => {
            if (item.originFileObj.path === selectedFile.originFileObj.path) return {...selectedFile};
            return item
        });
        setFileList([...files]);
        setSelectedFile(null);
    }, [fileList, selectedFile]);
    const handlePreview = async (file) => {
        if (!file.url && !file.preview) {
            file.preview = await getBase64(file.originFileObj);
        }
        setSelectedFile(file);
    };
    const handleChange = ({fileList: newFileList}) => setFileList(newFileList);
    return (
        <Spin spinning={loading || fileList.some(item => item.status === "uploading")}>
            <Layout>
                <Layout.Header className={"UploadHeader"}>
                    <div className={"logo"}>
                        <img alt={"logo"} src={"./logo.png"}/>
                        <span className={"title"}> ФГБУ "РФИ Минприроды России"</span>
                    </div>
                    <div></div>
                </Layout.Header>
                <Layout.Content className={"UploadContent"}>
                    <div>
                        <Upload.Dragger
                            listType="picture-card"
                            multiple={true}
                            fileList={fileList}
                            directory
                            customRequest={async (options) => {
                                const {onSuccess, onError, file} = options;
                                file["cls"] = await getClass(file.path);
                                try {
                                    onSuccess("ok");
                                } catch (e) {
                                    const error = new Error("Some error");
                                    onError({error});
                                }
                            }}
                            onPreview={handlePreview}
                            onChange={handleChange}
                            itemRender={(originNode, file, fileList, actions) => {
                                return (
                                    <BadgeSwan cls={file.cls} placement={"start"}>
                                        <div style={{padding: "10px 0"}}>
                                            {originNode}
                                        </div>
                                    </BadgeSwan>
                                )
                            }}
                            // beforeUpload={(file) => {
                            //     return {
                            //         ...file,
                            //         cls: "test"
                            //     }
                            //     // return new Promise((resolve) => {
                            //     //     getClass(file.path)
                            //     //         .then((cls) => {
                            //     //             resolve(file)
                            //     //         })
                            //     //         .catch(() => {
                            //     //
                            //     //         });
                            //
                            //
                            //     // const reader = new FileReader();
                            //     // reader.readAsDataURL(file);
                            //     // reader.onload = () => {
                            //     //     const img = document.createElement('img');
                            //     //     img.src = reader.result;
                            //     //     img.onload = () => {
                            //     //         const canvas = document.createElement('canvas');
                            //     //         canvas.width = img.naturalWidth;
                            //     //         canvas.height = img.naturalHeight;
                            //     //         const context = canvas.getContext("2d");
                            //     //         context.fillStyle = "#FF0000";
                            //     //         context.font = '33px Arial';
                            //     //         context.lineWidth = 10;
                            //     //         context.strokeStyle = "#FF0000";
                            //     //         context.drawImage(img, 0, 0);
                            //     //         getClass(file.path).then((detect) => {
                            //     //             console.log(detect)
                            //     //             // if (Array.isArray(detect) && detect.length > 0) {
                            //     //             //     detect.forEach(item => {
                            //     //             //         const [x, y, width, height, cls, pred] = item;
                            //     //             //         context.fillText(`${cls}/${pred}`, x, y - 5);
                            //     //             //         context.strokeRect(x, y, width, height);
                            //     //             //     })
                            //     //             // }
                            //     //             // const imageData = context.getImageData(
                            //     //             //     0,
                            //     //             //     0,
                            //     //             //     canvas.width,
                            //     //             //     canvas.height
                            //     //             // );
                            //     //             // context.putImageData(imageData, 0, 0);
                            //     //             canvas.toBlob((result) => resolve(result));
                            //     //         });
                            //     //     };
                            //     // };
                            //     // })
                            // }}
                        >
                            <p className="ant-upload-drag-icon">
                                <InboxOutlined/>
                            </p>
                            <p className="ant-upload-text">
                                Нажмите или перетащите файл в эту область, чтобы загрузить
                            </p>
                        </Upload.Dragger>
                    </div>
                    {selectedFile && (
                        <Modal
                            open={!!selectedFile}
                            title={selectedFile.name}
                            footer={(
                                <div
                                    style={{
                                        display: "flex",
                                        justifyContent: "space-between"
                                    }}
                                >
                                    <Space wrap size={[0, 8]}>
                                        <Tag
                                            style={{cursor: "pointer"}}
                                            color="rgba(225,95,10)"
                                            onClick={() => setSelectedFile({
                                                ...selectedFile,
                                                cls: "Шипун"
                                            })}
                                        >
                                            Шипун
                                        </Tag>
                                        <Tag
                                            style={{cursor: "pointer"}}
                                            color="rgb(14,164,9)"
                                            onClick={() => setSelectedFile({
                                                ...selectedFile,
                                                cls: "Кликун"
                                            })}
                                        >
                                            Кликун
                                        </Tag>
                                        <Tag
                                            style={{cursor: "pointer"}}
                                            color="rgb(57,12,220)"
                                            onClick={() => setSelectedFile({
                                                ...selectedFile,
                                                cls: "Малый"
                                            })}
                                        >
                                            Малый
                                        </Tag>
                                    </Space>
                                    <Button onClick={handleCancel}>Закрыть</Button>
                                </div>
                            )}
                            onCancel={handleCancel}
                        >
                            <BadgeSwan cls={selectedFile.cls} placement={"start"}>
                                <img alt="example" style={{width: '100%'}}
                                     src={selectedFile.url || selectedFile.preview}/>
                            </BadgeSwan>
                        </Modal>
                    )}
                </Layout.Content>
                <Layout.Footer className={"UploadFooter"}>
                    <Space wrap size={[0, 8]}>
                        <Tag
                            color="rgba(225,95,10)"
                            icon={(
                                <span style={{marginRight: 4}}>
                                    {fileList.filter(item => item.cls === "Шипун").length}
                                </span>
                            )}
                        >
                            Шипун
                        </Tag>
                        <Tag
                            color="rgb(14,164,9)"
                            icon={(
                                <span style={{marginRight: 4}}>
                                    {fileList.filter(item => item.cls === "Кликун").length}
                                </span>
                            )}
                        >
                            Кликун
                        </Tag>
                        <Tag
                            color="rgb(57,12,220)"
                            icon={(
                                <span style={{marginRight: 4}}>
                                    {fileList.filter(item => item.cls === "Малый").length}
                                </span>
                            )}
                        >
                            Малый
                        </Tag>
                    </Space>
                    <div style={{display: "flex", gap: 20}}>
                        <Button
                            icon={<SaveOutlined/>}
                            type={"primary"}
                            disabled={fileList.length === 0}
                            onClick={() => {
                                if (fileList.length === 0) return;
                                setLoading(true);
                                const paths = fileList.map(({originFileObj, cls}) => [cls, originFileObj.path]);
                                setClass(paths).finally(() => {
                                    setLoading(false);
                                });
                            }}
                        >
                            Распределить
                            <span style={{marginLeft: 5}}>({fileList.length ?? ""})</span>
                        </Button>
                        <Popconfirm
                            placement={"leftTop"}
                            title={"Вы точно хотете очистить все загрузки?"}
                            onConfirm={() => setFileList([])}
                        >
                            <Button
                                type={"dashed"}
                                danger
                            >
                                Очистить
                            </Button>
                        </Popconfirm>
                    </div>
                </Layout.Footer>
            </Layout>
        </Spin>
    );
};