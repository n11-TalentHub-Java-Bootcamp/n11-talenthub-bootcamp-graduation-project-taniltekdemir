import React, {Component} from 'react';
import {Container, Nav, Navbar, NavDropdown} from "react-bootstrap";


/**
 * Created at 25.01.2022.
 *
 * @author: Anil Tekdemir
 */

class Topbar extends Component {

    constructor(props) {
        super(props);
        this.state = {}
    }

    handleLogout = () =>{
        this.props.logout();
    }
    render() {
        const currentUserName = sessionStorage.getItem('currentUserName');
        return (
            <div className="col-md-6 offset-md-3 ">
                <Navbar bg="light" expand="lg">
                    <Container>
                        <Navbar.Brand href="/">N Kredi Sistemi</Navbar.Brand>
                        <Navbar.Toggle aria-controls="basic-navbar-nav"/>
                        <Navbar.Collapse id="basic-navbar-nav">
                            <Nav className="me-auto">
                                {!this.props.isLoggedOn && <Nav.Link href="/">Anasayfa</Nav.Link>}
                                {this.props.isLoggedOn && <Nav.Link href="/apply">Kredi Başvursu Yap</Nav.Link>}
                                {!this.props.isLoggedOn && <Nav.Link href="/register">Kayıt Ol</Nav.Link>}
                                {!this.props.isLoggedOn && <Nav.Link href="/applyWithoutRegistered">Kredi Başvurusun Yap</Nav.Link>}
                                <Nav.Link href="/interrogate">Başvuru Sonucu Öğren</Nav.Link>
                                <NavDropdown title="Kullancı İşlemleri" id="basic-nav-dropdown">
                                    {this.props.isLoggedOn && <NavDropdown.Item href="/profile">Kullanıcı Bilgileri</NavDropdown.Item>}
                                    {this.props.isLoggedOn && <NavDropdown.Divider/>}
                                    {!this.props.isLoggedOn &&
                                    < NavDropdown.Item href="/login">Giriş</NavDropdown.Item>}
                                    {this.props.isLoggedOn &&
                                    <NavDropdown.Item href="/" onClick={this.handleLogout}>Çıkış</NavDropdown.Item>}
                                </NavDropdown>
                                {this.props.isLoggedOn &&
                                <h5 style={{paddingLeft: '25px'}}>Hoşgeldin {currentUserName} </h5>}
                            </Nav>
                        </Navbar.Collapse>
                    </Container>
                </Navbar>
            </div>
        );
    }
}

export default Topbar;