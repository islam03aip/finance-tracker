import { createContext, useContext, useEffect, useState } from "react";
import { getUserStatus } from "../services/authService";

interface AuthContextType{
    isAuthenticated: boolean,
    user: any,
    loading: boolean;
    setIsAuthenticated: React.Dispatch<React.SetStateAction<boolean>>;
    setUser: React.Dispatch<React.SetStateAction<any>>;
    setLoading: React.Dispatch<React.SetStateAction<boolean>>;
}
const AuthContext = createContext<AuthContextType | null>(null);

export const AuthProvider = ({children}:{children: React.ReactNode}) =>{
    const [isAuthenticated, setIsAuthenticated] = useState(false);
    const [user, setUser] = useState(null);
    const [loading, setLoading] = useState(true);

    useEffect(() => {
        const fetchData = async() =>{
            try{
                const data = await getUserStatus();
                if(data.authenticated){
                    setIsAuthenticated(true);
                    setUser(data);
                }else{
                    setIsAuthenticated(false);
                    setUser(null);
                }
            } catch {
                setIsAuthenticated(false);
                setUser(null);
            } finally {
                setLoading(false);
            }
        }
        fetchData();
    }, []);

    return (
        <AuthContext.Provider value={{ isAuthenticated, user, loading, setIsAuthenticated, setUser, setLoading}}>
            {children}
        </AuthContext.Provider>
    );
};

export const useAuth = () => {
    const context = useContext(AuthContext);

    if(!context){
        throw new Error("useAuth must be used inside AuthProvider");
        
    }
    return context;
}