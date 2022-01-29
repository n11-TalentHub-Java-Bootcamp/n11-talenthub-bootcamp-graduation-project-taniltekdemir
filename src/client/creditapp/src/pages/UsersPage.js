import React, {Component} from 'react';
import {Table} from "react-bootstrap";
import * as PropTypes from "prop-types";
import {request} from "../apiUtils/ApiUtils";
import alertify from "alertifyjs";
import User from "../components/User";
/**
 * Created at 29.01.2022.
 *
 * @author: Anil Tekdemir
 */

class UsersPage extends Component {

    constructor(props) {
        super(props);
        this.state = {
            userList: [],
            selectedUser : "",
        }
    }

    componentDidMount() {
        this.fetchUsers();
    }

    fetchUsers = () => {
        let self = this;
        let params = {
            url: `users`,
            method: "get",
        }
        request(params)
            .then(function (response) {
                if (response.data && response.data.length > 0) {
                    self.setState({ userList: response.data });
                }
            })
            .catch(function (error) {
                alertify.error("Kullanıcı Bilgileri alınamadı")
            });
    }

    render() {
        return (
            <>
                <div>
                    <br></br>
                    <br></br>
                    <h1>Müşteri Listesi</h1>
                    <br></br>
                    <br></br>
                    <br></br>
                    <br></br>
                    <br></br>
                </div>
                <div className="container">
                    <Table striped bordered hover>
                        <thead>
                        <tr>
                            <th>#</th>
                            <th>Kullanıcı No</th>
                            <th>İsim</th>
                            <th>Soyisim</th>
                            <th>Tckn</th>
                            <th>Telefon</th>
                            <th>Email</th>
                            <th>Doğum Tarihi</th>
                        </tr>
                        </thead>


                        <tbody>

                        {this.state.userList.map(item => <User
                                key={this.state.userList.indexOf(item)}
                                userId={this.state.selectedUser}
                                index={this.state.userList.indexOf(item) + 1}
                                info={item}
                            ></User>
                        )}

                        </tbody>


                    </Table>
                </div>
            </>
        );
    }
}

export default UsersPage;