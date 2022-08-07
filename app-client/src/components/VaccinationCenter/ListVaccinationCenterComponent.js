import React, { useEffect, useState } from 'react'
import VaccinationCenterService from '../../services/VaccinationCenterService';
import VaccinationCenterComponent from './VaccinationCenterComponent';

const ListVaccinationCenterComponent = () => {

    const [vaccinationCenters, setVaccinationCenters] = useState([]);

    useEffect(() => {

        getAllCenters();

    }, []);

    const getAllCenters = () => {
        VaccinationCenterService.getAllCenters().then((response) => {
            setVaccinationCenters(response.data);
            // console.log(response.data);
        }).catch(error => {
            console.log(error);
        })
    }

    return (
        <div className="container">
            <h2 className='text-center'>ListVaccinationCenter</h2>
            <table className='table table-bordered table-striped'>
                <thead>
                    <tr>
                        <th>Address</th>
                    </tr>
                </thead>
                <tbody>
                    {
                        vaccinationCenters.map((center) =>
                            <VaccinationCenterComponent key={center.id} id={center.id} address={center.address} />
                        )}
                </tbody>
            </table>
        </div>
    )
}

export default ListVaccinationCenterComponent