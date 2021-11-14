package br.com.desafio.transacao.outlayer.gateway.repository.entities

import br.com.desafio.transacao.entities.Loja
import br.com.six2six.fixturefactory.Fixture
import br.com.six2six.fixturefactory.Rule
import br.com.six2six.fixturefactory.loader.TemplateLoader

class LojaTemplate implements TemplateLoader {

    public static final String LOJA_1 = "loja 1"

    @Override
    void load() {
        Fixture.of(Loja.class).addTemplate(LOJA_1, new Rule() {
            {
                add("dono", "José")
                add("nome", "Padaria do Zé")
            }
        })
    }
}
