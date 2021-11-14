package br.com.desafio.transacao.outlayer.gateway.repository.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Builder
@Entity
@AllArgsConstructor
@RequiredArgsConstructor
@Table(name = "loja", uniqueConstraints = @UniqueConstraint(columnNames = {"dono", "nome"}))
public class LojaEntity implements Serializable {

    @Id
    @Column(name = "id_loja")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;
    private String dono;
    private String nome;
}
