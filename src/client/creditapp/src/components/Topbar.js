import React, {Component} from 'react';
import {Button, Container, Form, FormControl, Nav, Navbar, NavDropdown} from "react-bootstrap";


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


    render() {
        return (
            <div className="col-md-6 offset-md-3 ">
                <Navbar bg="light" expand="lg">
                    <Container>
                        <Navbar.Brand href="/">N Kredi Sistemi</Navbar.Brand>
                        <Navbar.Toggle aria-controls="basic-navbar-nav"/>
                        <Navbar.Collapse id="basic-navbar-nav">
                            <Nav className="me-auto">
                                <Nav.Link href="/">Anasayfa</Nav.Link>
                                <Nav.Link href="/register">Kayıt Ol</Nav.Link>
                                <Nav.Link href="/interrogate">Başvuru Sonucu Öğren</Nav.Link>
                                <NavDropdown title="İşlemler" id="basic-nav-dropdown">
                                    <NavDropdown.Item href="/info">Kredi Oranları</NavDropdown.Item>
                                    <NavDropdown.Item href="/info">Kredi Başvuru Şartları</NavDropdown.Item>
                                    <NavDropdown.Item href="/">Kullanıcı Bilgileri</NavDropdown.Item>

                                    <NavDropdown.Divider/>
                                    {!this.props.isLoggedOn &&
                                    < NavDropdown.Item href="/login">Giriş</NavDropdown.Item>}
                                    {this.props.isLoggedOn &&
                                    <NavDropdown.Item href="/" onClick={this.handleLogout}>Çıkış</NavDropdown.Item>}

                                </NavDropdown>
                            </Nav>
                        </Navbar.Collapse>
                    </Container>
                </Navbar>
            </div>
        );
    }
}

export default Topbar;