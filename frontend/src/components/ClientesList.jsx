import React, { useEffect, useState } from 'react';
import { useNavigate } from 'react-router-dom';
import { getClientes } from '../services/api';

export default function ClientesList() {
  const [clientes, setClientes] = useState([]);
  const navigate = useNavigate();

  useEffect(() => {
    getClientes().then(data => setClientes(data));
  }, []);
  
  useEffect(() => {
  getClientes().then(data => {
    console.log('Clientes recebidos:', data);
    setClientes(data);
  });
}, []);

  const calcularIdade = (dataNascimento) => {
    const hoje = new Date();
    const nascimento = new Date(dataNascimento);
    let idade = hoje.getFullYear() - nascimento.getFullYear();
    const m = hoje.getMonth() - nascimento.getMonth();
    if (m < 0 || (m === 0 && hoje.getDate() < nascimento.getDate())) {
      idade--;
    }
    return idade;
  };

  return (
    <div className="container">
      <h1>Clientes</h1>
      <table className="tabela">
        <thead>
          <tr>
            <th>Nome</th>
            <th>CPF</th>
            <th>Idade</th>
            <th>Status</th>
            <th>Limite de Crédito</th>
            <th>Ações</th>
          </tr>
        </thead>
        <tbody>
            {clientes.map(cliente => (
                <tr key={cliente.id}>
                <td>{cliente.nome}</td>
                <td>{cliente.cpf}</td>
                <td>{calcularIdade(cliente.dataNascimento)}</td>
                <td>{cliente.statusBloqueio === 'A' ? 'Ativo' : 'Bloqueado'}</td>
                <td>R$ {cliente.limiteCredito.toFixed(2)}</td>
                <td>
                    <button onClick={() => navigate(`/faturas/${cliente.id}`)}>
                    Ver Faturas
                    </button>
                </td>
                </tr>
            ))}
        </tbody>

      </table>
    </div>
  );
}
