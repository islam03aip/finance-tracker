import { useEffect, useState } from "react"
import { deleteIncome, getAllIncome } from "../services/incomeService";
import { Link, useNavigate } from "react-router-dom";

const IncomePage = () =>{
    const [allIncome, setAllIncome] = useState([]);
    const navigate = useNavigate();

    const handleDelete = async(incomeId:number) => {
        try{
            await deleteIncome(Number(incomeId));
            navigate(0);
        }catch(error){
            console.error(error);
        }
        
    }
    useEffect(() => {
        const fetchData = async() =>{
            const data = await getAllIncome();
            setAllIncome(data);
        };
        fetchData()
    }, []);

    return (
        <div>
            {allIncome.map((i:any) => (
                <div key={i.id}>
                    <Link to={`/income/${i.id}`}>
                        {i.amount} - {i.createdAt}
                    </Link>
                    <button onClick={() => handleDelete(i.id)}>Delete</button>
                </div>
            ))}
        </div>
    )
}

export default IncomePage;