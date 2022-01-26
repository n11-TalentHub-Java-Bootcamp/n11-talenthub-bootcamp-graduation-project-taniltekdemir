import React, {Component} from 'react';

/**
 * Created at 25.01.2022.
 *
 * @author: Anil Tekdemir
 */

class MainPage extends Component {

    constructor(props) {
        super(props);
        this.state = {}
    }


    render() {
        return (
            <div className="container">
                <div className="text-center mt-5">
                    <h1>n11 Java Bootcamp</h1>
                    <p>Kredi Başvuru Sistemi Proje Uygulaması</p>
                    <p>React & Spring Boot</p>
                </div>
            </div>
        );
    }
}

export default MainPage;