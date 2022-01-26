import React, {Component} from 'react';
import {Col, Modal} from "react-bootstrap";

/**
 * Created at 26.01.2022.
 *
 * @author: Anil Tekdemir
 */

class InformModal extends Component {

    constructor(props) {
        super(props);
        this.state = {}
    }


    render() {
        let title = "Kredi Başvuru Sonucunuz";
        return (
            <Modal show={this.props.modal}
                   animation={false} size={"sm"}
                   toggle={() => {
                       this.setState({}, () => this.props.toggleModal(false, false))
                   }}
                   modalTransition={{timeout: 700}}
                   dialogClassName="modal-90w"
                   backdropTransition={{timeout: 1300}}
                   aria-labelledby="example-custom-modal-styling-title"
                   backdrop="static">
                <Modal.Header>
                    <Modal.Title>
                        <label style={{fontFamily: 'Montserrat', fontWeight: 'normal'}}>{title}</label>
                    </Modal.Title>
                    <div>
                        <button className='fas fa-times simpleButton'
                                style={{
                                    position: 'unset',
                                    right: '0',
                                    top: '0',
                                    outline: '0',
                                    background: 'transparent'
                                }}
                                onClick={(e) => this.props.toggleModal(false, false)}/>
                    </div>
                </Modal.Header>
                <Modal.Body>
                    <p>Kredi sonucunuz: {this.props.content}</p>
                    {this.props.limit && <p>Kredi limitiniz: {this.props.limit}</p>}
                </Modal.Body>
                <Modal.Footer>
                    <Col xs='6' sm='6' md='6' lg='6' style={{textAlign: 'center'}}>
                        <button type="button"
                                style={{background: 'rgb(158, 158, 158)', padding: '11px 45px 11px 20px'}}
                                className="TekBtn vazgec"
                                onClick={() => this.setState({}, () => this.props.toggleModal(false))}>{'Kapat'}
                        </button>
                    </Col>
                </Modal.Footer>
                {this.state.alert}
            </Modal>
        );
    }
}

export default InformModal;