import React, {Component} from 'react';
import {Table} from "react-bootstrap";
import {request} from "../apiUtils/ApiUtils";
import Userinfo from "../components/Userinfo";

/**
 * Created at 29.01.2022.
 *
 * @author: Anil Tekdemir
 */

class AllCreditPage extends Component {

    constructor(props) {
        super(props);
        this.state = {
            infoList: [],
        }
    }

    componentDidMount() {
        this.getAllUserInfo();
    }


    getAllUserInfo = () => {
        let self = this;
        let params = {
            url: `users/allInfo`,
            method: "get",
        }
        request(params)
            .then(function (response) {
                if (response.data && response.data.length > 0) {
                    self.setState({ infoList: response.data })
                }
            })
            .catch(function (error) {
            });
    }

    render() {
        return (
            <>
                <div>
                    <br></br>
                    <br></br>
                    <h1>Müşteri Kredi İşlemleri</h1>
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
                            <th>Adı</th>
                            <th>Soyadı</th>
                            <th>Kimlik Numarası</th>
                            <th>Kredi Durumu</th>
                            <th>Kredi Limiti</th>
                            <th>Başvuru Tarihi</th>
                        </tr>
                        </thead>


                        <tbody>

                        {this.state.infoList.map(item => <Userinfo
                                key={this.state.infoList.indexOf(item)}
                                index={this.state.infoList.indexOf(item) + 1}
                                info={item}
                            ></Userinfo>
                        )}

                        </tbody>



                    </Table>
                </div>
            </>
        );
    }
}

export default AllCreditPage;