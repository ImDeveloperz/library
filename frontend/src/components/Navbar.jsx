import React from 'react';
import logo from '../assets/logo.png'
import useAuth from "../hook/useAuth.js";
import Notification from "./Notification.jsx";
import Profile from "./Profile.jsx";
import { MdLocalGroceryStore } from "react-icons/md";
import {useLocation, useNavigate} from "react-router-dom";
import Store from "./Store.jsx";
const menuBiliothecaire = [
    {label: "Documents", path: "/documents"},
    {label: "Transactions", path: "/transactions"},
    {label: "Statistiques", path: "/statistiques"},
]



const Navbar = () => {
    const user = useAuth();
    const {auth}  = useAuth();
    let location = useLocation();
    const navigation = useNavigate();
    return(
        <div className="flex items-center justify-between py-6 " >
            <div className="flex items-center gap-2">
                <img src={logo} alt="logo" width={40} height={40} />
                <p className="text-sm">biblio</p>
            </div>
            {
                auth?.role == "BIBLIOTHECAIRE" && (
                    <div className="flex gap-5">
                        {
                            menuBiliothecaire.map((item, index) => (
                                <button key={index} onClick={() => navigation(item.path)}
                                        className={`py-3 px-5 text-sm hover:font-bold ${location.pathname === item.path ? "underline  font-bold  " : ""}`}>
                                    {item.label}
                                </button>
                            ))
                        }
                    </div>
                )
            }
            <div className="flex items-center">
                {
                    user?.auth?.email ? (<div className="flex gap-5 items-center">
                        {
                            user?.auth?.role === "CLIENT" && (
                              <>
                                  <Store/>
                                  <Notification/>
                              </>
                            )
                        }
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