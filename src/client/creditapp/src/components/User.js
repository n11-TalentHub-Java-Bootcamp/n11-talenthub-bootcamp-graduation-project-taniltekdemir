import React, {Component} from 'react';
import {request} from "../apiUtils/ApiUtils";
import alertify from "alertifyjs";

/**
 * Created at 30.01.2022.
 *
 * @author: Anil Tekdemir
 */

class User extends Component {

    constructor(props) {
        super(props);
        this.state = {}
    }

    deleteUser = (id) => {
        let self = this;
        let params = {
            url: `users/` + id,
            method: "delete",
        }
        request(params)
            .then(function (response) {
                alertify.error("Kullanıcı Bilgileri silindi")
            })
            .catch(function (error) {
                alertify.error("Kullanıcı silinemedi. Kredi Başvurusu olan kullanıcıları silemezsiniz.")
            });
    }

    render() {
        return (
            <>
                <tr>
                    <td>
                        {this.props.index}
                    </td>
                    <td>
                        {this.props.info.id}
                    </td>
                    <td>
                        {this.props.info.name}
                    </td>
                    <td>
                        {this.props.info.surname}
                    </td>
                    <td>
                        {this.props.info.tckn}
                    </td>
                    <td>
                        {this.props.info.telephone}
                    </td>
                    <td>
                        {this.props.info.email}
                    </td>
                    <td>
                        {this.props.info.dateOfBirth}
                    </td>
                    <td>
                        <button type="button" className="btn btn-danger" onClick={() => this.deleteUser(this.props.info.id)}>Sil</button>
                    </td>
                </tr>
            </>
        );
    }
}

export default User;