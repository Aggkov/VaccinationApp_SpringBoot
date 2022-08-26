import React from 'react';
import { useHistory, Link } from 'react-router-dom';

const Home = () => {
    return (
        <div>
            <div>Home</div>
            <Link to={"/profile"} >
                MyProfile
            </Link>
        </div>
    )
}

export default Home