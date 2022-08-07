import React, { useState, useRef } from 'react'
import DatePicker from "react-datepicker";
import "react-datepicker/dist/react-datepicker.css";
import VaccinationCenterService from '../../services/VaccinationCenterService';
import ListVaccinationCenterComponent from '../VaccinationCenter/ListVaccinationCenterComponent';


const DateInput = () => {

    const [selectedDate, setSelectedDate] = useState(new Date());

    const datehandler = (event) => {
        setSelectedDate(event.target.value)

        console.log(selectedDate);
    }

    const handleClick = () => {
        VaccinationCenterService.getAllCentersByDate(selectedDate)
            .then((response) => {
                console.log(response.data);
            })

    }

    return (
        <div>
            <input onChange={datehandler} type="date" id="date" value={selectedDate}></input>
            <button className="btn btn-success" onClick={handleClick}>Submit</button>
        </div>
    )
}

export default DateInput