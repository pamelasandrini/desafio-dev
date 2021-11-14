package br.com.desafio.transacao.outlayer.gateway.repository;

import br.com.desafio.transacao.entities.Loja;
import br.com.desafio.transacao.outlayer.gateway.adapter.LojaAdapter;
import br.com.desafio.transacao.outlayer.gateway.repository.entities.LojaEntity;
import br.com.desafio.transacao.outlayer.gateway.repository.sqlserver.LojaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class LojaGateway {

    private final LojaRepository lojaRepository;

    public List<Loja> getLojas() {

        final List<Loja> lojaList = new ArrayList<>();
        for (final LojaEntity lojaEntity : lojaRepository.findAll()) {

            final Loja loja = LojaAdapter.adapt(lojaEntity);
            lojaList.add(loja);
        }
        return lojaList;
    }
}
