package br.com.desafio.structural

import org.springframework.boot.test.context.TestConfiguration
import org.springframework.mock.web.MockMultipartFile
import spock.mock.DetachedMockFactory

@TestConfiguration
class CommonsConfig {
    def static resourcesPath = "src/test/resources/"
    
    public DetachedMockFactory factory = new DetachedMockFactory()

    static createMockMultipartFile(String fileName) {
        new MockMultipartFile("file", "${fileName}", "text/plain", new File("${resourcesPath}${fileName}").getBytes())
    }
}
