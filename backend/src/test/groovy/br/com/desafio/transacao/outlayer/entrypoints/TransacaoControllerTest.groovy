package br.com.desafio.transacao.outlayer.entrypoints

import br.com.desafio.structural.CommonsConfig
import br.com.desafio.transacao.usecases.UploadTransactionsOrchestrator
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.boot.test.context.TestConfiguration
import org.springframework.context.annotation.Bean
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.MvcResult
import org.springframework.web.multipart.MultipartFile
import spock.lang.Specification

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.multipart

@WebMvcTest(controllers = [TransacaoController])
class TransacaoControllerTest extends Specification {


    @Autowired
    private MockMvc mvc

    @Autowired
    private UploadTransactionsOrchestrator uploadTransactionsOrchestrator

    @TestConfiguration
    static class Mocks extends CommonsConfig {
        @Bean
        UploadTransactionsOrchestrator uploadTransactionsOrchestrator() {
            factory.Mock(UploadTransactionsOrchestrator) as UploadTransactionsOrchestrator
        }
    }

    def "Upload de transacoes"() {

        given: "Um arquivo válido"
        MultipartFile mockMultipartFile = CommonsConfig.createMockMultipartFile("sucesso.txt")

        when: "Realizar a chamada ao endpoint de upload"
        MvcResult result = mvc
            .perform(multipart("/v1/transacoes/upload")
                .file(mockMultipartFile)
                .contentType(MediaType.MULTIPART_FORM_DATA)
            ).andReturn()

        then: "o orquestrador deve processar o arquivo e salvar no banco"
        1 * uploadTransactionsOrchestrator.execute(_) >> {}

        expect: "o status code deve ser esperado"
        result.getResponse().getStatus() == HttpStatus.CREATED.value()
    }
}
