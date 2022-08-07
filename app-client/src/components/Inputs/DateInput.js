import React, { useState, useRef } from 'react'
import { useHistory, Link } from 'react-router-dom';
import "react-datepicker/dist/react-datepicker.css";
import VaccinationCenterService from '../../services/VaccinationCenterService';

const DateInput = () => {

    const [selectedDate, setSelectedDate] = useState();

    // const dateRef = useRef();
    const history = useHistory();


    const handleDate = function (event) {

        setSelectedDate(event.target.value);
        console.log(selectedDate);

    }

    const handleClick = () => {
        // <Link to={"/getAvailable" + "/" + dateRef}></Link>

        history.push(`/getAvailable/${selectedDate}`);
    }

    return (
        <div>
            <input onChange={handleDate} type="date" id="date"></input>
            <button type='button' className="btn btn-success" onClick={handleClick}>Submit</button>
        </div>
    )
}


export default DateInput