package br.com.desafio.transacao.outlayer.gateway.adapter;

import br.com.desafio.transacao.entities.Transacao;
import br.com.desafio.transacao.outlayer.gateway.repository.entities.LojaEntity;
import br.com.desafio.transacao.outlayer.gateway.repository.entities.TransacaoEntity;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class TransacaoAdapter {

    public static TransacaoEntity adpat(final Transacao transacao) {

        final LojaEntity lojaEntity = LojaEntity.builder()
            .dono(transacao.getLoja().getDono())
            .nome(transacao.getLoja().getNome())
            .build();

        return TransacaoEntity.builder()
            .cartao(transacao.getCartao())
            .cpf(transacao.getCpf())
            .data(transacao.getData())
            .hora(transacao.getHora())
            .tipoTransacao(transacao.getTipoTransacao().getCodigo())
            .loja(lojaEntity)
            .valor(transacao.getValor())
            .build();
    }

    public static List<TransacaoEntity> adpat(final List<Transacao> transacao) {

        final List<TransacaoEntity> transacaoEntityList = new ArrayList<>();
        transacao.forEach(t -> transacaoEntityList.add(adpat(t)));

        return transacaoEntityList;
    }
}
