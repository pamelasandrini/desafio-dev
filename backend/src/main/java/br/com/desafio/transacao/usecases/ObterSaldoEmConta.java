package br.com.desafio.transacao.usecases;

import br.com.desafio.transacao.entities.Saldo;
import br.com.desafio.transacao.entities.Transacao;
import br.com.desafio.transacao.outlayer.gateway.repository.TransacaoGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ObterSaldoEmConta {

    private final TransacaoGateway transacaoGateway;

    public Saldo execute(final Integer idLoja) {

        final List<Transacao> trasacaoList = transacaoGateway.getTrasacoesByLojaId(idLoja);
        return Saldo.builder()
            .transacaoList(trasacaoList)
            .saldoEmConta(calculateSaldo(trasacaoList))
            .build();
    }

    private BigDecimal calculateSaldo(final List<Transacao> trasacList) {

        BigDecimal saldo = new BigDecimal(0);
        for (final Transacao transacao : trasacList) {

            if ("+".equals(transacao.getTipoTransacao().getNaturezaTipoTransacao().getSinal())) {
                saldo = saldo.add(transacao.getValor());
            } else {
                saldo = saldo.subtract(transacao.getValor());
            }
        }

        return saldo;
    }
}
