package com.loja.empacotamento.model;

import jakarta.persistence.*;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Classe que representa Produto empacotado em uma caixa")
public class ProdutoEmpacotado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "ID do produto empacotado")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "produto_id")
    @Schema(description = "Produto empacotado")
    private Produto produto;

    @ManyToOne
    @JoinColumn(name = "caixa_id")
    @Schema(description = "Caixa usada")
    private Caixa caixa;

    @ManyToOne
    @JoinColumn(name = "resultado_id")
    @Schema(description = "Resultado de empacotamento que este produto pertence")
    private ResultadoEmpacotamento resultadoEmpacotamento;
}