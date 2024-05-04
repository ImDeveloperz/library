import React from 'react';
import logo from '../assets/logo.png'
import useAuth from "../hook/useAuth.js";
import Notification from "./Notification.jsx";
import Profile from "./Profile.jsx";
const Navbar = () => {
    const user = useAuth();
    console.log(user.auth)
    return(
        <div className="flex items-center justify-between py-6 " >
            <div className="flex items-center gap-2">
                <img src={logo} alt="logo" width={40} height={40} />
                <p className="text-sm">biblio</p>
            </div>
            <div>
                {
                    user?.auth?.email ? (<div className="flex gap-5">
                    <Notification/>
                    <Profile/>
                    </div>) : (<button
                        className="py-3 px-5 font-light text-sm hover:font-bold  hover:bg-[#564592] border-[#564592] border rounded-md bg-none ">
                        Se Connecter
                    </button>)
                }
            </div>
        </div>

    );
}

export default Navbar;