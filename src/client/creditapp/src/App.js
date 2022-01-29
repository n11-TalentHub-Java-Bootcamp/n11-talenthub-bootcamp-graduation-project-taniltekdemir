import './App.css';
import React from 'react';
import {Redirect, Route, Switch} from 'react-router-dom';
import MainPage from "./pages/MainPage";
import Topbar from "./components/Topbar";
import LoginPage from "./pages/LoginPage";
import InfoPage from "./pages/InfoPage";
import RegisterPage from "./pages/RegisterPage";
import InterrogatePage from "./pages/InterrogatePage";
import ApplicationPage from "./pages/ApplicationPage";
import UserProfilePage from "./pages/UserProfilePage";
import ApplyCreditPage from "./pages/ApplyCreditPage";
import AllCreditPage from "./pages/AllCreditPage";
import UsersPage from "./pages/UsersPage";

class App extends React.Component{
    constructor(props) {
        super(props);
        this.state = {
            isLoggedOn: false,
            renderKey:  Math.floor((Math.random() * 10) + 1),
        }
    }

    login = () =>{
        this.setState({renderKey:Math.floor((Math.random() * 10) + 1) })
    }

    logout = () =>{
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
            <div className="App" key={this.state.renderKey}>
                <Topbar isLoggedOn={isLogged} logout={this.logout} ></Topbar>
                <Switch>
                    <Route path="/login"                    render={(props) => <LoginPage login={() => this.login()}  {...props}/>}/>
                    <Route exact path="/"                   render={(props) => <MainPage  {...props}/>}/>
                    <Route exact path="/register"           render={(props) => <RegisterPage  {...props}/>}/>
                    <Route exact path="/interrogate"        render={(props) => <InterrogatePage  {...props}/>}/>
                    <Route exact path="/info"               render={(props) => <InfoPage  {...props}/>}/>
                    <Route exact path="/apply"              render={(props) => <ApplicationPage  {...props}/>}/>
                    <Route exact path="/profile"              render={(props) => <UserProfilePage  {...props}/>}/>
                    <Route exact path="/applyWithoutRegistered"              render={(props) => <ApplyCreditPage  {...props}/>}/>
                    <Route exact path="/allUser"              render={(props) => <AllCreditPage  {...props}/>}/>
                    <Route exact path="/userInfos"              render={(props) => <UsersPage  {...props}/>}/>
                    <Redirect to="/"/>
                </Switch>


            </div>
        );
    }
}

export default App;
