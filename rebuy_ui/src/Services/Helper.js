import axios from "axios";

export const BASE_URL='http://localhost:9000';


export const myAxois =axios.create({
    baseURL:BASE_URL
});


