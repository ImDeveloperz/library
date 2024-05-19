import {useLocation, Navigate, Outlet, useNavigate} from "react-router-dom";
import useAuth from "../hook/useAuth";
import Home from "../pages/Home.jsx";
import MostPopulare from "../pages/MostPopulare.jsx";
import {useEffect} from "react";

const RequireAuth = ({allowedRoles, path} ) => {
    const { auth } = useAuth();
    const location = useLocation();
    const navigation = useNavigate()
    console.log("path:",path)
    console.log("location:",location.pathname)
    console.log("allowedRole:",allowedRoles)
    console.log("auth : ",auth)
    useEffect(() => {
        if(path === "/" && auth.role!=="GUEST") {
            console.log("client")
            switch (auth.role){
                case "CLIENT" :
                    navigation("/mostPopulaire")
                    break;
                case "ADMIN" :
                    navigation("/admin")
                    break;
                case "BIBLIOTHECAIRE" :
                    navigation("/documents")
                    break;
            }
        }
        console.log("r")
    }, [location.pathname]);
       return (
           ( auth?.role === allowedRoles )
               ? <Outlet />
               : auth?.isAuthenticated
                   ? <Navigate to="/unauthorized" state={{ from: location }} replace />
                   : <Navigate to="/" state={{ from: location }} replace />
       );

}

export default RequireAuth;