package br.com.desafio.transacao.usecases

import br.com.desafio.structural.CommonsConfig
import br.com.desafio.transacao.entities.Loja
import br.com.desafio.transacao.entities.TipoTransacao
import br.com.desafio.transacao.entities.Transacao
import spock.lang.Specification

class ExtractTransacaoFileTest extends Specification {

    def static validFile = "sucesso.txt"
    def static invalidFile = "invalido.txt"

    private final ValidateFileFormat validateFileFormat = Mock()
    private ExtractTransacaoFile extractTransacaoFile = new ExtractTransacaoFile(validateFileFormat)

    def "Cria lista de transacoes a partir de um arquivo valido"() {
        given: "dado um arquivo txt válido"
        def file = CommonsConfig.createMockMultipartFile(validFile)

        and: "não há exception"
        1 * validateFileFormat.execute(_) >> {}

        when: "chamar o extrator"
        Map<Loja, List<Transacao>> transacaoMap = extractTransacaoFile.execute(file)

        then: "deve retornar a lista de transações corretamente"
        transacaoMap.size() == 1
        transacaoMap.each { entry ->
            entry.key.nome == "BAR DO JOÃO"
            entry.key.dono == "JOÃO MACEDO"

            entry.value.size() == 1
            entry.value[0].tipoTransacao == TipoTransacao.FINANCIAMENTO
            entry.value[0].data == "20190301"
            entry.value[0].valor == 14200
            entry.value[0].cpf == "09620676017"
            entry.value[0].cartao == "4753****3153"
            entry.value[0].hora == "153453"
        }
    }

    def "Cria lista de transacoes a partir de um arquivo invalido"() {
        given: "dado um arquivo txt inválido"
        def file = CommonsConfig.createMockMultipartFile(invalidFile)

        and: "não há exception"
        1 * validateFileFormat.execute(_) >> {}

        when: "chamar o extrator"
        extractTransacaoFile.execute(file)

        then: "deve retornar exception"
        def e = thrown(Exception)
        e.message == "Arquivo inválido!"
    }

}
