package com.loja.empacotamento.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.loja.empacotamento.dto.ProdutoDTO;
import com.loja.empacotamento.dto.EmpacotarRequest;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

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
                .andExpect(jsonPath("$.caixasUsadas").isArray());
    }
}
