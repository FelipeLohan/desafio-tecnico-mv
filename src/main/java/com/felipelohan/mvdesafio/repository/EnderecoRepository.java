package com.felipelohan.mvdesafio.repository;

import com.felipelohan.mvdesafio.entities.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnderecoRepository extends JpaRepository<Endereco, Long> {
}
