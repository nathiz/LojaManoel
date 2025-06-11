package com.loja.empacotamento.dto;

import lombok.Data;

@Data
public class ProdutoRequestDTO {
    private String nome;
    private Double altura;
    private Double largura;
    private Double comprimento;
    private Double pesoEmGramas;
}