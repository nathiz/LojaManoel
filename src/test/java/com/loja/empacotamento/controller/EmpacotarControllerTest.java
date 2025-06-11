package com.loja.empacotamento.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.loja.empacotamento.dto.EmpacotarRequest;
import com.loja.empacotamento.dto.ProdutoDTO;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class EmpacotarControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    private ProdutoDTO criarProduto(String nome, double altura, double largura, double comprimento) {
        ProdutoDTO produto = new ProdutoDTO();
        produto.setNome(nome);
        produto.setAltura(altura);
        produto.setLargura(largura);
        produto.setComprimento(comprimento);
        return produto;
    }

    @Nested
    @DisplayName("POST /api/empacotar")
    class PostEmpacotar {

        @Test
        @DisplayName("Deve empacotar produtos corretamente e retornar status 200 com nome do cliente e caixas usadas")
        void deveEmpacotarProdutosComSucesso() throws Exception {
            EmpacotarRequest request = new EmpacotarRequest();
            request.setNomeCliente("Carlos");
            request.setProdutos(List.of(
                criarProduto("Livro", 2.0, 15.0, 22.0),
                criarProduto("Cubo Mágico", 7.0, 7.0, 7.0)
            ));

            mockMvc.perform(post("/api/empacotar")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(objectMapper.writeValueAsString(request)))
                    .andExpect(status().isOk())
                    .andExpect(jsonPath("$.nomeCliente").value("Carlos"))
                    .andExpect(jsonPath("$.caixasUsadas", hasSize(greaterThan(0))))
                    .andExpect(jsonPath("$.caixasUsadas[0].produtos[0].nome", isOneOf("Livro", "Cubo Mágico")));
        }

        @Test
        @DisplayName("Deve retornar erro 400 se não houver produtos no pedido")
        void deveFalharSemProdutos() throws Exception {
            EmpacotarRequest request = new EmpacotarRequest();
            request.setNomeCliente("João");
            request.setProdutos(List.of());

            mockMvc.perform(post("/api/empacotar")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(objectMapper.writeValueAsString(request)))
                    .andExpect(status().isBadRequest());
        }

        @Test
        @DisplayName("Deve retornar erro 400 se nome do cliente estiver vazio")
        void deveFalharSemNomeCliente() throws Exception {
            EmpacotarRequest request = new EmpacotarRequest();
            request.setNomeCliente("");
            request.setProdutos(List.of(
                criarProduto("Caneta", 1.0, 1.0, 14.0)
            ));

            mockMvc.perform(post("/api/empacotar")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(objectMapper.writeValueAsString(request)))
                    .andExpect(status().isBadRequest());
        }
    }
}