import { Routes, Route } from "react-router-dom"
import SpendingsPage from "../components/spendingComponent"
import AddSpending from "../pages/AddSpending"
import IndividualSpendingPage from "../pages/IndividualSpending"
import HomePage from "../pages/HomePage"
import RegistrationPage from "../pages/RegisterPage"
import LoginPage from "../pages/LoginPage"
import ProfilePage from "../pages/ProfilePage"
import { AuthProvider } from "../context/AuthProvider"
import ProtectedRoute from "./ProtectedRoute"
import Header from "../components/header"
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
                        </Route>
                </Routes>
        </>
    )
}

export default AppRoutes;