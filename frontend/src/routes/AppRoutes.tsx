import { Routes, Route } from "react-router-dom"
import SpendingsPage from "../components/spendingComponent"
import AddSpending from "../pages/AddSpending"
import IndividualSpendingPage from "../pages/IndividualSpending"
import HomePage from "../pages/HomePage"
import RegistrationPage from "../pages/RegisterPage"
import LoginPage from "../pages/login/LoginPage"
import ProfilePage from "../pages/ProfilePage"
import ProtectedRoute from "./ProtectedRoute"
import Header from "../components/header"
import IncomePage from "../pages/IncomePage"
import AddIncomePage from "../pages/AddIncome"
import IndvidualIncomePage from "../pages/IndvIncomePage"
const AppRoutes = () => {
    return (
        <>
            <Header />
                <Routes>
                        <Route path="/" element={<HomePage/>} />
                        <Route path="/register" element={<RegistrationPage />} />
                        <Route path="/login" element={<LoginPage />} />
                        <Route element={<ProtectedRoute />}>
                            <Route path="/spending/all" element={<SpendingsPage />}/>
                            <Route path="/spending/create" element={<AddSpending />}/>
                            <Route path="/spending/:spendingId" element={<IndividualSpendingPage />}/>
                            <Route path="/profile" element={<ProfilePage />} />
                            <Route path="/income/all" element={<IncomePage />} />
                            <Route path="/income/add" element={<AddIncomePage />} />
                            <Route path="/income/:incomeId" element={<IndvidualIncomePage />} />
                        </Route>
                </Routes>
        </>
    )
}

export default AppRoutes;