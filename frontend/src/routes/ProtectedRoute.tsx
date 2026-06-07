import { Navigate, Outlet } from "react-router-dom";
import { useAuth } from "../context/AuthProvider";

export default function ProtectedRoute(){
    const {loading} = useAuth();
    const {isAuthenticated} = useAuth();
    
    if(loading){
        return <div>Loading ...</div>
    }
    return isAuthenticated? <Outlet /> : <Navigate to="/login" replace />;
}