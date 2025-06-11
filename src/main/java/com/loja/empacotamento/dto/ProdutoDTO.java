package com.loja.empacotamento.dto;

import lombok.Data;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Data
public class ProdutoDTO {

    @NotBlank
    private String nome;

    @NotNull
    private Double altura;

    @NotNull
    private Double largura;

    @NotNull
    private Double comprimento;

    @NotNull
    private Double pesoEmGramas;
}