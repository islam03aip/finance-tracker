import { useState } from "react"
import { addUser } from "../services/authService";
import { useNavigate } from "react-router-dom";

const RegistrationPage = () =>{
    const [username, setUsername] = useState("");
    const [email, setEmail] = useState("");
    const [password, setPassword] = useState("");
    const navigate = useNavigate();

    const handleSubmit = async(e:any) =>{
        e.preventDefault();

        const data = {
            username,
            email,
            password
        };

        try{
            await addUser(data);
            navigate("/login");
        } catch(error) {
            console.error(error);
        }
    }
    return(
        <div className="loginContainer">
            <h1>
                Register
            </h1>
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
                    type="text"
                    placeholder="Email"
                    value={email}
                    onChange={(e) => setEmail(e.target.value)}/>
                <input
                    className="loginInput" 
                    type="password"
                    placeholder="Password"
                    value={password}
                    onChange={(e) => setPassword(e.target.value)}
                />
                <button className="loginButton" type="submit">Register</button>
            </form>
        </div>

    );
};
export default RegistrationPage;