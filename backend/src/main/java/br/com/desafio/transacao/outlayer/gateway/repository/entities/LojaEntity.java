package br.com.desafio.transacao.outlayer.gateway.repository.entities;

import lombok.Builder;
import lombok.Data;

import javax.persistence.*;

@Data
@Builder
@Entity
@Table(name = "loja")
public class LojaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String dono;
    private String nome;
}
