import { Routes, Route } from "react-router-dom"
import SpendingsPage from "../components/spendingComponent"
import AddSpending from "../pages/AddSpending"
import IndividualSpendingPage from "../pages/IndividualSpending"
import HomePage from "../pages/HomePage"
import RegistrationPage from "../pages/RegisterPage"
const AppRoutes = () => {
    return (
        <Routes>
            <Route path="/spending/all" element={<SpendingsPage />}/>
            <Route path="/spending/create" element={<AddSpending />}/>
            <Route path="/spending/:spendingId" element={<IndividualSpendingPage />}/>
            <Route path="/register" element={<RegistrationPage />} />
            <Route path="/" element={<HomePage/>} />
        </Routes>
    )
}

export default AppRoutes;