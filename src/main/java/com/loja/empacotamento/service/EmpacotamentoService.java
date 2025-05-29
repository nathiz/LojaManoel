package com.loja.empacotamento.service;

import com.loja.empacotamento.dto.*;
import com.loja.empacotamento.model.Caixa;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class EmpacotamentoService {

    private final List<Caixa> caixasDisponiveis = List.of(
            new Caixa(1L, "Caixa 1", 30, 40, 80),
            new Caixa(2L, "Caixa 2", 80, 50, 40),
            new Caixa(3L, "Caixa 3", 50, 80, 60)
    );

    public EmpacotarResponse empacotar(EmpacotarRequest pedido) {
        List<CaixaUsadaResponse> caixasUsadas = new ArrayList<>();
        Map<String, List<String>> mapaCaixas = new HashMap<>();

        for (ProdutoDTO produto : pedido.getProdutos()) {
            for (Caixa caixa : caixasDisponiveis) {
                if (produto.getAltura() <= caixa.getAltura()
                    && produto.getLargura() <= caixa.getLargura()
                    && produto.getComprimento() <= caixa.getComprimento()) {

                    mapaCaixas.computeIfAbsent(caixa.getTipo(), k -> new ArrayList<>()).add(produto.getNome());
                    break;
                }
            }
        }

        for (Map.Entry<String, List<String>> entry : mapaCaixas.entrySet()) {
            caixasUsadas.add(new CaixaUsadaResponse(entry.getKey(), entry.getValue()));
        }

        return new EmpacotarResponse(pedido.getNomeCliente(), caixasUsadas);
    }
}
