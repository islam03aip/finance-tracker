import { useState } from "react"
import { loginUser } from "../../services/authService";
import { useNavigate } from "react-router-dom";
import { useAuth } from "../../context/AuthProvider";
import "./loginPage.css";

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
        <div className="loginContainer">
            <form onSubmit={handleSubmit} className="loginForm">
                <input 
                    className="loginInput"
                    type="text"
                    placeholder="Username"
                    value={username}
                    onChange={(e) => setUsername(e.target.value)}
                />
                <input 
                    className="loginInput"
                    type="password"
                    placeholder="Password"
                    value={password}
                    onChange={(e) => setPassword(e.target.value)}
                />
                <button className="loginButton" type="submit">
                    Login
                </button>
            </form>
        </div>
    );
};

export default LoginPage;