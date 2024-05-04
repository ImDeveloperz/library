// App.js
import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';
import Acceuil from './components/Acceuil';
import MostPopulare from './components/MostPopulare';
import Unauthorized from "./components/Unauthorized.jsx";
import Missing from "./components/Missing.jsx";
import RequireAuth from "./components/RequireAuth.jsx";

const App = () => {
    //const { username, role } = useContext(AuthContext);
    //console.log(username, role)
    const ROLES = {
        'User': 'CLIENT',
        'Editor': 'BIBLIOTHECAIRE',
        'Admin': 'ADMIN',
        'Guest': 'GUEST'
    }

    return (
                <div className="w-full sm:mx-8 flex relative justify-center h-[100vh] ">
                    <div className="container d-flex align-items-center flex-column">
                        <Routes>
                            <Route path="unauthorized" element={<Unauthorized />} />
                            <Route element={<RequireAuth allowedRoles={ROLES.Guest} />}>
                                <Route exact path='' element={<Acceuil/>}/>
                            </Route>

                            <Route element={<RequireAuth allowedRoles={ROLES.User} />}>
                                <Route exact path='/mostPopulaire' element={<MostPopulare/>}/>
                            </Route>
                            <Route path="*" element={<Missing />} />
                        </Routes>
                    </div>
                </div>
    );
};

export default App;
