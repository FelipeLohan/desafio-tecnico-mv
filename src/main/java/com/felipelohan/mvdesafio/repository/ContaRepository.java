package com.felipelohan.mvdesafio.repository;

import com.felipelohan.mvdesafio.entities.Conta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContaRepository extends JpaRepository<Conta, Long> {
}
