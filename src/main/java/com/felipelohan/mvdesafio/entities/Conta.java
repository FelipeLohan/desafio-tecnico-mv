package com.felipelohan.mvdesafio.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "contas")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Conta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "numero_conta", nullable = false, length = 20)
    private String numeroConta;

    @Column(name = "agencia", nullable = false, length = 10)
    private String agencia;

    @Column(name = "instituicao_financeira", nullable = false, length = 100)
    private String instituicaoFinanceira;

    @Column(name = "ativo", nullable = false)
    private Boolean ativo = true;

    @ManyToOne
    @JoinColumn(name = "cliente_id", nullable = false)
    private Cliente cliente;

    @OneToMany(mappedBy = "conta", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Movimentacao> movimentacoes;
}
