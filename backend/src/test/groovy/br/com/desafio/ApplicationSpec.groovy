package br.com.desafio

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.ApplicationContext
import org.springframework.test.context.ContextConfiguration

@ContextConfiguration
class ApplicationSpec {

    @Autowired
    private ApplicationContext context

    def "test main"() {
        expect:
        context.active == true
    }

}
