import React from 'react'

const VaccinationCenterComponent = (props) => {

    return (
        <tr>
            <td>{props.id}</td>
            <td>{props.address}</td>
            {/* button for selecting center */}
        </tr>
    )
}

export default VaccinationCenterComponent