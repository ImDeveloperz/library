import React, {useState} from 'react';
import {Avatar} from "@nextui-org/react";
import {Divider} from "@nextui-org/divider";
import {IoMdNotifications} from "react-icons/io";
import {MdLocalGroceryStore} from "react-icons/md";
import {useAtom} from "jotai";
import {isStoreActive} from "../context/GlobalProvider.jsx";

const Store = (props) => {
    const [transactions, transaction] = useState([]);
    const [isStoreActivee, setIsStoreActive] = useAtom(isStoreActive);
    return (
        <div className="relative flex items-center">
            <div>
                <MdLocalGroceryStore className="text-[1.6rem] cursor-pointer " onClick={() => {
                    setIsStoreActive(!isStoreActivee)
                }}/>
            </div>
            {isStoreActivee ?
                <>
                    <div className="triangle absolute  top-10 -right-1"></div>
                    <div
                        className="min-w-72 max-h-96 overflow-scroll z-40 text-black bg-white rounded-md md:-right-[4px] -right-[12px]  top-12  absolute pb-4  pt-4 flex flex-col ">

                        <div>
                            {
                                transactions?.length > 0 ?
                                    transactions.map(
                                        (item, value) => {
                                            return (
                                                <div>
                                                    <div
                                                        className="flex pt-4 p-2 rounded  px-6 gap-3 cursor-pointer hover:bg-gray-300">
                                                        <Avatar showFallback isBordered size="sm" color="secondary"
                                                                src='https://images.unsplash.com/broken'/>
                                                        <div className="flex flex-col items-center  ">
                                                            <p className="text-[10px] font-semibold ">{item?.emeteur?.prenom} {item?.emeteur?.nom}</p>
                                                            <p className="text-[10px]">{item.message}</p>
                                                        </div>
                                                    </div>
                                                    <Divider className="my-4"/>
                                                </div>

                                            )
                                        }
                                    ) :
                                    <div className="flex items-center justify-center text-sm font-normal"><p> Vous avez
                                        pas
                                        de transaction </p></div>
                            }
                        </div>
                    </div>
                </>
                : null
            }
        </div>
    );
}

export default Store;