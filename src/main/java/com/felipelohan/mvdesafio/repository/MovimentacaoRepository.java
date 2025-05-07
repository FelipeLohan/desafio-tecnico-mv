package com.felipelohan.mvdesafio.repository;

import com.felipelohan.mvdesafio.entities.Movimentacao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovimentacaoRepository extends JpaRepository<Movimentacao, Long> {
}
