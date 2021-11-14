package br.com.desafio.transacao.entities;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
@Builder
public class Saldo {

    private List<Transacao> transacaoList;
    private BigDecimal saldoEmConta;
}
