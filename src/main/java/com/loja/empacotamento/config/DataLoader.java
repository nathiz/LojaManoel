package com.loja.empacotamento.config;

import com.loja.empacotamento.model.Produto;
import com.loja.empacotamento.repository.ProdutoRepository;
import jakarta.annotation.PostConstruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Profile({"dev", "test"})
public class DataLoader {

    private static final Logger log = LoggerFactory.getLogger(DataLoader.class);
    private final ProdutoRepository produtoRepository;

    public DataLoader(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    @PostConstruct
    public void loadProdutosDeExemplo() {
        if (produtoRepository.count() > 0) {
            log.info("🟡 Produtos já existentes. Nenhuma carga foi realizada.");
            return;
        }

        List<Produto> produtos = List.of(
            new Produto(null, "Celular",         15.0,  7.0,  1.0,   150.0,  null),
            new Produto(null, "Fone de Ouvido",   8.0,  4.0,  1.0,    50.0,  null),
            new Produto(null, "Carregador",      10.0,  5.0,  2.0,   100.0,  null),
            new Produto(null, "Notebook",        30.0, 25.0,  5.0,  2500.0,  null),
            new Produto(null, "Caixa de Som",    20.0, 15.0, 10.0,  1200.0,  null)
        );

        produtoRepository.saveAll(produtos);
        log.info("✅ {} produtos de exemplo foram carregados com sucesso.", produtos.size());
    }
}