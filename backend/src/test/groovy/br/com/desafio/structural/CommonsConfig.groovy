package br.com.desafio.structural

import br.com.six2six.fixturefactory.Fixture
import br.com.six2six.fixturefactory.loader.FixtureFactoryLoader
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

    static setup() {
        FixtureFactoryLoader.loadTemplates("br.com.desafio")
    }

    static <T> T fixture(Class<T> clazz, String fixture) {
        setup()
        return Fixture.from(clazz).gimme(fixture)
    }
}
