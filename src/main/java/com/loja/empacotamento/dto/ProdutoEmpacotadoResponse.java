package com.loja.empacotamento.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProdutoEmpacotadoResponse {
    private String nome;
    private Integer altura;
    private Integer largura;
    private Integer comprimento;
}