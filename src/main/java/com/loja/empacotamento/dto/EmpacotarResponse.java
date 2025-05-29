package com.loja.empacotamento.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.util.List;

@Data
@AllArgsConstructor
public class EmpacotarResponse {
    private String nomeCliente;
    private List<CaixaUsadaResponse> caixasUsadas;
}