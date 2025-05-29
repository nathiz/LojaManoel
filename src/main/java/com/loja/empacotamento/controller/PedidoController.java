package com.loja.empacotamento.controller;

import com.loja.empacotamento.model.Pedido;
import com.loja.empacotamento.service.PedidoService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pedidos")
public class PedidoController {

    @Autowired
    private PedidoService pedidoService;

    @PostMapping
    @Operation(summary = "Cria um novo pedido")
    public Pedido criarPedido(@Valid @RequestBody Pedido pedido) {
        return pedidoService.criarPedido(pedido);
    }

    @PutMapping("/{pedidoId}")
    @Operation(summary = "Edita um pedido existente pelo ID")
    public Pedido editarPedido(@PathVariable String pedidoId, @Valid @RequestBody Pedido pedido) {
        return pedidoService.editarPedido(pedidoId, pedido);
    }

    @DeleteMapping("/{pedidoId}")
    @Operation(summary = "Exclui um pedido pelo ID")
    public void excluirPedido(@PathVariable String pedidoId) {
        pedidoService.excluirPedido(pedidoId);
    }

    @GetMapping("/{pedidoId}")
    @Operation(summary = "Busca um pedido pelo ID")
    public Pedido buscarPedido(@PathVariable String pedidoId) {
        return pedidoService.buscarPedido(pedidoId);
    }

    @GetMapping
    @Operation(summary = "Lista todos os pedidos")
    public List<Pedido> listarPedidos() {
        return pedidoService.listarPedidos();
    }
}