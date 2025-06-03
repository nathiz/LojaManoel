package com.loja.empacotamento.service;

import com.loja.empacotamento.dto.ProdutoRequestDTO;
import com.loja.empacotamento.dto.ProdutoResponseDTO;
import com.loja.empacotamento.model.Produto;
import com.loja.empacotamento.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    public List<ProdutoResponseDTO> listarTodos() {
        return produtoRepository.findAll().stream().map(this::toDTO).collect(Collectors.toList());
    }

    public ProdutoResponseDTO buscarPorId(Long id) {
        Produto produto = produtoRepository.findById(id).orElseThrow(() -> new RuntimeException("Produto não encontrado"));
        return toDTO(produto);
    }

    public ProdutoResponseDTO criar(ProdutoRequestDTO dto) {
        Produto produto = new Produto();
        produto.setNome(dto.getNome());
        produto.setAltura(dto.getAltura());
        produto.setLargura(dto.getLargura());
        produto.setComprimento(dto.getComprimento());
        produto.setPesoEmGramas(dto.getPesoEmGramas());
        produto = produtoRepository.save(produto);
        return toDTO(produto);
    }

    public ProdutoResponseDTO atualizar(Long id, ProdutoRequestDTO dto) {
        Produto produto = produtoRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Produto não encontrado"));
        produto.setNome(dto.getNome());
        produto.setAltura(dto.getAltura());
        produto.setLargura(dto.getLargura());
        produto.setComprimento(dto.getComprimento());
        produto.setPesoEmGramas(dto.getPesoEmGramas());
        produto = produtoRepository.save(produto);
        return toDTO(produto);
    }

    public void deletar(Long id) {
        produtoRepository.deleteById(id);
    }

    private ProdutoResponseDTO toDTO(Produto produto) {
        ProdutoResponseDTO dto = new ProdutoResponseDTO();
        dto.setId(produto.getId());
        dto.setNome(produto.getNome());
        dto.setAltura(produto.getAltura());
        dto.setLargura(produto.getLargura());
        dto.setComprimento(produto.getComprimento());
        dto.setPesoEmGramas(produto.getPesoEmGramas());
        return dto;
    }

}