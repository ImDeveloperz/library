import React, {useEffect, useState} from 'react';
import {Dropdown, DropdownTrigger, DropdownMenu, DropdownItem, Button, Avatar} from "@nextui-org/react";
import useAuth from "../hook/useAuth.js";
import axios from "../api/axios.js";
import { MdEmail,MdSettings } from "react-icons/md";
import { IoLogOut } from "react-icons/io5";
import {useAtom} from "jotai";
import {isActiveProfile} from "../context/GlobalProvider.jsx";
import {Divider} from "@nextui-org/divider";
import { CgProfile } from "react-icons/cg";
import { TbLogout2 } from "react-icons/tb";
const Profile = () => {
    const {auth} = useAuth();
    console.log(auth)
    const [user, setUser] = useState({});
    const [isActiveProfil, setIsActiveProfile] = useAtom(isActiveProfile);
    //get user
    const  getUser = async () => {
        try{
            const response = await axios.get('/users/user?email='+auth.email,{
                headers:{
                    'Authorization': 'Bearer ' + auth.token,
                }
            });
            setUser(response.data.utilisateur);
        }catch (error){
            console.log(error)
        }
    }
    useEffect(() => {
           getUser().then(r => r).catch(e => e);
    }, [auth]);
    return(
        <div className="relative">
            <div>
                <Avatar showFallback isBordered color="secondary" onClick={() => {
                    setIsActiveProfile(!isActiveProfil)
                }} src='https://images.unsplash.com/broken'/>
            </div>
            {isActiveProfil ?
                <div className="min-w-72 text-black bg-white rounded-md  right-[2px] top-14 z-10 absolute pb-3  pt-4 flex flex-col ">
                    <div className="triangle absolute  -top-2 right-0"></div>
                    <div className='flex gap-3  px-6'>
                        <Avatar showFallback isBordered color="secondary" src='https://images.unsplash.com/broken'/>
                        <div>
                            <p className="text-[14px] font-semibold ">{user.nom} {user.prenom}</p>
                            <p className="font-medium text-[10px] ">{user.role}</p>
                        </div>
                    </div>
                    <Divider className="my-4"/>
                    <div className="flex  flex-col">
                        <div className="flex cursor-pointer p-2 hover:bg-gray-300 text-[14px] font-medium items-center px-6 gap-2 ">
                            <CgProfile className="text-[18px] font-bold "/>
                            <p>Profile</p>
                        </div>
                        <div className="flex   cursor-pointer hover:bg-gray-300  text-[14px] p-2 font-medium  items-center px-6 gap-2 ">
                            <MdSettings className="text-[18px] "/>
                            <p>Manage Votre Acount</p>
                        </div>
                    </div>
                    <Divider className="my-4"/>
                    <div className="flex text-[14px] font-medium gap-2 cursor-pointer p-2 hover:bg-gray-300  items-center px-6">
                        <TbLogout2 className="text-[18px] "/>
                        <p>Deconnecter</p>
                    </div>
                </div> : null
            }
        </div>
    )
}

export default Profile;