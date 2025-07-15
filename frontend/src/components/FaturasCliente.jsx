import React, { useEffect, useState, useCallback } from 'react';
import { useParams } from 'react-router-dom';
import { getFaturas, registrarPagamento } from '../services/api';

export default function FaturasCliente() {
  const { id } = useParams();
  const [faturas, setFaturas] = useState([]);

  const carregarFaturas = useCallback(() => {
    getFaturas(id).then(data => setFaturas(data));
  }, [id]); // <- depende do id do cliente

  useEffect(() => {
    carregarFaturas();
  }, [carregarFaturas]);

  const pagar = (faturaId) => {
    registrarPagamento(faturaId).then(() => carregarFaturas());
  };

  return (
    <div className="container">
      <h1>Faturas do Cliente</h1>
      <table className="tabela">
        <thead>
          <tr>
            <th>Valor</th>
            <th>Data de Vencimento</th>
            <th>Status</th>
            <th>Data de Pagamento</th>
            <th>Ações</th>
          </tr>
        </thead>
        <tbody>
          {faturas.map(fatura => (
            <tr key={fatura.id}>
              <td>R$ {fatura.valor.toFixed(2)}</td>
              <td>{fatura.data_vencimento}</td>
              <td>{fatura.status}</td>
              <td>{fatura.data_pagamento || '-'}</td>
              <td>
                {fatura.status !== 'P' && (
                  <button onClick={() => pagar(fatura.id)}>Registrar Pagamento</button>
                )}
              </td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
}
