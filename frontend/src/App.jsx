import React from 'react';
import { BrowserRouter as Router, Routes, Route, Navigate } from 'react-router-dom';
import ClientesList from './components/ClientesList';
import FaturasCliente from './components/FaturasCliente';

export default function App() {
  return (
    <Router>
      <Routes>
        <Route path="/" element={<Navigate to="/clientes" />} />
        <Route path="/clientes" element={<ClientesList />} />
        <Route path="/faturas/:id" element={<FaturasCliente />} />
      </Routes>
    </Router>
  );
}