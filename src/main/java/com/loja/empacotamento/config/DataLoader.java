package com.loja.empacotamento.config;

import com.loja.empacotamento.model.Produto;
import com.loja.empacotamento.repository.ProdutoRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;

@Component
public class DataLoader {

    private final ProdutoRepository produtoRepository;

    public DataLoader(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    @PostConstruct
    public void init() {
        if (produtoRepository.count() == 0) {
            List<Produto> produtos = List.of(
                new Produto(null, "Celular", 15, 7, 1, 150, null),
                new Produto(null, "Fone de Ouvido", 8, 4, 1, 50, null),
                new Produto(null, "Carregador", 10, 5, 2, 100, null),
                new Produto(null, "Notebook", 30, 25, 5, 2500, null),
                new Produto(null, "Caixa de Som", 20, 15, 10, 1200, null)
            );
            produtoRepository.saveAll(produtos);
            System.out.println("🟢 Produtos de exemplo carregados no banco.");
        } else {
            System.out.println("🟡 Produtos já existentes. Nenhum dado foi alterado.");
        }
    }
}