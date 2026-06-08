import { useState } from "react"
import { loginUser } from "../services/authService";
import { useNavigate } from "react-router-dom";
import { useAuth } from "../context/AuthProvider";

const LoginPage = () => {
    const [username, setUsername] = useState("");
    const [password, setPassword] = useState("");
    const {setIsAuthenticated} = useAuth();
    const navigate = useNavigate();

    const handleSubmit = async(e:any) => {
        e.preventDefault();

        const data={
            username,
            password
        }

        try{
            await loginUser(data);
            setIsAuthenticated(true);
            navigate("/");
        }catch(error){
            console.error(error);
        }
    }
    return(
        <form onSubmit={handleSubmit}>
            <input 
                type="text"
                placeholder="Username"
                value={username}
                onChange={(e) => setUsername(e.target.value)}
            />
            <input 
                type="password"
                placeholder="Password"
                value={password}
                onChange={(e) => setPassword(e.target.value)}
            />
            <button type="submit">
                Login
            </button>
        </form>
    );
};

export default LoginPage;