import React, {Component} from 'react';

/**
 * Created at 29.01.2022.
 *
 * @author: Anil Tekdemir
 */

class Userinfo extends Component {

    constructor(props) {
        super(props);
        this.state = {}
    }


    render() {
        return (
            <>
                <tr>
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
                        {this.props.info.evaluateStatus === "ACCEPTED" ? "ONAYLANDI" : "RED"}
                    </td>
                    <td>
                        {this.props.info.limit} TL
                    </td>
                    <td>
                        {this.props.info.recordDate}
                    </td>
                </tr>
            </>
        );
    }
}

export default Userinfo;