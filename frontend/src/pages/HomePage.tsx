import { useNavigate } from "react-router-dom";
import { Link } from "react-router-dom";

const HomePage = () =>{
    const navigate = useNavigate();
    return(
        <div>
            <h1>Hello</h1>
            <Link to="/income/all">Income</Link>
            <br></br>
            <Link to="/spending/all">Spending</Link>
        </div>
    )
}

export default HomePage;