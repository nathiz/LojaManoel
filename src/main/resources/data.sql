-- Inserindo pedido
INSERT INTO pedido (id, nome_cliente) VALUES (1, 'João');

-- Inserindo produtos vinculados ao pedido
INSERT INTO produto (id, nome, altura, largura, comprimento, pedido_id) VALUES 
(1, 'Livro', 2, 15, 22, 1),
(2, 'Controle', 5, 10, 18, 1);

-- Inserindo caixas
INSERT INTO caixa (id, tipo, altura, largura, comprimento) VALUES 
(1, 'Caixa 1', 30, 40, 80),
(2, 'Caixa 2', 80, 50, 40),
(3, 'Caixa 3', 50, 80, 60);

-- Resultado do empacotamento
INSERT INTO resultado_empacotamento (id, pedido_id, total_caixas_utilizadas) VALUES (1, 1, 1);

-- Produtos empacotados (agora com resultado_id)
INSERT INTO produto_empacotado (id, produto_id, caixa_id, resultado_id) VALUES
(1, 1, 1, 1),
(2, 2, 1, 1);