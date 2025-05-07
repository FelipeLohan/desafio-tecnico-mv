package com.felipelohan.mvdesafio.controllers;

import com.felipelohan.mvdesafio.entities.Movimentacao;
import com.felipelohan.mvdesafio.services.MovimentacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/movimentacoes")
public class MovimentacaoController {

    @Autowired
    private MovimentacaoService movimentacaoService;

    @PostMapping
    public ResponseEntity<Movimentacao> criarMovimentacao(@RequestBody Movimentacao movimentacao) {
        Movimentacao novaMovimentacao = movimentacaoService.criarMovimentacao(movimentacao);
        return ResponseEntity.status(HttpStatus.CREATED).body(novaMovimentacao);
    }

    @GetMapping
    public ResponseEntity<List<Movimentacao>> listarMovimentacoes() {
        List<Movimentacao> movimentacoes = movimentacaoService.listarMovimentacoes();
        return ResponseEntity.ok(movimentacoes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Movimentacao> buscarMovimentacaoPorId(@PathVariable Long id) {
        Optional<Movimentacao> movimentacao = movimentacaoService.buscarMovimentacaoPorId(id);
        return movimentacao.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluirMovimentacao(@PathVariable Long id) {
        boolean excluido = movimentacaoService.excluirMovimentacao(id);
        return excluido ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }

    @GetMapping("/calcular-receita/{clienteId}")
    public ResponseEntity<BigDecimal> calcularReceitaEmpresa(@PathVariable Long clienteId) {
        BigDecimal receita = movimentacaoService.calcularReceitaEmpresa(clienteId);
        return ResponseEntity.ok(receita);
    }
}
