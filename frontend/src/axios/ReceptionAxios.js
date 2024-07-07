import axios from 'axios'

const host = require('../axios/host.js');
const RECEPTION_BASE_URL = host.BASE_URL + "/schedule/receptions";

class ReceptionAxios {
    getAllReceptions() {
        return axios.get(RECEPTION_BASE_URL);
    }
}

export default new ReceptionAxios();