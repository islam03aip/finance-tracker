import { useEffect, useState } from "react";
import { createSpending } from "../services/spendingService";
import { getAllCategories } from "../services/categoryService";
import { Link } from "react-router-dom";

const AddSpending = () => {
    const [name, setName] = useState("");
    const [amount, setAmount] = useState("");
    const [categories, setCategories] = useState([]);
    const [categoryId, setCategory] = useState(0);

    const handleSubmit = async(e : any) => {
        e.preventDefault();

        const data = {
            name,
            amount: Number(amount),
            categoryId: Number(categoryId)
            
        };
        try {
            await createSpending(data);
            alert("Spending added!");
        } catch (error) {
            console.error(error);
        }
    };
    const handleChange = (e : any) =>{
        setCategory(e.target.value);
    };
    useEffect(() => {
        const fetchData = async () => {
            const data = await getAllCategories();
            setCategories(data);
        };
        fetchData();
    }, []);
    return (
        <div>
            <form onSubmit={handleSubmit}>
                <input 
                    type="text"
                    placeholder="Name"
                    value={name}
                    onChange={(e) => setName(e.target.value)}
                />
                <input 
                    type="number"
                    placeholder="Amount"
                    value={amount}
                    onChange={(e) => setAmount(e.target.value)}
                />
                <select value={categoryId} onChange={handleChange}>
                    <option value="">Select category</option>
                    {categories.map((c:any) =>(
                        <option key={c.id} value={c.id}>
                            {c.name}
                        </option>
                    ))}
                </select>
                <button type="submit">Add</button>
            </form>
            <Link to="/spending/all">Go to Spendings Page</Link>
        </div>
       
    );
};

export default AddSpending;