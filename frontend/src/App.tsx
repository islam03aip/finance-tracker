import { Routes, Route } from 'react-router-dom'
import SpendingsPage from './components/spendingComponent'
import AddSpending from './pages/AddSpending'
import IndividualSpendingPage from './pages/IndividualSpending';

function App() {

  return (
    <Routes>
      <Route path="/spending/all" element={<SpendingsPage />}/>
      <Route path="/spending/create" element={<AddSpending />}/>
      <Route path="/spending/:spendingId" element={<IndividualSpendingPage />}/>
    </Routes>
  );
}

export default App
