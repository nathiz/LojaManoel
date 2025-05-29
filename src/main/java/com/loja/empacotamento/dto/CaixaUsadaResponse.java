package com.loja.empacotamento.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.util.List;

@Data
@AllArgsConstructor
public class CaixaUsadaResponse {
    private String tipoCaixa;
    private List<String> produtos;
}