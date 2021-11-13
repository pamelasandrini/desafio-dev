package br.com.desafio.transacao.outlayer.gateway.repository;

import br.com.desafio.transacao.entities.Transacao;
import br.com.desafio.transacao.outlayer.gateway.adapter.TransacaoAdapter;
import br.com.desafio.transacao.outlayer.gateway.repository.sqlserver.TransacaoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class TransacaoGateway {

    private final TransacaoRepository transacaoRepository;

    public void save(final List<Transacao> transacaoList) {

        try {
            transacaoRepository.saveAll(
                TransacaoAdapter.adpat(transacaoList)
            );

        } catch (final Exception e) {
            System.out.println("Erro ao salvar transação no banco, " + e);
        }
    }
}
