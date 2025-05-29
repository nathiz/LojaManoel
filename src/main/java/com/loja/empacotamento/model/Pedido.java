package com.loja.empacotamento.model;

import jakarta.persistence.*;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "pedido")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Classe que representa um Pedido realizado por um cliente")
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "ID do pedido")
    private Long id;

    @Column(name = "nome_cliente")
    @Schema(description = "Nome do cliente que fez o pedido")
    private String nomeCliente;

    @OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL)
    @Schema(description = "Lista de produtos do pedido")
    private List<Produto> produtos;

    @OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL)
    @Schema(description = "Resultado do empacotamento")
    private List<ResultadoEmpacotamento> resultados;
}