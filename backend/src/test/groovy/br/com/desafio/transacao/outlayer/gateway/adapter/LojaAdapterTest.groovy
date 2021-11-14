package br.com.desafio.transacao.outlayer.gateway.adapter

import br.com.desafio.structural.CommonsConfig
import br.com.desafio.transacao.entities.Loja
import br.com.desafio.transacao.outlayer.gateway.repository.entities.LojaTemplate
import spock.lang.Specification

class LojaAdapterTest extends Specification {

    def "valida loja adapter"() {
        given: "uma loja"
        def loja = CommonsConfig.fixture(Loja.class, LojaTemplate.LOJA_1)

        when: "chamar o adpater"
        def lojaEntity = LojaAdapter.adapt(loja)

        then: "o resultado deve ser esperado"
        lojaEntity.dono == loja.dono
        lojaEntity.nome == loja.nome
    }

}
