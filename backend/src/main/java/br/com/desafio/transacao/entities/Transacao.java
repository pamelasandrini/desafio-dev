package br.com.desafio.transacao.entities;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class Transacao {
    private TipoTransacao tipoTransacao;
    private String data;
    private BigDecimal valor;
    private String cpf;
    private String cartao;
    private String hora;
}
