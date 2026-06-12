import { useEffect, useState } from "react"
import { getAllSpending, getSpendingsByCategory } from "../services/spendingService"
import { Link, useNavigate } from "react-router-dom";
import { deleteSpending } from "../services/spendingService";
import { Line, LineChart, Tooltip, XAxis, YAxis } from "recharts";
import { getAllCategories } from "../services/categoryService";
interface Category {
    id: number;
    name: string;
}
interface Spending {
    id: number;
    name: string;
    amount: number;
    createdAt: string;
    category: Category;
}
const SpendingsPage = () => {
    const [spendings, setSpendings] = useState<Spending[]>([]);
    const [allSpendings, setAllSpenings] = useState<Spending[]>([]);
    const [date, setDate] = useState("");
    const [categories, setCategories] = useState([]);
    const [categoryId, setCategoryId] = useState();

    const navigate = useNavigate();

    const handleDelete = async (id:Number) => {
        try {
            await deleteSpending(Number(id));
        } catch(error){
            console.error(error);
        }
        navigate(0);
    }
    const handleCategoryChange = (e:any) => {
        const id = e.target.value;
        setCategoryId(id);
        if(id != ""){
            setSpendings(
                allSpendings.filter(
                    s => s.category?.id === Number(id)
                )
            );
        }else{
            setSpendings(allSpendings);
        }
    };

    const filteredSpendingsByDate = allSpendings.filter(spending => {
        const spendingDate = new Date(spending.createdAt);
        const now = new Date();

        if(date === "day"){
            return spendingDate.toDateString() === now.toDateString();
        }
        if(date === "week"){
            const weekAgo = new Date();
            weekAgo.setDate(now.getDate() - 7);
            return spendingDate >= weekAgo;
        }
        if(date === "month"){
            const monthAgo = new Date();
            monthAgo.setMonth(now.getMonth() - 1);
            return spendingDate >= monthAgo;
        }
        if(date === "year"){
            const yearAgo = new Date();
            yearAgo.setFullYear(now.getFullYear() - 1);
            return spendingDate >= yearAgo;
        }
        return true;
    });

    useEffect(() => {
        const fetchData = async () => {
            const data = await getAllSpending();
            const categoryData = await getAllCategories();
            setAllSpenings(data);
            setSpendings(data);
            setCategories(categoryData);
        };
        console.log(categoryId);
        fetchData();
    }, []);
    return (
        <div>
            <h1>Spendings</h1>
            <select value={categoryId} onChange={handleCategoryChange}>
                <option value="">
                    All
                </option>
                {categories.map((c: any) => (
                    <option key={c.id} value={c.id}>
                        {c.name}
                    </option>
                ))}
            </select>
            {spendings.map((s: any) => (
                <div key={s.id}>
                    <Link to={`/spending/${s.id}`}>
                        {s.name} - {s.amount} - {s.category?.name};
                    </Link>
                    <button onClick={() => handleDelete(s.id)}>Delete</button>
                </div>
            ))}
            <Link to = "/spending/create">Add Spending</Link>
            <br></br>
            <LineChart
                width={800}
                height={400}
                data={spendings}
            >
                <XAxis dataKey="createdAt" />
                <YAxis dataKey="amount" />
                <Tooltip />
                <Line 
                    type="monotone"
                    dataKey="amount"
                />
            </LineChart>

            <select value={date} onChange={(e) => setDate(e.target.value)}>
                <option value="">
                    Overall
                </option>
                <option value="day">
                    Today
                </option>
                <option value="week">
                    One Week
                </option>
                <option value="month">
                    One Month
                </option>
                <option value="year">
                    One Year
                </option>
            </select>

            <LineChart
                width={800}
                height={400}
                data={filteredSpendingsByDate}
            >
                <XAxis dataKey="createdAt" />
                <YAxis dataKey="amount" />
                <Tooltip />
                <Line 
                    type="monotone"
                    dataKey="amount"
                />
            </LineChart>
        </div>
    );
};

export default SpendingsPage;