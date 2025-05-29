package com.loja.empacotamento.dto;

import lombok.Data;
import java.util.List;

@Data
public class EmpacotarRequest {
    private String nomeCliente;
    private List<ProdutoDTO> produtos;
}