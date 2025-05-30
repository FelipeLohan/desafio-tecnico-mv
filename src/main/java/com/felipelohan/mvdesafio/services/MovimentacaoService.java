package com.felipelohan.mvdesafio.services;

import com.felipelohan.mvdesafio.entities.Movimentacao;
import com.felipelohan.mvdesafio.repository.MovimentacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
public class MovimentacaoService {

    @Autowired
    private MovimentacaoRepository movimentacaoRepository;

    public Movimentacao criarMovimentacao(Movimentacao movimentacao) {
        return movimentacaoRepository.save(movimentacao);
    }

    public List<Movimentacao> listarMovimentacoes() {
        return movimentacaoRepository.findAll();
    }

    public Optional<Movimentacao> buscarMovimentacaoPorId(Long id) {
        return movimentacaoRepository.findById(id);
    }

    public boolean excluirMovimentacao(Long id) {
        if (movimentacaoRepository.existsById(id)) {
            movimentacaoRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public BigDecimal calcularReceitaEmpresa(Long clienteId) {
        // Usando a navegação correta: Conta → Cliente → Id
        List<Movimentacao> movimentacoes = movimentacaoRepository.findByConta_Cliente_Id(clienteId);
        int numMovimentacoes = movimentacoes.size();
        BigDecimal receita = BigDecimal.ZERO;

        // Cálculo com faixas de movimentações
        if (numMovimentacoes <= 10) {
            receita = BigDecimal.valueOf(numMovimentacoes).multiply(BigDecimal.ONE);
        } else if (numMovimentacoes <= 20) {
            receita = BigDecimal.valueOf(numMovimentacoes).multiply(BigDecimal.valueOf(0.75));
        } else {
            receita = BigDecimal.valueOf(numMovimentacoes).multiply(BigDecimal.valueOf(0.50));
        }

        return receita;
    }
}
