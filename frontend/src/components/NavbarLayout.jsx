import React from 'react';
import Navbar from "./Navbar.jsx";
import {useAtom} from "jotai";
import {isActiveLogin, isActiveProfile, isActiveRegister, isNotification} from "../context/GlobalProvider.jsx";

const NavbarLayout = ({children}) => {
    const [isActiveLoged, setIsActiveLogin] = useAtom(isActiveLogin);
    const [isActiveRegisted, setIsActiveRegister] = useAtom(isActiveRegister);
    const [isNotif, setIsNotif] = useAtom(isNotification);
    const [isActiveProfil, setIsActiveProfile] = useAtom(isActiveProfile);

    return(
        <div className={`h-full md:p-0 px-8  relative  ${isActiveLoged || isActiveRegisted ? 'blur' : ''}`} onClick={
            ()=>{
                if(isActiveLoged){
                    setIsActiveLogin(false)
                }
                if(isActiveRegisted){
                    setIsActiveRegister(false)
                }
                if(isNotif){
                    setIsNotif(false)
                }
                if(isActiveProfil){
                    setIsActiveProfile(false)
                }
                console.log('jjj')
            }

        }>
            <div>
                <Navbar/>
            </div>
            {children}
        </div>
    )
};

export default NavbarLayout;