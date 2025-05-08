package com.felipelohan.mvdesafio.repository;

import com.felipelohan.mvdesafio.entities.Movimentacao;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MovimentacaoRepository extends JpaRepository<Movimentacao, Long> {
    List<Movimentacao> findByConta_Cliente_Id(Long clienteId);
}
