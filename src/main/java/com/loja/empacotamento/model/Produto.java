package com.loja.empacotamento.model;

import jakarta.persistence.*;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Classe que representa Produto")
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "ID do produto")
    private Long id;

    @Schema(description = "Nome do produto")
    private String nome;

    @Schema(description = "Altura em cm")
    @Column(name = "altura")
    private int altura;

    @Schema(description = "Largura em cm")
    @Column(name = "largura")
    private int largura;

    @Schema(description = "Comprimento em cm")
    @Column(name = "comprimento")
    private int comprimento;

    @Column(name = "peso_em_gramas")
    private int pesoEmGramas;

    @ManyToOne
    @JoinColumn(name = "pedido_id")
    private Pedido pedido;

    public double getVolume() {
        return altura * largura * comprimento;
    }

    public Produto(Long id, String nome, int altura, int largura, int comprimento, Pedido pedido) {
        this.id = id;
        this.nome = nome;
        this.altura = altura;
        this.largura = largura;
        this.comprimento = comprimento;
        this.pesoEmGramas = 0;
        this.pedido = pedido;
    }
}
