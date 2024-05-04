import { useLocation, Navigate, Outlet } from "react-router-dom";
import useAuth from "../hook/useAuth";

const RequireAuth = ( allowedRoles ) => {
    const { auth } = useAuth();
    const location = useLocation();
    return (
        ( auth?.role === allowedRoles.allowedRoles )
            ? <Outlet />
            : auth?.isAuthenticated
                ? <Navigate to="/unauthorized" state={{ from: location }} replace />
                : <Navigate to="/" state={{ from: location }} replace />
    );
}

export default RequireAuth;