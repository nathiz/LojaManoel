-- Pedido
INSERT INTO pedido (nome_cliente) VALUES ('João');

-- Produtos (assumindo pedido_id = 1)
INSERT INTO produto (nome, altura, largura, comprimento, pedido_id) VALUES 
('Livro', 2, 15, 22, 1),
('Controle', 5, 10, 18, 1);

-- Caixas
INSERT INTO caixa (tipo, altura, largura, comprimento) VALUES 
('Caixa 1', 30, 40, 80),
('Caixa 2', 80, 50, 40),
('Caixa 3', 50, 80, 60);

-- Resultado (pedido_id = 1)
INSERT INTO resultado_empacotamento (pedido_id, total_caixas_utilizadas) VALUES (1, 1);

-- Produto empacotado (resultado_id = 1, produto_id = 1 e 2, caixa_id = 1)
INSERT INTO produto_empacotado (produto_id, caixa_id, resultado_id) VALUES
(1, 1, 1),
(2, 1, 1);