import React, {useContext, useEffect, useRef, useState} from 'react';
import { Navigate } from 'react-router-dom';
import {useAtom}  from "jotai";
import useAuth from "../hook/useAuth.js";
import NavbarLayout from "./NavbarLayout.jsx";
import {isActiveProfile, isNotification} from "../context/GlobalProvider.jsx";
import {Cloudinary} from "@cloudinary/url-gen";
import Book from "./Book.jsx";
import {SearchIcon} from "./SearchIcon.jsx";
import {Input, Pagination, Select, SelectItem} from "@nextui-org/react";
import axios from "../api/axios.js";
const types = [
    {label: "Livre", value: "Livre"},
    {label: "Disque Compact", value: "disque"},
    {label: "Journal", value: "Journal"},
    {label: "Cassete Video", value: "Cassete"},
    {label: "Periodique", value: "Periodique"},
];
const trie = [
    {label: "Date de publication", value: "date"},
    {label: "Titre", value: "titre"},
]
const langues = [
    {label: "Francais", value: "fr"},
    {label: "Anglais", value: "en"},
]
const MostPopulare = (props) => {
    const {auth} = useAuth();
    const search = useRef("")
    const [isNotif, setIsNotif] = useAtom(isNotification);
    const [isActiveProfil, setIsActiveProfile] = useAtom(isActiveProfile);
    const [docs,setDocs]= useState([])
    const [nbPages,setNbPages] = useState(0)
    const getDocs = async(page = 0,search = "") =>{
        try{
            const response = await axios.get('/documents?page=' +page+'&search='+ search,{
                headers:{
                    'Authorization': 'Bearer ' + auth.token,
                }
            });
            setDocs(response.data.content)
            setNbPages(response.data.totalPages)
            console.log(response.data)
        }catch(e){
            console.log(e)
        }
    }

    useEffect(() => {
        if(auth.token){getDocs().then(r => r).catch(e => e);}
    }, [auth]);
    return (
        <NavbarLayout>
            <div className="pt-6" onClick={()=>{
                if(isNotif){
                    setIsNotif(false)
                }
                if(isActiveProfil){
                    setIsActiveProfile(false)
                }
            }}>
                <h1 className="text-4xl font-semibold">Plus Populaire</h1>
                <div className="pt-6 items-center text-black flex gap-2">
                    <div className="flex flex-col gap-2 sm:flex-row ">
                        <div className="md:w-72 ">
                            <Input
                                onClear={() => {
                                    getDocs(0,"").then(r => r).catch(e => e)
                                }
                                }
                                onValueChange={() => {
                                    getDocs(0,search.current.value).then(r => r).catch(e => e)
                                }}
                                ref={search}
                                isClearable
                                radius="lg"
                                classNames={{
                                    input: [
                                        "text-black/90 dark:text-white/90",
                                        "placeholder:text-default-700/50 dark:placeholder:text-white/60",
                                    ],
                                    innerWrapper: "",
                                    inputWrapper: [
                                        "shadow-xl",
                                        "dark:bg-default/60",
                                        "backdrop-blur-xl",
                                        "backdrop-saturate-200",
                                        "hover:bg-default-200/70",
                                        "dark:hover:bg-default/70",
                                        "group-data-[focused=true]:bg-default-200/50",
                                        "dark:group-data-[focused=true]:bg-default/60",
                                        "!cursor-text",
                                    ],
                                }}
                                placeholder="Recherche par nom ou discipteur ..."
                                startContent={
                                    <SearchIcon
                                        className="text-black/50 mb-0.5 dark:text-white/90 text-slate-400 pointer-events-none flex-shrink-0"/>
                                }
                            />

                        </div>
                        <div className="md:w-52">
                            <Select
                                items={types}
                                placeholder="Filter par type"
                                className="max-w-xs text-black/90 "
                            >
                                {(type) => <SelectItem className="text-black "
                                                       key={type.value}>{type.label}</SelectItem>}
                            </Select>
                        </div>
                    </div>
                    <div className="flex flex-col gap-2 sm:flex-row ">
                        <div className="md:w-52">
                            <Select
                                items={langues}
                                placeholder="Filter par langue"
                                className="max-w-xs text-black/90 "
                            >
                                {(type) => <SelectItem className="text-black "
                                                       key={type.value}>{type.label}</SelectItem>}
                            </Select>
                        </div>
                        <div className="w-52">
                            <Select
                                items={trie}
                                placeholder="Trie par"
                                className="max-w-xs text-black/90 "
                            >
                                {(type) => <SelectItem className="text-black "
                                                       key={type.value}>{type.label}</SelectItem>}
                            </Select>
                        </div>
                    </div>
                </div>
                <div className="items-center gap-4 mt-4 w-full grid md:grid-cols-3 grid-cols-1 sm:grid-cols-2 xl:grid-cols-4 ">
                    { docs ?
                        docs?.map(doc=>(
                             <Book key={doc?.id} imageUrl={doc?.imgUrl} type={doc?.type} Author={doc?.auteur} date={doc?.datePublication} titre={doc?.titre} />
                        )) : <div> Aucun document trouver</div>
                    }
                </div>
                <div className="m-8 flex items-center justify-center   ">
                    <Pagination loop showControls onChange={(page) =>{
                        getDocs(page-1)
                    }} color="success" total={nbPages} initialPage={1}  />
                </div>
            </div>
        </NavbarLayout>
    );
}

export default MostPopulare;