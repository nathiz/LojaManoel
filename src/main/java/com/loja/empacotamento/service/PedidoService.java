package com.loja.empacotamento.service;

import java.util.*;
import org.springframework.stereotype.Service;

import com.loja.empacotamento.model.Caixa;
import com.loja.empacotamento.model.Pedido;
import com.loja.empacotamento.model.Produto;
import com.loja.empacotamento.model.ProdutoEmpacotado;
import com.loja.empacotamento.model.ResultadoEmpacotamento;

@Service
public class PedidoService {

    private final List<Caixa> caixasDisponiveis = List.of(
            new Caixa(1L, "Caixa 1", 30.0, 40.0, 80.0),
            new Caixa(2L, "Caixa 2", 80.0, 50.0, 40.0),
            new Caixa(3L, "Caixa 3", 50.0, 80.0, 60.0)
    );

    private final Map<String, Pedido> pedidosArmazenados = new HashMap<>();

    public Map<String, List<ResultadoEmpacotamento>> empacotarPedidos(List<Pedido> pedidos) {
        Map<String, List<ResultadoEmpacotamento>> resultadoFinal = new HashMap<>();

        for (Pedido pedido : pedidos) {
            List<ResultadoEmpacotamento> caixasUsadas = new ArrayList<>();
            List<Produto> produtosRestantes = new ArrayList<>(pedido.getProdutos());

            produtosRestantes.sort(Comparator.comparingDouble(Produto::getVolume).reversed());

            while (!produtosRestantes.isEmpty()) {
                Produto produto = produtosRestantes.remove(0);
                Caixa caixaEscolhida = encontrarCaixaParaProduto(produto);

                if (caixaEscolhida == null) {
                    caixasUsadas.add(new ResultadoEmpacotamento(
                            null, pedido, 0,
                            List.of(new ProdutoEmpacotado(null, produto, null, null))
                    ));
                    break;
                }

                List<ProdutoEmpacotado> produtosNaCaixa = new ArrayList<>();
                produtosNaCaixa.add(new ProdutoEmpacotado(null, produto, caixaEscolhida, null));
                double volumeOcupado = produto.getVolume();

                Iterator<Produto> iterator = produtosRestantes.iterator();
                while (iterator.hasNext()) {
                    Produto outro = iterator.next();
                    if (volumeOcupado + outro.getVolume() <= caixaEscolhida.getVolume()) {
                        produtosNaCaixa.add(new ProdutoEmpacotado(null, outro, caixaEscolhida, null));
                        volumeOcupado += outro.getVolume();
                        iterator.remove();
                    }
                }

                caixasUsadas.add(new ResultadoEmpacotamento(null, pedido, 1, produtosNaCaixa));
            }

            resultadoFinal.put(pedido.getId().toString(), caixasUsadas);
        }

        return resultadoFinal;
    }

    private Caixa encontrarCaixaParaProduto(Produto produto) {
        return caixasDisponiveis.stream()
                .filter(c -> produto.getAltura() <= c.getAltura()
                        && produto.getLargura() <= c.getLargura()
                        && produto.getComprimento() <= c.getComprimento())
                .min(Comparator.comparingDouble(Caixa::getVolume))
                .orElse(null);
    }

    public Pedido criarPedido(Pedido pedido) {
        if (pedido.getId() == null) {
            pedido.setId(System.currentTimeMillis());
        }
        pedidosArmazenados.put(pedido.getId().toString(), pedido);
        return pedido;
    }

    public Pedido editarPedido(String pedidoId, Pedido pedidoAtualizado) {
        Pedido existente = pedidosArmazenados.get(pedidoId);
        if (existente == null) {
            throw new NoSuchElementException("Pedido não encontrado: " + pedidoId);
        }
        pedidoAtualizado.setId(Long.valueOf(pedidoId));
        pedidosArmazenados.put(pedidoId, pedidoAtualizado);
        return pedidoAtualizado;
    }

    public void excluirPedido(String pedidoId) {
        if (!pedidosArmazenados.containsKey(pedidoId)) {
            throw new NoSuchElementException("Pedido não encontrado: " + pedidoId);
        }
        pedidosArmazenados.remove(pedidoId);
    }

    public Pedido buscarPedido(String pedidoId) {
        Pedido pedido = pedidosArmazenados.get(pedidoId);
        if (pedido == null) {
            throw new NoSuchElementException("Pedido não encontrado: " + pedidoId);
        }
        return pedido;
    }

    public List<Pedido> listarPedidos() {
        return new ArrayList<>(pedidosArmazenados.values());
    }
}