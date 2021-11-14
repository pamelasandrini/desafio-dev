package br.com.desafio.transacao.outlayer.gateway.repository

import br.com.desafio.structural.CommonsConfig
import br.com.desafio.transacao.entities.Loja
import br.com.desafio.transacao.outlayer.gateway.repository.entities.LojaEntity
import br.com.desafio.transacao.outlayer.gateway.repository.entities.LojaTemplate
import br.com.desafio.transacao.outlayer.gateway.repository.sqlserver.LojaRepository
import spock.lang.Specification

class LojaGatewayTest extends Specification {


    private final LojaRepository lojaRepository = Mock()
    private LojaGateway lojaGateway = new LojaGateway(lojaRepository)

    def "Busca todas as lojas do banco"() {
        when: "ao chamar o gateway"
        def lojas = lojaGateway.getLojas()

        then: "será buscada todas as lojas do banco"
        1 * lojaRepository.findAll() >> [CommonsConfig.fixture(LojaEntity.class, LojaEntityTemplate.LOJA_1)]

        expect: "a resposta esperada"
        lojas.size() == 1
        lojas[0] == CommonsConfig.fixture(Loja.class, LojaTemplate.LOJA_1)
    }
}
