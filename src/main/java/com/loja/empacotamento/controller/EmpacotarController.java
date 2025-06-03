package com.loja.empacotamento.controller;

import com.loja.empacotamento.dto.EmpacotarRequest;
import com.loja.empacotamento.dto.EmpacotarResponse;
import com.loja.empacotamento.dto.ProdutoDTO;
import com.loja.empacotamento.service.EmpacotamentoService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/empacotar")
public class EmpacotarController {

    @Autowired
    private EmpacotamentoService service;

    @PostMapping
    @Operation(summary = "Empacota pedidos em caixas de papelão disponíveis")
    public EmpacotarResponse empacotar(@Valid @RequestBody EmpacotarRequest request) {
        return service.empacotar(request);
    }

    @NotBlank(message = "O nome do cliente é obrigatório")
    private String nomeCliente;

    @NotEmpty(message = "A lista de produtos não pode estar vazia")
    private List<ProdutoDTO> produtos;
}