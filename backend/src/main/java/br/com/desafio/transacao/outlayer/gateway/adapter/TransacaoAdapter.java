package br.com.desafio.transacao.outlayer.gateway.adapter;

import br.com.desafio.transacao.entities.TipoTransacao;
import br.com.desafio.transacao.entities.Transacao;
import br.com.desafio.transacao.outlayer.gateway.repository.entities.TransacaoEntity;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class TransacaoAdapter {

    public static TransacaoEntity adpat(final Transacao transacao, final Integer idLoja) {
        return TransacaoEntity.builder()
            .cartao(transacao.getCartao())
            .cpf(transacao.getCpf())
            .data(transacao.getData())
            .hora(transacao.getHora())
            .tipoTransacao(transacao.getTipoTransacao().getCodigo())
            .valor(transacao.getValor())
            .idLoja(idLoja)
            .build();
    }

    public static List<TransacaoEntity> adpat(final List<Transacao> transacaoList, final Integer idLoja) {

        final List<TransacaoEntity> transacaoEntityList = new ArrayList<>();
        transacaoList.forEach(t -> transacaoEntityList.add(adpat(t, idLoja)));

        return transacaoEntityList;
    }

    public static Transacao adpat(final TransacaoEntity transacaoEntity) {
        return Transacao.builder()
            .cartao(transacaoEntity.getCartao())
            .cpf(transacaoEntity.getCpf())
            .data(transacaoEntity.getData())
            .hora(transacaoEntity.getHora())
            .tipoTransacao(TipoTransacao.getTipoTransacaoByCodigo(transacaoEntity.getTipoTransacao()))
            .valor(transacaoEntity.getValor())
            .build();
    }
}
