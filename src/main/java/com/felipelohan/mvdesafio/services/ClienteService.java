package com.felipelohan.mvdesafio.services;

import com.felipelohan.mvdesafio.entities.Cliente;
import com.felipelohan.mvdesafio.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public Cliente salvar(Cliente cliente) {
        return clienteRepository.save(cliente);
    }
}
