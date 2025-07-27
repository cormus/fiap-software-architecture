CREATE TABLE usuario (
  id INT AUTO_INCREMENT PRIMARY KEY,
  nome VARCHAR(100) NOT NULL,
  email VARCHAR(100) NOT NULL,
  senha VARCHAR(255),
  telefone VARCHAR(11),
  cpf VARCHAR(11),
  logradouro VARCHAR(100),
  numero VARCHAR(30),
  complemento VARCHAR(50),
  bairro VARCHAR(50),
  cidade VARCHAR(50),
  uf VARCHAR(2),
  cep VARCHAR(8)
);