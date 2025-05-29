package com.loja.empacotamento.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data // Lombok: cria getters, setters, toString, equals, hashCode
@NoArgsConstructor // Lombok: construtor sem argumentos
@AllArgsConstructor // Lombok: construtor com todos os argumentos
@Schema(description = "Entidade que representa uma caixa para empacotamento")
public class Caixa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "Identificador único da caixa", example = "1")
    private Long id;

    @Schema(description = "Tipo da caixa", example = "Papelão")
    private String tipo;

    @Schema(description = "Altura da caixa em centímetros", example = "30")
    private int altura;

    @Schema(description = "Largura da caixa em centímetros", example = "20")
    private int largura;

    @Schema(description = "Comprimento da caixa em centímetros", example = "40")
    private int comprimento;

    public double getVolume() {
        return altura * largura * comprimento;
    }
}