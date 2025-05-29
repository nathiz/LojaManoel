package com.loja.empacotamento.model;

import jakarta.persistence.*;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "resultado_empacotamento")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Resultado de empacotamento de um pedido")
public class ResultadoEmpacotamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "ID do resultado")
    private Long id;

    @OneToOne
    @JoinColumn(name = "pedido_id", nullable = false)
    @Schema(description = "Pedido relacionado")
    private Pedido pedido;

    @Schema(description = "Total de caixas usadas")
    @Column(name = "total_caixas_utilizadas")
    private int totalCaixasUtilizadas;

    @OneToMany(mappedBy = "resultadoEmpacotamento", cascade = CascadeType.ALL, orphanRemoval = true)
    @Schema(description = "Lista de produtos empacotados")
    private List<ProdutoEmpacotado> produtosEmpacotados;
}