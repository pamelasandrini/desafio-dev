package br.com.desafio.transacao.entities;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Loja {
    private Integer id;
    private String dono;
    private String nome;
}
