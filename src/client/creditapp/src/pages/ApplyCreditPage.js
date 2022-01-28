import React, {Component} from 'react';
import {Button, Col, Form, FormGroup, Input, Label} from "reactstrap";
import Datetime from "react-datetime";
import moment from "moment";
import {request} from "../apiUtils/ApiUtils";
import alertify from "alertifyjs";
import InformModal from "../components/InformModal";

/**
 * Created at 28.01.2022.
 *
 * @author: Anil Tekdemir
 */

class ApplyCreditPage extends Component {

    constructor(props) {
        super(props);
        this.state = {
            name: "",
            surname: "",
            tckn: "",
            dateOfBirth: "",
            phone: "",
            userType: "CUSTOMER",
            salary: "",
            guarantee: "",
            email: "",
            limit: "",
            content: "",
            modalFlag: false
        }
    }

    editHandleInputChange = (event) => {
        const target = event.target;
        let value = target.value;
        let name = target.name;
        this.setState({ [name]: value });
    };

    saveApply = (e) => {
        let self = this;
        e.preventDefault();
        let payload = {
            tckn: this.state.tckn,
            surname: this.state.surname,
            name: this.state.name,
            dateOfBirth: this.state.dateOfBirth,
            telephone: this.state.phone,
            userType: this.state.userType,
            email: this.state.email,
            salary: this.state.salary,
            guarantee: this.state.guarantee,
        }
        let params = {
            url: `managers/applyCreditWithoutRegistered`,
            method: "post",
            data: payload
        }
        request(params)
            .then(function (response) {
                if (response.data.evaluateStatus === "ACCEPTED") {
                    self.setState({content: "ONAYLANDI", limit: response.data.limit, modalFlag: true});
                }else {
                    self.setState({content: "REDEDİLDİ", limit: response.data.limit, modalFlag: true});
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
                    <h1>Kredi Başvuru Sayfası</h1>
                    <br></br>
                    <h3>Kimlik numaranızı parola olarak kullanarak sisteme giriş yapabilirsiniz.</h3>
                    <br></br>
                    <br></br>
                </div>
                <div className="container">
                    <Form>
                        <FormGroup row className={"name"}>
                            <Label sm={4}>Adınız *</Label>
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
                            <Label sm={4}>Soyadınız *</Label>
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
                            <Label sm={4}>Kimlik Numaranız *</Label>
                            <Col sm={8}>
                                <Input
                                    placeholder={"Kimlik Numaranızı giriniz."}
                                    className={'tckn'}
                                    autoComplete="off"
                                    autoFocus
                                    id="tckn"
                                    name="tckn"
                                    maxLength={11}
                                    minLength={11}
                                    value={this.state.tckn}
                                    onChange={this.editHandleInputChange}
                                    type="text" />
                            </Col>
                        </FormGroup>
                        <FormGroup row className={"dateOfBirth"}>
                            <Label sm={4}>Doğum Tarihiniz *</Label>
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
                            <Label sm={4}>Telefon Numaranız *</Label>
                            <Col sm={8}>
                                <Input
                                    placeholder={"Telefon Numaranızı giriniz."}
                                    className={'phone'}
                                    autoComplete="off"
                                    autoFocus
                                    id="phone"
                                    name="phone"
                                    maxLength={10}
                                    minLength={10}
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
                        <FormGroup row className={"email"}>
                            <Label sm={4}>Maaş Bilginiz * </Label>
                            <Col sm={8}>
                                <Input
                                    placeholder={"Maaş bilginizi giriniz."}
                                    className={'salary'}
                                    autoComplete="off"
                                    autoFocus
                                    id="salary"
                                    name="salary"
                                    value={this.state.salary}
                                    onChange={this.editHandleInputChange}
                                    type="number" />
                            </Col>
                        </FormGroup>
                        <FormGroup row className={"email"}>
                            <Label sm={4}>Teminat bilginizi giriniz </Label>
                            <Col sm={8}>
                                <Input
                                    placeholder={"Varsa Teminat miktarını giriniz."}
                                    className={'guarantee'}
                                    autoComplete="off"
                                    autoFocus
                                    id="guarantee"
                                    name="guarantee"
                                    value={this.state.guarantee}
                                    onChange={this.editHandleInputChange}
                                    type="number" />
                            </Col>
                        </FormGroup>
                        <div className="text-center">
                            <Button onClick={this.saveApply}>Başvuru Yap
                            </Button>
                        </div>
                    </Form>
                </div>
                {this.state.modalFlag &&
                <InformModal content={this.state.content}
                             limit={this.state.limit}
                             toggleModal={(flag) => this.setState({modalFlag: flag})}
                             modal={this.state.modalFlag}
                />
                }
            </>
        );
    }
}

export default ApplyCreditPage;