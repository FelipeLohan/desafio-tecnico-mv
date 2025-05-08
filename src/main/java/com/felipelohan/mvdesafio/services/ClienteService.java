package com.felipelohan.mvdesafio.services;

import com.felipelohan.mvdesafio.entities.Cliente;
import com.felipelohan.mvdesafio.repository.ClienteRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    private final ClienteRepository clienteRepository;

    public Cliente salvar(Cliente cliente) {
        if (clienteRepository.existsByCpfCnpj(cliente.getCpfCnpj())) {
            throw new RuntimeException("CPF/CNPJ já cadastrado.");
        }
        return clienteRepository.save(cliente);
    }

    public List<Cliente> listar() {
        return clienteRepository.findAll();
    }

    public Optional<Cliente> buscarPorId(Long id) {
        return clienteRepository.findById(id);
    }

    public void deletar(Long id) {
        clienteRepository.deleteById(id);
    }
}

