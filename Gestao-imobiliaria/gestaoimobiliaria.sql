create database gestaoimobiliaria;
use gestaoimobiliaria;

CREATE TABLE imovel (
    id_imovel BIGINT AUTO_INCREMENT PRIMARY KEY,
    tipo_imovel VARCHAR(100) NOT NULL,
    endereco VARCHAR(255) NOT NULL UNIQUE,
    tamanho DOUBLE NOT NULL,
    classificacao ENUM('comercial', 'residencial') NOT NULL,
    contrato_aluguel_ativo BOOLEAN DEFAULT FALSE
);

CREATE TABLE cliente (
    id_cliente BIGINT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(150) NOT NULL,
    email VARCHAR(150) NOT NULL UNIQUE,
    cpf CHAR(11) NOT NULL UNIQUE
);
CREATE TABLE contrato_aluguel (
    id_contrato BIGINT AUTO_INCREMENT PRIMARY KEY,
    valor_aluguel DECIMAL(10,2) NOT NULL,
    data_inicio DATE NOT NULL,
    data_fim DATE NOT NULL,
    contrato_ativo BOOLEAN DEFAULT TRUE,
    id_cliente BIGINT NOT NULL,
    id_imovel BIGINT NOT NULL,
    FOREIGN KEY (id_cliente) REFERENCES cliente(id_cliente),
    FOREIGN KEY (id_imovel) REFERENCES imovel(id_imovel)
);

INSERT INTO cliente (nome, email, cpf)
VALUES 
('Ana Souza', 'ana.souza@email.com', '12345678901'),
('Carlos Lima', 'carlos.lima@email.com', '98765432100'),
('Beatriz Mendes', 'beatriz.m@email.com', '45678912300');

INSERT INTO imovel (tipo_imovel, endereco, tamanho, classificacao, contrato_aluguel_ativo)
VALUES 
('Apartamento', 'Rua das Flores, 123', 85.5, 'residencial', TRUE),
('Sala Comercial', 'Av. Central, 456', 120.0, 'comercial', TRUE),
('Casa', 'Rua do Sol, 789', 150.0, 'residencial', FALSE);

INSERT INTO contrato_aluguel (valor_aluguel, data_inicio, data_fim, contrato_ativo, id_cliente, id_imovel)
VALUES 
(2500.00, '2025-08-01', '2026-07-31', TRUE, 1, 1),
(4500.00, '2025-07-15', '2026-07-14', TRUE, 2, 2),
(3200.00, '2024-09-01', '2025-08-31', FALSE, 3, 3);

select* from cliente;