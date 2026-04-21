import { useState } from 'react'
import reactLogo from './assets/react.svg'
import viteLogo from './assets/vite.svg'
import heroImg from './assets/hero.png'
import { Routes, Route } from 'react-router-dom'
import SpendingPage from './components/spendingComponent'

function App() {

  return (
    <Routes>
      <Route path="/spending/all" element={<SpendingPage />}/>
    </Routes>
  );
}

export default App
