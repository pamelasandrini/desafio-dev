package br.com.desafio.transacao.outlayer.gateway.repository

import br.com.desafio.structural.CommonsConfig
import br.com.desafio.transacao.entities.Loja
import br.com.desafio.transacao.entities.Transacao
import br.com.desafio.transacao.outlayer.gateway.repository.entities.LojaEntity
import br.com.desafio.transacao.outlayer.gateway.repository.entities.LojaTemplate
import br.com.desafio.transacao.outlayer.gateway.repository.entities.TransacaoTemplate
import br.com.desafio.transacao.outlayer.gateway.repository.sqlserver.LojaRepository
import br.com.desafio.transacao.outlayer.gateway.repository.sqlserver.TransacaoRepository
import spock.lang.Specification

class TransacaoGatewayTest extends Specification {

    private LojaRepository lojaRepository = Mock()
    private TransacaoRepository transacaoRepository = Mock()
    TransacaoGateway transacaoGateway = new TransacaoGateway(lojaRepository, transacaoRepository)

    def "valida metodo save com sucesso"() {
        given: "um mapa de loja e transação"
        def transacao = CommonsConfig.fixture(Transacao.class, TransacaoTemplate.TRANSACAO_1)
        def loja = CommonsConfig.fixture(Loja.class, LojaTemplate.LOJA_1)
        def transacaoMap = [(loja): [transacao]]

        and: "chamar o repository com sucesso"
        1 * lojaRepository.save(_) >> {
            LojaEntity.builder()
                .nome("José")
                .dono("Padaria do Zé")
                .id(12)
                .build()
        }

        1 * transacaoRepository.saveAll(_) >> {}

        when: "salvar o objeto no banco"
        transacaoGateway.save(transacaoMap)

        then: "deve salvar com sucesso"
        notThrown(Exception)
    }
}
