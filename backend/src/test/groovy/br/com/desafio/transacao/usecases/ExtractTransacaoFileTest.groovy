package br.com.desafio.transacao.usecases

import br.com.desafio.transacao.entities.TipoTransacao
import br.com.desafio.transacao.entities.Transacao
import org.springframework.mock.web.MockMultipartFile
import spock.lang.Specification

class ExtractTransacaoFileTest extends Specification {

    def static resourcesPath = "src/test/resources/"
    def static validFile = "sucesso.txt"
    def static invalidFile = "invalido.txt"

    private final ValidateFileFormat validateFileFormat = Mock()
    private ExtractTransacaoFile extractTransacaoFile = new ExtractTransacaoFile(validateFileFormat)

    def "Cria lista de transacoes a partir de um arquivo valido"() {
        given: "dado um arquivo txt válido"
        def file = createMockMultipartFile(validFile)

        and: "não há exception"
        1 * validateFileFormat.execute(_) >> {}

        when: "chamar o extrator"
        List<Transacao> transacaoList = extractTransacaoFile.execute(file)

        then: "deve retornar a lista de transações corretamente"
        transacaoList.size() == 1
        transacaoList[0].tipoTransacao == TipoTransacao.FINANCIAMENTO
        transacaoList[0].data == "20190301"
        transacaoList[0].valor == 14200
        transacaoList[0].cpf == "09620676017"
        transacaoList[0].cartao == "4753****3153"
        transacaoList[0].hora == "153453"
        transacaoList[0].loja.nome == "BAR DO JOÃO"
        transacaoList[0].loja.dono == "JOÃO MACEDO"
    }

    def "Cria lista de transacoes a partir de um arquivo invalido"() {
        given: "dado um arquivo txt inválido"
        def file = createMockMultipartFile(invalidFile)

        and: "não há exception"
        1 * validateFileFormat.execute(_) >> {}

        when: "chamar o extrator"
        extractTransacaoFile.execute(file)

        then: "deve retornar exception"
        def e = thrown(Exception)
        e.message == "Arquivo inválido!"
    }

    private createMockMultipartFile(String fileName) {
        new MockMultipartFile("file", "${fileName}", "text/plain", new File("${resourcesPath}${fileName}").getBytes())
    }

}
