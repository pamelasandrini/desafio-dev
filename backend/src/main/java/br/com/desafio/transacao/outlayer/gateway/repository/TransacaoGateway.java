package br.com.desafio.transacao.outlayer.gateway.repository;

import br.com.desafio.transacao.entities.Loja;
import br.com.desafio.transacao.entities.Transacao;
import br.com.desafio.transacao.outlayer.gateway.adapter.LojaAdapter;
import br.com.desafio.transacao.outlayer.gateway.adapter.TransacaoAdapter;
import br.com.desafio.transacao.outlayer.gateway.repository.entities.LojaEntity;
import br.com.desafio.transacao.outlayer.gateway.repository.entities.TransacaoEntity;
import br.com.desafio.transacao.outlayer.gateway.repository.sqlserver.LojaRepository;
import br.com.desafio.transacao.outlayer.gateway.repository.sqlserver.TransacaoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Component
@RequiredArgsConstructor
public class TransacaoGateway {

    private final LojaRepository lojaRepository;
    private final TransacaoRepository transacaoRepository;

    public void save(final Map<Loja, List<Transacao>> transacaoMap) {

        transacaoMap.forEach((key, value) -> {
            Integer idLoja;
            try {
                final LojaEntity lojaEntity = lojaRepository.save(LojaAdapter.adapt(key));
                idLoja = lojaEntity.getId();
            } catch (final Exception e) {
                System.out.println("Erro ao salvar loja no banco, " + e);

                final LojaEntity lojaEntity = lojaRepository.findByNomeAndDono(key.getNome(), key.getDono());
                idLoja = lojaEntity.getId();
            }
            try {
                transacaoRepository.saveAll(TransacaoAdapter.adpat(value, idLoja));
            } catch (final Exception e) {
                System.out.println("Erro ao salvar transação no banco, " + e);
            }
        });
    }

    public List<Transacao> getTrasacoesByLojaId(final Integer id) {

        final List<Transacao> transacaoList = new ArrayList<>();

        final List<TransacaoEntity> transacaoEntityList = transacaoRepository.findByIdLoja(id);
        for (final TransacaoEntity transacaoEntity : transacaoEntityList) {
            final Transacao transacao = TransacaoAdapter.adpat(transacaoEntity);
            transacaoList.add(transacao);
        }

        return transacaoList;
    }
}
