package br.com.desafio.transacao.outlayer.gateway.repository.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@Table(name = "transacao")
@Data
@Builder
@AllArgsConstructor
@RequiredArgsConstructor
public class TransacaoEntity implements Serializable {

    @Id
    @Column(name = "id_transacao")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;
    private Integer tipoTransacao;
    private String data;
    private BigDecimal valor;
    private String cpf;
    private String cartao;
    private String hora;
    @Column(name = "id_loja")
    private Integer idLoja;
}
