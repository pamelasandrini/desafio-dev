package br.com.desafio.transacao.outlayer.gateway.adapter

import br.com.desafio.structural.CommonsConfig
import br.com.desafio.transacao.entities.Transacao
import br.com.desafio.transacao.outlayer.gateway.repository.entities.TransacaoTemplate
import spock.lang.Specification

class TransacaoAdapterTest extends Specification {

    def "valida transacao adapter"() {
        given: "uma transacao"
        def transacao = CommonsConfig.fixture(Transacao.class, TransacaoTemplate.TRANSACAO_1)
        def idLoja = 001

        when: "chamar o adpater"
        def transacaoEntity = TransacaoAdapter.adpat(transacao, idLoja)

        then: "o resultado deve ser esperado"
        transacaoEntity.hora == transacao.hora
        transacaoEntity.cartao == transacao.cartao
        transacaoEntity.cpf == transacao.cpf
        transacaoEntity.valor == transacao.valor
        transacaoEntity.data == transacao.data
        transacaoEntity.tipoTransacao == transacao.tipoTransacao.codigo
        transacaoEntity.idLoja == idLoja
    }

}
