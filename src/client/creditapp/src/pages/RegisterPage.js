import React, {Component} from 'react';
import { Button, Col, Form, FormGroup, Input, Label } from "reactstrap";
import Datetime from 'react-datetime';
import moment from 'moment';
import 'moment/locale/tr';
import "react-datetime/css/react-datetime.css";
import {request} from "../apiUtils/ApiUtils";
import alertify from "alertifyjs";
/**
 * Created at 26.01.2022.
 *
 * @author: Anil Tekdemir
 */

class RegisterPage extends Component {

    constructor(props) {
        super(props);
        this.state = {
            name: "",
            surname: "",
            tckn: "",
            dateOfBirth: "",
            phone: "",
            email: "",
            password: "",
            userType: "CUSTOMER"
        }
    }

    editHandleInputChange = (event) => {
        const target = event.target;
        let value = target.value;
        let name = target.name;
        this.setState({ [name]: value });
    };

    saveUser = (e) => {
        e.preventDefault();
        let payload = {
            tckn: this.state.tckn,
            surname: this.state.surname,
            name: this.state.name,
            dateOfBirth: this.state.dateOfBirth,
            telephone: this.state.phone,
            password: this.state.password,
            email: this.state.email,
            userType: this.state.userType
        }
        let params = {
            url: `auth/register`,
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
                                    value={this.state.name}
                                    onChange={this.editHandleInputChange}
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
                                    value={this.state.surname}
                                    onChange={this.editHandleInputChange}
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
                                    minLength={11}
                                    maxLength={11}
                                    value={this.state.tckn}
                                    onChange={this.editHandleInputChange}
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
                                              moment(this.state.dateOfBirth, "YYYY-MM-DD", true).isValid() ?
                                                  moment(this.state.dateOfBirth).format("DD-MM-YYYY") :
                                                  this.state.dateOfBirth
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
                                    minLength={10}
                                    maxLength={10}
                                    value={this.state.phone}
                                    onChange={this.editHandleInputChange}
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
                                    value={this.state.email}
                                    onChange={this.editHandleInputChange}
                                    type="text" />
                            </Col>
                        </FormGroup>
                        <FormGroup row className={"password"}>
                            <Label sm={4}>Parolanız </Label>
                            <Col sm={8}>
                                <Input
                                    placeholder={"Parolanızı giriniz."}
                                    className={'username'}
                                    autoComplete="off"
                                    autoFocus
                                    id="password"
                                    name="password"
                                    value={this.state.password}
                                    onChange={this.editHandleInputChange}
                                    type="password" />
                            </Col>
                        </FormGroup>
                        <div className="text-center">
                            <Button onClick={this.saveUser}>Kaydet
                            </Button>
                        </div>
                    </Form>
                </div>
            </>
        );
    }
}

export default RegisterPage;