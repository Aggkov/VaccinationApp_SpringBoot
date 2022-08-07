import axios from 'axios'

const VACCINATION_CENTER_BASE_REST_API_URL = 'http://localhost:8080/api/vaccinationCenters';

const VACCINATION_CENTER_AVAILABLE_REST_API_URL = 'http://localhost:8080/api/vaccinationCenters/getAvailable';

class VaccinationCenterService {


    getAllCenters() {
        return axios.get(VACCINATION_CENTER_BASE_REST_API_URL);
    }

    getAllCentersByDate(dateFrom) {
        return axios.get(VACCINATION_CENTER_AVAILABLE_REST_API_URL + '/' + dateFrom);
    }

}

export default new VaccinationCenterService();