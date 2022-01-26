import React, {Component} from 'react';
import {request} from "../apiUtils/ApiUtils";
import alertify from "alertifyjs";

/**
 * Created at 26.01.2022.
 *
 * @author: Anil Tekdemir
 */

class LoginPage extends Component {

    constructor(props) {
        super(props);
        this.state = {
            username: "",
            password: ""
        }
    }

    handleFormSubmit = (e) => {
        let self = this;
        e.preventDefault();
        let payload = {
            username: self.state.username,
            password: self.state.password
        }
        let params = {
            url: `auth/login`,
            method: "post",
            data: payload
        }
        request(params)
            .then(function (response) {
                alertify.success("Giriş Başarılı");
                sessionStorage.setItem('token', response.data.token);
                sessionStorage.setItem('currentUserId', response.data.currentUserId);
                sessionStorage.setItem('currentUserName', response.data.currentUserName);
                self.props.login();
                self.props.history.push("/");
            }).catch(function (error) {
            alertify.error("Hatalı işlem");
        })
    }


    render() {
        return (
            <>
                <div className="container">
                    <div className="text-center mt-5">
                        <div className="row col-md-4 offset-md-4">

                            <form className="form-signin" onSubmit={this.handleFormSubmit}>

                                <h1 className="h3 mb-3 font-weight-normal">Giriş</h1>

                                <label htmlFor="inputEmail" className="sr-only">Kimlik Numaranız</label>
                                <input
                                    type="tckn"
                                    id="inputTckn"
                                    className="form-control"
                                    placeholder="Kimlik Numaranız"
                                    required=""
                                    autoFocus=""
                                    value={this.state.username}
                                    name="tckn"
                                    onChange={event => this.setState({username: event.target.value})}
                                />

                                <label htmlFor="inputPassword" className="sr-only">Şifre</label>
                                <input
                                    type="password"
                                    id="inputPassword"
                                    className="form-control"
                                    placeholder="Şifreniz"
                                    required=""
                                    value={this.state.password}
                                    name="password"
                                    onChange={event => this.setState({password: event.target.value})}
                                />

                                <input type="submit" className="btn btn-danger btn-block" value="Giriş" />
                                <p className="mt-5 mb-3 text-muted">© Kredi Sistemi 2022</p>
                            </form>
                        </div>
                    </div>
                </div>
            </>
        );
    }
}

export default LoginPage;