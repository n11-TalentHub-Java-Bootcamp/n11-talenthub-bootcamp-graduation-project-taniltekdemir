import React, {Component} from 'react';
import {Button, Col, Form, FormGroup, Input, Label} from "reactstrap";
import {request} from "../apiUtils/ApiUtils";
import alertify from "alertifyjs";
import InformModal from "../components/InformModal";

/**
 * Created at 27.01.2022.
 *
 * @author: Anil Tekdemir
 */

class ApplicationPage extends Component {

    constructor(props) {
        super(props);
        this.state = {
            salary: "",
            guarantee: "",
            userId: "",
            limit: "",
            content: "",
            modalFlag: false
        }
    }

    saveApply = (e) => {
        let self = this;
        e.preventDefault();
        let payload = {
            salary: this.state.salary,
            guarantee: this.state.guarantee,
            userId: sessionStorage.getItem('currentUserId')
        }
        let params = {
            url: `managers/applyCredit`,
            method: "post",
            data: payload
        }
        request(params)
            .then(function (response) {
                alertify.success("İşlem Başarılı");
                if (response.data.evaluateStatus === "ACCEPTED") {
                    self.setState({content: "ONAYLANDI", limit: response.data.limit, modalFlag: true});
                }else {
                    self.setState({content: "REDEDİLDİ", limit: response.data.limit, modalFlag: true});
                }
            }).catch(function (error) {
            alertify.error(error.response.data);
        })
    }

    editHandleInputChange = (event) => {
        const target = event.target;
        let value = target.value;
        let name = target.name;
        this.setState({[name]: value});
    };

    render() {
        const currentUserName = sessionStorage.getItem('currentUserName');
        return (
            <>
                <div>
                    <br></br>
                    <br></br>
                    <h1>Kredi Başvurusu Sayfası</h1>
                    <br></br>
                    <h3>Sayın <b>{currentUserName}</b> kredi başvurunuz sistemde kayıtlı bilgilerinizle yapılacaktır</h3>
                    <br></br>
                    <br></br>
                </div>
                <div className="container">
                    <Form>
                        <FormGroup row className={"salary"}>
                            <Label sm={4}>Maaş Bilginiz* </Label>
                            <Col sm={8}>
                                <Input
                                    placeholder={"Maaş Bilginizi giriniz."}
                                    className={'name'}
                                    autoComplete="off"
                                    autoFocus
                                    id="salary"
                                    name="salary"
                                    value={this.state.salary}
                                    onChange={this.editHandleInputChange}
                                    type="number" />
                            </Col>

                        </FormGroup>
                        <FormGroup row className={"guarantee"}>
                            <Label sm={4}>Teminat Miktarınız </Label>
                            <Col sm={8}>
                                <Input
                                    placeholder={"Teminat Miktarınızı giriniz."}
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
                            <Button onClick={this.saveApply}>Başvuruyu Gönder
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

export default ApplicationPage;