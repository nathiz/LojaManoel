package com.loja.empacotamento.dto;

import lombok.Data;

@Data
public class ProdutoResponseDTO {
    private Long id;
    private String nome;
    private int altura;
    private int largura;
    private int comprimento;
    private int pesoEmGramas;
}