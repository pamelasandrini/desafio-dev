package br.com.desafio.transacao.outlayer.gateway.adapter;

import br.com.desafio.transacao.entities.Loja;
import br.com.desafio.transacao.outlayer.gateway.repository.entities.LojaEntity;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class LojaAdapter {

    public static LojaEntity adapt(final Loja loja) {

        return LojaEntity.builder()
            .nome(loja.getNome())
            .dono(loja.getDono())
            .build();
    }

    public static Loja adapt(final LojaEntity lojaEntity) {
        return Loja.builder()
            .nome(lojaEntity.getNome())
            .dono(lojaEntity.getDono())
            .id(lojaEntity.getId())
            .build();
    }

}
