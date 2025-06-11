package com.loja.empacotamento.dto;

import lombok.Data;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import java.util.List;

@Data
public class EmpacotarRequest {
    
    @NotBlank(message = "nomeCliente é obrigatório")
    private String nomeCliente;
    
    @NotEmpty(message = "produtos não pode estar vazio")
    private List<ProdutoDTO> produtos;
}