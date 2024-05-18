import React, {useContext, useState} from 'react';
import { Formik, Field, Form, ErrorMessage } from 'formik';
import * as yup from 'yup';
import axios from '../../api/axios.js';
import {isActiveLogin, isActiveRegister} from "../../context/GlobalProvider.jsx";
import {useAtom} from "jotai";
import AuthContext from "../../context/AuthProvider.jsx";
import {useNavigate} from "react-router-dom";

const Register = (props) => {axios
    const [isActiveLoged, setIsActiveLogin] = useAtom(isActiveLogin);
    const [isActiveRegisted, setIsActiveRegister] = useAtom(isActiveRegister);
    const [er,setError] = useState("")
    const { setAuth } = useContext(AuthContext);
    const navigation = useNavigate()
    // Create a schema for validation
    const schema = yup.object().shape({
        nom: yup.string().required('Required'),
        prenom: yup.string().required('Required'),
        addresse : yup.string().required('Required'),
        naissance: yup.date().required('Required'),
        email: yup.string().email('Invalid email').required('Required'),
        password: yup.string().min(8, 'Must be at least 8 characters').required('Required'),
        confirmPassword: yup.string().oneOf([yup.ref('password'), null], 'Passwords must match').required('Required')
    });
    const handleSubmit = async (values) => {
        try {
            // Send a POST request to the /register endpoint
            const response = await axios.post('/auth/register', values);
            const token = response.data?.token;
            console.log(token);
            const role = response?.data?.role;
            const email = response?.data?.email;
            console.log(response.data)
            localStorage.setItem('token', token);
            setAuth({role,email,token,isAuthenticated:true});
            setIsActiveRegister(false)
            if(role === "CLIENT") {
                navigation('/mostPopulaire')
            } else {
                if (role == "ADMIN") {
                    navigation('/admin')
                } else {
                    if (role == "BIBLIOTHECAIRE") {
                        navigation('/documents')
                    }
                }
            }

        } catch (e) {
            if (e.response) {
                // The request was made and the server responded with a status code
                // that falls out of the range of 2xx
                setError(e.response.data.error);
            } else if (e.request) {
                // The request was made but no response was received
                // `error.request` is an instance of XMLHttpRequest in the browser and an instance of
                // http.ClientRequest in node.js
                console.log(e.request);
            } else {
                // Something happened in setting up the request that triggered an Error
                console.log('Error', e.message);
            }
            console.log(e.config);
        }

    };

    return (
        <div className="bg-white  font-medium flex flex-col justify-center gap-4  text-black bg-opacity-90  rounded-xl py-5 px-6">
            <h1 className="text-xl text-center ">S'inscrire</h1>
            {er && <p className="text-left text-red-600 text-sm font-normal">{er}</p>}
            <Formik
                initialValues={{ nom: '', prenom: '',addresse: '', naissance: '', email: '', password: '', confirmPassword: '' }}
                validationSchema={schema}
                onSubmit={handleSubmit}
            >
                <Form className="flex flex-col gap-2 w-96">
                    <ErrorMessage name="nom" component="div" className="text-red-600 text-[12px] font-normal text-left " />
                    <Field name="nom" type="text" placeholder="Nom" className="border p-2 focus:outline-none rounded text-gray-700 " />
                    <ErrorMessage name="prenom" component="div" className="text-red-600  text-[12px] font-normal text-left" />
                    <Field name="prenom" type="text" placeholder="Prenom" className="border focus:outline-none p-2 rounded text-gray-700 " />
                    <ErrorMessage name="adresse" component="div" className="text-red-600  text-[12px] font-normal text-left" />
                    <Field name="addresse" type="text" placeholder="Ville" className="border focus:outline-none p-2 rounded text-gray-700 " />
                    <ErrorMessage name="naissance" component="div" className="text-red-600  text-[12px] font-normal text-left" />
                    <Field name="naissance" type="date" placeholder="Naissance" className="border focus:outline-none p-2 text-gray-700  rounded" />
                    <ErrorMessage name="email" component="div" className="text-red-600  text-[12px] font-normal text-left" />
                    <Field name="email" type="email" placeholder="Email" className="border focus:outline-none p-2 rounded text-gray-700 " />
                    <ErrorMessage name="password" component="div" className="text-red-600  text-[12px] font-normal text-left" />
                    <Field name="password" type="password" placeholder="Password" className="border focus:outline-none p-2 rounded text-gray-700 " />
                    <ErrorMessage name="confirmPassword" component="div" className="text-red-600 text-[12px] font-normal text-left" />
                    <Field name="confirmPassword" type="password" placeholder="Confirm Password" className="border focus:outline-none p-2 rounded text-gray-700 " />
                    <button className="bg-[#564592] text-white py-2 px-6 rounded-md" type="submit">Register</button>
                </Form>
            </Formik>
            <div>
                <p className="text-sm font-normal">Vous avez déjà un compte ? <span
                    className="text-[#564592] cursor-pointer" onClick={() => {
                    setIsActiveLogin(true)
                    setIsActiveRegister(false)
                }
                }>Se Connecter</span></p>
            </div>
        </div>
    )
}

export default Register;