const API_BASE = 'http://localhost:8080';

export async function getClientes() {
  const res = await fetch(`${API_BASE}/clientes`);
  return res.json();
}

export async function getFaturas(clienteId) {
  const res = await fetch(`${API_BASE}/faturas/${clienteId}`);
  return res.json();
}

export async function registrarPagamento(faturaId) {
  const res = await fetch(`${API_BASE}/faturas/${faturaId}/pagamento`, {
    method: 'PUT'
  });
  return res.ok;
}