import './App.css';
import {ImagesUpload} from "./images/images.component";
import {ConfigProvider} from "antd";

function App() {
    return (
        <div className="App">
            <ConfigProvider
                theme={{
                    token: {
                        colorPrimary: '#88a10e',
                        colorError:"#dc3545"
                    },
                }}>
                <ImagesUpload/>
            </ConfigProvider>
        </div>
    );
}

export default App;
