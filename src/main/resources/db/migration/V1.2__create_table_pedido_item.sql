CREATE TABLE IF NOT EXISTS pedido_item (
  id INT AUTO_INCREMENT PRIMARY KEY,
  id_pedido INT NOT NULL,
  id_produto INT NOT NULL,
  quantidade INT NOT NULL,
  valor DOUBLE NOT NULL
);