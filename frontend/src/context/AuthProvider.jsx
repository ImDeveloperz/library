import { createContext, useState,useEffect } from "react";

const AuthContext = createContext({});

export const AuthProvider = ({ children }) => {
    const [auth, setAuthState] = useState(() => {
        const storedAuth = localStorage.getItem('auth');
        return storedAuth ? JSON.parse(storedAuth) : {['role']: 'GUEST', ['email']: '', ['token']: '', ['isAuthenticated']: false};
    });
    const setAuth = (newAuth) => {
        setAuthState(newAuth);
        localStorage.setItem('auth', JSON.stringify(newAuth));
    };


    const logout = () => {
        setAuthState({});
        localStorage.removeItem('auth');
    };
    return (
        <AuthContext.Provider value={{ auth, setAuth }}>
            {children}
        </AuthContext.Provider>
    )
}

export default AuthContext;