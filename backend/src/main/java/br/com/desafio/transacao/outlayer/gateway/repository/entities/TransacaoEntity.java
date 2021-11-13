package br.com.desafio.transacao.outlayer.gateway.repository.entities;

import lombok.Builder;
import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "transacao")
@Data
@Builder
public class TransacaoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private Integer tipoTransacao;
    private String data;
    private BigDecimal valor;
    private String cpf;
    private String cartao;
    private String hora;

    @ManyToOne(cascade = CascadeType.PERSIST)
    private LojaEntity loja;
}
