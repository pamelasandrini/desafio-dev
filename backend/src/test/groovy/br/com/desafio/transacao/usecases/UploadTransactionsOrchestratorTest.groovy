package br.com.desafio.transacao.usecases

import br.com.desafio.structural.CommonsConfig
import br.com.desafio.transacao.outlayer.gateway.repository.TransacaoGateway
import spock.lang.Specification

class UploadTransactionsOrchestratorTest extends Specification {

    def static validFile = "sucesso.txt"

    private ExtractTransacaoFile extractTransacaoFile = Mock()
    private TransacaoGateway transacaoGateway = Mock()
    UploadTransactionsOrchestrator uploadTransactionsOrchestrator = new UploadTransactionsOrchestrator(extractTransacaoFile, transacaoGateway)


    def "faz o upload do arquivo"() {
        given: "dado um arquivo txt válido"
        def file = CommonsConfig.createMockMultipartFile(validFile)

        and: "não há erro na extração o arquivo"
        1 * extractTransacaoFile.execute(file) >> null

        and: "não há problema de persistencia"
        1 * transacaoGateway.save(_) >> {}

        when: "chamar o extrator"
        uploadTransactionsOrchestrator.execute(file)

        then: "deve salvar os dados com sucesso no banco"
        notThrown(Exception)
    }
}
