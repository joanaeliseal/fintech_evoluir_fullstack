-- CRIAÇÃO DAS TABELAS
-- Tabela de clientes
CREATE TABLE cliente (
    id SERIAL PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    cpf VARCHAR(11) UNIQUE NOT NULL,
    data_nascimento DATE NOT NULL,
    status_bloqueio CHAR(1) NOT NULL CHECK (status_bloqueio IN ('A', 'B')),
    limite_credito NUMERIC(10, 2) NOT NULL
);

-- Tabela de faturas
CREATE TABLE fatura (
    id SERIAL PRIMARY KEY,
    cliente_id INT NOT NULL REFERENCES cliente(id),
    data_vencimento DATE NOT NULL,
    data_pagamento DATE,
    valor NUMERIC(10, 2) NOT NULL,
    status CHAR(1) NOT NULL CHECK (status IN ('P', 'A', 'B'))
);

-- Inserção de clientes
INSERT INTO cliente (nome, cpf, data_nascimento, status_bloqueio, limite_credito) VALUES
('João Silva', '12345678901', '1990-05-20', 'A', 2000.00),
('Maria Souza', '23456789012', '1985-11-12', 'A', 1500.00),
('Carlos Pereira', '34567890123', '1978-04-03', 'B', 0.00),
('Ana Costa', '45678901234', '1995-08-17', 'A', 3000.00),
('Paulo Mendes', '56789012345', '2000-02-25', 'B', 0.00),
('Fernanda Lima', '67890123456', '1993-03-14', 'A', 2500.00),
('Lucas Ramos', '78901234567', '1980-09-09', 'B', 0.00),
('Juliana Dias', '89012345678', '1998-12-21', 'A', 1800.00),
('Roberto Nunes', '90123456789', '1991-06-30', 'A', 2200.00),
('Patrícia Alves', '01234567890', '1987-10-11', 'B', 0.00);

SELECT * FROM cliente;

-- Inserção de faturas
INSERT INTO fatura (cliente_id, data_vencimento, data_pagamento, valor, status) VALUES
(1, '2025-07-01', '2025-07-02', 500.00, 'P'),
(2, '2025-07-05', NULL, 750.00, 'B'),
(3, '2025-07-01', NULL, 600.00, 'A'),
(3, '2025-06-28', NULL, 900.00, 'A'),
(3, '2025-06-25', NULL, 1000.00, 'A'),
(4, '2025-07-10', NULL, 300.00, 'B'),
(5, '2025-06-30', NULL, 1200.00, 'A'),
(6, '2025-07-01', NULL, 450.00, 'B'), 
(7, '2025-06-28', NULL, 700.00, 'A'),  
(7, '2025-07-05', NULL, 800.00, 'A'), 
(8, '2025-07-10', NULL, 900.00, 'B'),  
(9, '2025-07-12', '2025-07-12', 350.00, 'P'),  
(10, '2025-07-01', NULL, 1000.00, 'A');  

SELECT * FROM fatura;

-- Consulta: Clientes com mais de 3 dias de atraso e status 'Bloqueado'
SELECT DISTINCT c.*
FROM cliente c
JOIN fatura f ON f.cliente_id = c.id
WHERE c.status_bloqueio = 'B'
  AND f.status = 'A'
  AND f.data_vencimento < CURRENT_DATE - INTERVAL '3 days';

-- Atualizar limite de crédito para zero dos clientes bloqueados
UPDATE cliente
SET limite_credito = 0.00
WHERE status_bloqueio = 'B';

