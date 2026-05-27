import { useEffect, useState } from "react";
import { Link, useParams } from "react-router-dom";
import { getSpending, updateSpending,  } from "../services/spendingService";
import { getAllCategories } from "../services/categoryService";

const IndividualSpendingPage = () => {
    const { spendingId } = useParams();
    const [spending, setSpending] = useState<any>(null);
    const [name, setName] = useState("");
    const [amount, setAmount] = useState("");
    const [categories, setCategories] = useState([]);
    const [categoryId, setCategoryId] = useState();
    
    const handleCategoryChange = (e:any) => {
        setCategoryId(e.target.value);
    };
    const handleUpdate = async(e : any) => {
            e.preventDefault();
    
            const data = {
                name,
                amount: Number(amount),
                categoryId: Number(categoryId)
            };
            try {
                await updateSpending(Number(spendingId), data);
                alert("Spending updated!");
            } catch (error) {
                console.error(error);
            }
    };
    useEffect(() => {
        const fetchData = async () => {
            if (!spendingId) return;

            try {
                const data = await getSpending(Number(spendingId));
                const categoryList = await getAllCategories();
                setSpending(data);
                setCategories(categoryList);

                setName(data.name);
                setAmount(data.amount);
                setCategoryId(data.category.id);
            }catch(error){
                console.error(error);
            }
        };
        fetchData();
    }, [spendingId]);
    if (!spending) return <div>Not Found</div>;
    return (
        <div>
            <h1>{spending.name}</h1>
            <p>{spending.amount}</p>
            <p>{spending.category?.name}</p>
            <Link to="/spending/all">Back to Spendings Page</Link>
            <form onSubmit={handleUpdate}>
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
                <select value={categoryId} onChange={handleCategoryChange}>
                    {categories.map((c:any) => (
                        <option key={c.id} value={c.id}>
                            {c.name}
                        </option>
                    ))}
                </select>
                <button type="submit">Update</button>
            </form>
        </div>
    );
};

export default IndividualSpendingPage;