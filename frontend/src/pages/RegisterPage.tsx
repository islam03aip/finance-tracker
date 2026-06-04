import { useState } from "react"
import { addUser } from "../services/authService";

const RegistrationPage = () =>{
    const [username, setUsername] = useState("");
    const [email, setEmail] = useState("");
    const [password, setPassword] = useState("");

    const handleSubmit = async(e:any) =>{
        e.preventDefault();

        const data = {
            username,
            email,
            password
        };

        try{
            await addUser(data);
            alert("User added!");
        } catch(error) {
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
                type="text"
                placeholder="Email"
                value={email}
                onChange={(e) => setEmail(e.target.value)}/>
            <input 
                type="password"
                placeholder="Password"
                value={password}
                onChange={(e) => setPassword(e.target.value)}
            />
            <button type="submit">Register</button>
        </form>
    );
};
export default RegistrationPage;