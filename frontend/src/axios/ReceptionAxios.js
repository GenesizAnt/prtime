import axios from 'axios'

const host = require('../axios/host.js');
const RECEPTION_BASE_URL = host.BASE_URL + "/receptions";

class ReceptionAxios {
    getAllReceptions() {
        return axios.get(RECEPTION_BASE_URL);
    }

    getAllReceptionsFilter(filter) {
        return axios.get(RECEPTION_BASE_URL, { params: { filter: filter } });
    }

    createReception(receptionDTO) {
        return axios.post(RECEPTION_BASE_URL, receptionDTO);
    }

    getReceptionById(receptionId) {
        return axios.get(`${RECEPTION_BASE_URL}/${receptionId}`)
    }

    editReception(receptionId, editingReception) {
        return axios.patch(`${RECEPTION_BASE_URL}/${receptionId}`, editingReception)
    }

    removeReception(receptionId) {
        return axios.delete(`${RECEPTION_BASE_URL}/${receptionId}`)
    }
}

export default new ReceptionAxios();