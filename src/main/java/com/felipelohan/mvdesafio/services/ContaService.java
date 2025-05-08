package com.felipelohan.mvdesafio.services;

import com.felipelohan.mvdesafio.entities.Conta;
import com.felipelohan.mvdesafio.repository.ContaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContaService {

    @Autowired
    private ContaRepository contaRepository;

    public Conta salvar(Conta conta) {
        return contaRepository.save(conta);
    }

    public List<Conta> listar() {
        return contaRepository.findAll();
    }

    public Optional<Conta> buscarPorId(Long id) {
        return contaRepository.findById(id);
    }

    public boolean deletar(Long id) {
        if (contaRepository.existsById(id)) {
            contaRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
