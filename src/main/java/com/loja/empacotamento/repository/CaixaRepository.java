package com.loja.empacotamento.repository;

import com.loja.empacotamento.model.Caixa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CaixaRepository extends JpaRepository<Caixa, Long> {
}