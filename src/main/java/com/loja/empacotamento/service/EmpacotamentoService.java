package com.loja.empacotamento.service;

import com.loja.empacotamento.dto.*;
import com.loja.empacotamento.model.Caixa;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class EmpacotamentoService {

    private final List<Caixa> caixasDisponiveis = List.of(
        new Caixa(1L, "Caixa 1", 30.0, 40.0, 80.0),
        new Caixa(2L, "Caixa 2", 80.0, 50.0, 40.0),
        new Caixa(3L, "Caixa 3", 50.0, 80.0, 60.0)
    );

    public EmpacotarResponse empacotar(EmpacotarRequest pedido) {
        List<CaixaUsadaResponse> caixasUsadas = new ArrayList<>();
        Map<String, List<ProdutoEmpacotadoResponse>> mapaCaixas = new HashMap<>();

        for (ProdutoDTO produto : pedido.getProdutos()) {
            for (Caixa caixa : caixasDisponiveis) {
                if (produto.getAltura() <= caixa.getAltura()
                    && produto.getLargura() <= caixa.getLargura()
                    && produto.getComprimento() <= caixa.getComprimento()) {

                    ProdutoEmpacotadoResponse produtoEmpacotado = new ProdutoEmpacotadoResponse(
                        produto.getNome(),
                        produto.getAltura() != null ? produto.getAltura().intValue() : 0,
                        produto.getLargura() != null ? produto.getLargura().intValue() : 0,
                        produto.getComprimento() != null ? produto.getComprimento().intValue() : 0
                    );

                    mapaCaixas.computeIfAbsent(caixa.getTipo(), k -> new ArrayList<>()).add(produtoEmpacotado);
                    break;
                }
            }
        }

        for (Map.Entry<String, List<ProdutoEmpacotadoResponse>> entry : mapaCaixas.entrySet()) {
            caixasUsadas.add(new CaixaUsadaResponse(entry.getKey(), entry.getValue()));
        }

        return new EmpacotarResponse(pedido.getNomeCliente(), caixasUsadas);
    }
}