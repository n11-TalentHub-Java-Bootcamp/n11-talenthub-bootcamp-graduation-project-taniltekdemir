import React, {Component} from 'react';
import {Button, Col, Form, FormGroup, Input, Label} from "reactstrap";
import Datetime from "react-datetime";
import moment from "moment";
import {request} from "../apiUtils/ApiUtils";
import alertify from "alertifyjs";

/**
 * Created at 27.01.2022.
 *
 * @author: Anil Tekdemir
 */

class UserProfilePage extends Component {

    constructor(props) {
        super(props);
        this.state = {
            user: {
                name: "",
                surname: "",
                tckn: "",
                dateOfBirth: "",
                telephone: "",
                email: ""
            }
        }
    }

    componentDidMount() {
        this.getUserInfo();
    }

    editHandleInputChange = (e) => {
        let {name, value, type} = e.target;
        let user = this.state.user;
        user[name]= value;
        this.setState({ user });
    };

    updateUser = (e) => {
        e.preventDefault();
        let payload = {
            id: sessionStorage.getItem('currentUserId'),
            tckn: this.state.user.tckn,
            surname: this.state.user.surname,
            name: this.state.user.name,
            dateOfBirth: this.state.user.dateOfBirth,
            telephone: this.state.user.telephone,
            password: this.state.user.password,
            email: this.state.user.email,
            userType: "CUSTOMER"
        }
        let params = {
            url: `users/updateUser`,
            method: "post",
            data: payload
        }
        request(params)
            .then(function (response) {
                alertify.success("Kullanıcı kaydedildi");
            }).catch(function (error) {
            alertify.error(error.response.data);
        })
    }

    getUserInfo = () =>{
        let self = this;
        let userId = sessionStorage.getItem('currentUserId');
        let params = {
            url: `users/` + userId,
            method: "get",
        }
        request(params)
            .then(function (response) {
                if(response.data && response.data != null) {
                    self.setState({user: response.data})
                }
            }).catch(function (error) {
            alertify.error(error.response.data);
        })
    }


    render() {
        return (
            <>
                <div>
                    <br></br>
                    <br></br>
                    <h1>Kullanıcı Kayıt Sayfası</h1>
                    <br></br>
                    <br></br>
                    <br></br>
                </div>
                <div className="container">
                    <Form>
                        <FormGroup row className={"name"}>
                            <Label sm={4}>Adınız </Label>
                            <Col sm={8}>
                                <Input
                                    placeholder={"Adınızı giriniz."}
                                    className={'name'}
                                    autoComplete="off"
                                    autoFocus
                                    id="name"
                                    name="name"
                                    value={this.state.user.name}
                                    onChange={(e) => this.editHandleInputChange(e)}
                                    type="text" />
                            </Col>

                        </FormGroup>
                        <FormGroup row className={"surname"}>
                            <Label sm={4}>Soyadınız </Label>
                            <Col sm={8}>
                                <Input
                                    placeholder={"Soyadınızı giriniz."}
                                    className={'surname'}
                                    autoComplete="off"
                                    autoFocus
                                    id="surname"
                                    name="surname"
                                    value={this.state.user.surname}
                                    onChange={(e) => this.editHandleInputChange(e)}
                                    type="text" />
                            </Col>
                        </FormGroup>
                        <FormGroup row className={"tckn"}>
                            <Label sm={4}>Kimlik Numaranız </Label>
                            <Col sm={8}>
                                <Input
                                    placeholder={"Kimlik Numaranızı giriniz."}
                                    className={'tckn'}
                                    autoComplete="off"
                                    autoFocus
                                    id="tckn"
                                    name="tckn"
                                    value={this.state.user.tckn}
                                    onChange={(e) => this.editHandleInputChange(e)}
                                    type="text" />
                            </Col>
                        </FormGroup>
                        <FormGroup row className={"dateOfBirth"}>
                            <Label sm={4}>Doğum Tarihiniz </Label>
                            <Col sm={8}>
                                <Datetime locale="tr"
                                          className="datepicker"
                                          input={true}
                                          closeOnSelect={true}
                                          value={
                                              moment(this.state.user.dateOfBirth, "YYYY-MM-DD", true).isValid() ?
                                                  moment(this.state.user.dateOfBirth).format("DD-MM-YYYY") :
                                                  this.state.user.dateOfBirth
                                          }
                                          dateFormat="DD-MM-YYYY"
                                          timeFormat={false}
                                          onChange={e => {
                                              this.editHandleInputChange({
                                                  target: {
                                                      name: 'dateOfBirth',
                                                      value: (e && moment(e, "YYYY-MM-DD", true).isValid()) ? moment(e).format("YYYY-MM-DD") : null
                                                  }
                                              });
                                          }}
                                />
                            </Col>
                        </FormGroup>
                        <FormGroup row className={"phone"}>
                            <Label sm={4}>Telefon Numaranız </Label>
                            <Col sm={8}>
                                <Input
                                    placeholder={"Telefon Numaranızı giriniz."}
                                    className={'phone'}
                                    autoComplete="off"
                                    autoFocus
                                    id="phone"
                                    name="phone"
                                    value={this.state.user.telephone}
                                    onChange={(e) => this.editHandleInputChange(e)}
                                    type="text" />
                            </Col>
                        </FormGroup>
                        <FormGroup row className={"email"}>
                            <Label sm={4}>E-Posta Adresiniz </Label>
                            <Col sm={8}>
                                <Input
                                    placeholder={"E-Posta Adresinizi giriniz."}
                                    className={'email'}
                                    autoComplete="off"
                                    autoFocus
                                    id="email"
                                    name="email"
                                    value={this.state.user.email}
                                    onChange={(e) => this.editHandleInputChange(e)}
                                    type="text" />
                            </Col>
                        </FormGroup>
                        <div className="text-center">
                            <Button onClick={this.updateUser}>Değişiklikleri Kaydet
                            </Button>
                        </div>
                    </Form>
                </div>
            </>
        );
    }
}

export default UserProfilePage;