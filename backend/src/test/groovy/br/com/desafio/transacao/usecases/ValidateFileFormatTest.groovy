package br.com.desafio.transacao.usecases

import org.springframework.mock.web.MockMultipartFile
import org.springframework.web.multipart.MultipartFile
import spock.lang.Specification

class ValidateFileFormatTest extends Specification {

    private final ValidateFileFormat validateFileFormat = new ValidateFileFormat()

    def static resourcesPath = "src/test/resources/"
    def static validFile = "sucesso.txt"
    def static invalidFile = "invalido.csv"

    def "Processar arquivo formato valido"() {
        given: "Um arquivo para processamento"
        MultipartFile mockMultipartFile = createMockMultipartFile(validFile)

        when: "For requisitado a validação do formato do arquivo"
        validateFileFormat.execute(mockMultipartFile)

        then: "O formato do arquivo será verificado"
        notThrown(Exception)
    }

    def "Processar arquivo formato invalido"() {
        given: "Um arquivo para processamento"

        when: "For requisitado a validação do formato do arquivo"
        validateFileFormat.execute(mockMultipartFile)

        then: "O formato do arquivo será verificado e uma #expectedException será lançada"
        def ex = thrown(expectedException)

        and: "A exceção terá os parametros corretos"
        ex.message == message

        where:
        scenario                       | mockMultipartFile                    || expectedException | message
        "Arquivo com formato invalido" | createMockMultipartFile(invalidFile) || RuntimeException  | "Formato de arquivo inválido!"
        "Arquivo nulo"                 | null                                 || RuntimeException  | "file is marked non-null but is null"
    }

    private createMockMultipartFile(String fileName) {
        new MockMultipartFile("file", "${fileName}", "text/plain", new File("${resourcesPath}${fileName}").getBytes())
    }
}
