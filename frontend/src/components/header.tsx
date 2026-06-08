import { Link } from "react-router-dom";
import { useAuth } from "../context/AuthProvider";
import "./headerStyle.css";
const Header = () =>{
    const {isAuthenticated} = useAuth();
    if(!isAuthenticated){
        return(
            <header className="header"> 
                <Link className="headerLink" to="/">
                    <p>
                        Home
                    </p>
                </Link>
                <Link className="headerLink" to="/login">
                    <p>
                        Login
                    </p>
                </Link>
                <Link className="headerLink" to="/register">
                    <p>
                        Register
                    </p>
                </Link>
            </header>
        )
    }
    return (
        <header className="header">
            <Link className="headerLink" to="/">
                    <p>
                        Home
                    </p>
            </Link>
            <Link to="/profile" className="headerLink">
                <p>
                    Profile
                </p>
            </Link>
        </header>
    )
}

export default Header;