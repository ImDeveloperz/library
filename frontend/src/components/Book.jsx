import React from 'react';
import {useNavigate} from "react-router-dom";
import useAuth from "../hook/useAuth.js";


const Book = ({imageUrl,titre,Author,date,type,id}) => {
    const navigate=useNavigate()
    const {auth} = useAuth();
    return(
        <div className="bg-white text-black max-w-72 hover: opacity-90 hover:opacity-95 gap-3  rounded-md p-4 flex flex-col  ">
            <div className="flex gap-3">
                <img src={imageUrl} className="w-26 h-44" alt={titre}/>
                <div className="py-2">
                    <p className=" text-[16px] font-semibold">{titre}</p>
                    <p className=" text-[14px] font-semibold">Author : </p>
                    <p className=" text-[12px]  font-medium">{Author}</p>
                    <p className=" text-[14px] font-semibold">Publication</p>
                    <p className=" text-[12px]  font-medium">{date}</p>
                    <p className=" text-[14px] font-semibold">Type</p>
                    <p className=" text-[12px]  font-medium">{type}</p>
                </div>
            </div>
            {
                auth.role == "CLIENT" ?
                    <button
                        className="border bg-[#564592] hover:bg-[#4A4E69] text-white  rounded-md py-2 font-semibold text-[10px] px-8 "
                        onClick={() => {
                            navigate('/bookDetails/' + id, {state: id})
                        }}>Voir Details</button> : null
            }
        </div>
    )
}
export default Book;