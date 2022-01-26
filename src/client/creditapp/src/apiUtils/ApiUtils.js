import axios from "axios";

export function request(options, headers) {
    let defaultHeaders = {
        'Content-Type': 'application/json;charset=UTF-8'
    };

    defaultHeaders = Object.assign(defaultHeaders, headers);

    if (sessionStorage.getItem("token")) {
        defaultHeaders['Authorization'] = sessionStorage.getItem("token");
    }

    const defaults = {headers: defaultHeaders, baseURL: "/"};
    options = Object.assign({}, defaults, options);

    return axios(options);
}