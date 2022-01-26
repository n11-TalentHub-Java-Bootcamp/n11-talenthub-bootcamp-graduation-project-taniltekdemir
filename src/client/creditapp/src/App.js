import './App.css';
import React from 'react';
import {Route, Routes} from 'react-router-dom';
import MainPage from "./pages/MainPage";
import Topbar from "./components/Topbar";
import LoginPage from "./pages/LoginPage";
import InfoPage from "./pages/InfoPage";
import RegisterPage from "./pages/RegisterPage";
import InterrogatePage from "./pages/InterrogatePage";

class App extends React.Component{
    constructor(props) {
        super(props);
        this.state = {
            isLoggedOn: false
        }
    }
    login = () =>{
        this.setState({isLoggedOn:true})
    }

    logout = () =>{

        this.setState({isLoggedOn:false})
        sessionStorage.clear();
    }

    getIsLogged(){

        const token = sessionStorage.getItem('token');

        const isLogged = token ? true: false;

        return isLogged;
    }

    render() {
        const isLogged = this.getIsLogged();
        return (
            <div className="App">
                <Topbar isLoggedOn={isLogged} logout={this.logout} ></Topbar>
                <Routes>
                    <Route path="/" element={<MainPage></MainPage>}></Route>
                    <Route path="/login" element={<LoginPage login={this.login}></LoginPage>}></Route>
                    <Route path="/register" element={<RegisterPage></RegisterPage>}></Route>
                    <Route path="/interrogate" element={<InterrogatePage></InterrogatePage>}></Route>
                    <Route path="/info" element={<InfoPage></InfoPage>}></Route>
                </Routes>
            </div>
        );
    }
}

export default App;
