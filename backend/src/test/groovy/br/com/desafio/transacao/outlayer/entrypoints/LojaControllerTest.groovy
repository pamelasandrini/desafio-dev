package br.com.desafio.transacao.outlayer.entrypoints

import br.com.desafio.structural.CommonsConfig
import br.com.desafio.transacao.entities.Loja
import br.com.desafio.transacao.outlayer.gateway.repository.LojaGateway
import br.com.desafio.transacao.outlayer.gateway.repository.entities.LojaTemplate
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.boot.test.context.TestConfiguration
import org.springframework.context.annotation.Bean
import org.springframework.http.HttpMethod
import org.springframework.http.HttpStatus
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.MvcResult
import spock.lang.Specification

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.request

@WebMvcTest(controllers = [LojaController])
class LojaControllerTest extends Specification {

    @Autowired
    private MockMvc mvc

    @Autowired
    private LojaGateway lojaGateway

    @TestConfiguration
    static class Mocks extends CommonsConfig {
        @Bean
        LojaGateway lojaGateway() {
            factory.Mock(LojaGateway) as LojaGateway
        }
    }

    def "Busca lojas"() {

        when: "Realizar a chamada ao endpoint de upload"
        MvcResult result = mvc
            .perform(request(HttpMethod.GET, "/v1/lojas")
            ).andReturn()

        then: "o gateway devolve a lista de lojas no banco"
        1 * lojaGateway.getLojas() >> [CommonsConfig.fixture(Loja.class, LojaTemplate.LOJA_1)]

        expect: "o status code deve ser esperado"
        result.getResponse().getStatus() == HttpStatus.OK.value()
    }
}
