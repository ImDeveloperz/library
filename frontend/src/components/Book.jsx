import React from 'react';

const Book = ({imageUrl,titre,Author,date,type}) => {
    return(
        <div className="bg-white text-black max-w-72 hover: opacity-90 hover:opacity-95 gap-3  rounded-md p-4 flex flex-col  ">
            <div className="flex gap-3">
                <img src={imageUrl} alt={titre}/>
                <div className="py-2">
                    <p className=" text-[16px] font-semibold">{titre}</p>
                    <p className=" text-[14px] font-semibold">Author : </p>
                    <p className=" text-[12px]  font-medium">{Author}</p>
                    <p className=" text-[14px] font-semibold">Publication</p>
                    <p className=" text-[12px]  font-medium">{date}</p>
                    <p className="   text-[14px] font-semibold">Type</p>
                    <p className=" text-[12px]  font-medium">{type}</p>
                </div>
            </div>
            <button className="border bg-[#564592] hover:bg-[#4A4E69] text-white  rounded-md py-2 font-semibold text-[10px] px-8 ">Voir Details</button>
        </div>
    )
}
export default Book;