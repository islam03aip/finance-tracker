import { useEffect, useState } from "react"
import { getReqUser, logout } from "../services/authService";
import { useNavigate } from "react-router-dom";
import { AuthProvider, useAuth } from "../context/AuthProvider";

export const ProfilePage = () =>{
    const[username, setUsername] = useState("");
    const[email, setEmail] = useState("");
    const navigate = useNavigate();

    const handleLogout = async() =>{
        try{
            await logout();
            navigate("/");
        }catch(error){
            console.error(error);
        }
    }
    useEffect(() =>{
        const fetchData = async() =>{
            const data = await getReqUser();
            setUsername(data.username);
            setEmail(data.email);
        };
        fetchData();
    })
    return(
        <div>
            <h3>{username}</h3>
            <p>{email}</p>
            <button onClick={handleLogout}>
                Logout
            </button>
        </div>
    )
}

export default ProfilePage;