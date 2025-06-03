package com.loja.empacotamento.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.loja.empacotamento.dto.ProdutoDTO;
import com.loja.empacotamento.dto.EmpacotarRequest;
import org.junit.jupiter.api.DisplayName;
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
public class EmpacotarControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    @DisplayName("Deve empacotar produtos em caixas e retornar nome do cliente e lista de caixas usadas")
    public void testEmpacotarPedidoComProdutos() throws Exception {
        ProdutoDTO produto1 = new ProdutoDTO();
        produto1.setNome("Livro");
        produto1.setAltura(2);
        produto1.setLargura(15);
        produto1.setComprimento(22);

        ProdutoDTO produto2 = new ProdutoDTO();
        produto2.setNome("Cubo Mágico");
        produto2.setAltura(7);
        produto2.setLargura(7);
        produto2.setComprimento(7);

        EmpacotarRequest request = new EmpacotarRequest();
        request.setNomeCliente("Carlos");
        request.setProdutos(List.of(produto1, produto2));

        mockMvc.perform(post("/api/empacotar")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.nomeCliente").value("Carlos"))
                .andExpect(jsonPath("$.caixasUsadas", hasSize(greaterThan(0))))
                .andExpect(jsonPath("$.caixasUsadas[0].produtos[0].nome", isOneOf("Livro", "Cubo Mágico")));
    }

    @Test
    @DisplayName("Deve retornar erro 400 quando a lista de produtos estiver vazia")
    public void testEmpacotarPedidoSemProdutos() throws Exception {
        EmpacotarRequest request = new EmpacotarRequest();
        request.setNomeCliente("João");
        request.setProdutos(List.of());

        mockMvc.perform(post("/api/empacotar")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isBadRequest());
    }

    @Test
    @DisplayName("Deve retornar erro 400 quando nome do cliente estiver vazio")
    public void testEmpacotarPedidoSemNomeCliente() throws Exception {
        ProdutoDTO produto = new ProdutoDTO();
        produto.setNome("Caneta");
        produto.setAltura(1);
        produto.setLargura(1);
        produto.setComprimento(14);

        EmpacotarRequest request = new EmpacotarRequest();
        request.setNomeCliente(""); // Nome vazio
        request.setProdutos(List.of(produto));

        mockMvc.perform(post("/api/empacotar")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isBadRequest());
    }
}