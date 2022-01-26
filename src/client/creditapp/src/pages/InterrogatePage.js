import React, {Component} from 'react';
import {request} from "../apiUtils/ApiUtils";
import Datetime from 'react-datetime';
import moment from 'moment';
import 'moment/locale/tr';
import "react-datetime/css/react-datetime.css";
import InformModal from "../components/InformModal";
import alertify from "alertifyjs";

/**
 * Created at 26.01.2022.
 *
 * @author: Anil Tekdemir
 */

class InterrogatePage extends Component {

    constructor(props) {
        super(props);
        this.state = {
            tckn: "",
            dateOfBirth: "",
            limit: "",
            content: "",
            modalFlag: false
        }
    }

    editHandleInputChange = (event) => {
        const target = event.target;
        let value = target.value;
        let name = target.name;
        this.setState({[name]: value});
    };

    handleFormSubmit = (e) => {
        let self = this;
        e.preventDefault();
        let payload = {
            tckn: this.state.tckn,
            dateOfBirth: this.state.dateOfBirth
        }
        let params = {
            url: `managers/interrogate`,
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
            alertify.error("Hatalı bilgilerle sorgu yapıyorsunuz.");

        })
    }


    render() {
        return (
            <>
                <div className="container">
                    <div className="text-center mt-5">
                        <div className="row col-md-4 offset-md-4">

                            <form className="form-signin" onSubmit={this.handleFormSubmit}>

                                <h1 className="h3 mb-3 font-weight-normal">Kredi Başvuru Sorgulama</h1>

                                <label htmlFor="inputEmail" className="sr-only">Kimlik Numaranız</label>
                                <input
                                    type="tckn"
                                    id="inputTckn"
                                    className="form-control"
                                    placeholder="Kimlik Numaranız"
                                    required=""
                                    autoFocus=""
                                    value={this.state.tckn}
                                    name="tckn"
                                    onChange={event => this.setState({tckn: event.target.value})}
                                />

                                <label htmlFor="dateOfBirth" className="sr-only">Doğum Tarihiniz</label>
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

                                <input type="submit" className="btn btn-danger btn-block" value="Sorgula"/>
                                <p className="mt-5 mb-3 text-muted">© Kredi Sistemi 2022</p>
                            </form>
                        </div>
                    </div>
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

export default InterrogatePage;