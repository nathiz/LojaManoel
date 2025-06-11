package com.loja.empacotamento.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmpacotarResponse {
    private String nomeCliente;
    private List<CaixaUsadaResponse> caixasUsadas;
}