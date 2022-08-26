import React from 'react';
import { useEffect, useState } from 'react'
import AuthService from '../services/auth.service';

const Profile = () => {
    const [userInfo, setUserInfo] = useState(null);

    useEffect(() => {

        getUserInfo();

    }, []);

    const getUserInfo = () => AuthService.getCurrentUser()
        .then((response) => {
            setUserInfo({
                firstName: response.data.firstName,
                lastName: response.data.lastName,
                email: response.data.email,
                afm: response.data.afm
            });

        }).catch(error => {
            console.log(error);
        });
    return (
        <div>
            <header className="jumbotron">
                <h3>
                    <strong>{userInfo && userInfo.firstName}</strong> Profile
                </h3>
                <h3>{userInfo && userInfo.lastName}</h3>
            </header>
            <p>
                <strong>Email:</strong> {userInfo && userInfo.email}
            </p>
            <p>
                AFM: {userInfo && userInfo.afm}
            </p>
            {/* <strong>Authorities:</strong>
            <ul>
                {currentUser.roles &&
                    currentUser.roles.map((role, index) => <li key={index}>{role}</li>)}
            </ul> */}
            <button type='button' className="btn btn-success">Make a reservation</button>
        </div>
    )
}

export default Profile