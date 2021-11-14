package br.com.desafio.transacao.outlayer.gateway.repository


import br.com.desafio.transacao.outlayer.gateway.repository.entities.LojaEntity
import br.com.six2six.fixturefactory.Fixture
import br.com.six2six.fixturefactory.Rule
import br.com.six2six.fixturefactory.loader.TemplateLoader

class LojaEntityTemplate implements TemplateLoader {

    public static final String LOJA_1 = "loja 1"

    @Override
    void load() {
        Fixture.of(LojaEntity.class).addTemplate(LOJA_1, new Rule() {
            {
                add("dono", "José")
                add("nome", "Padaria do Zé")
                add("id", 12)
            }
        })
    }
}
