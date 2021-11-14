package br.com.desafio.transacao.outlayer.gateway.repository.entities

import br.com.desafio.transacao.entities.TipoTransacao
import br.com.desafio.transacao.entities.Transacao
import br.com.six2six.fixturefactory.Fixture
import br.com.six2six.fixturefactory.Rule
import br.com.six2six.fixturefactory.loader.TemplateLoader

class TransacaoTemplate implements TemplateLoader {

    public static final String TRANSACAO_1 = "transacao 1"

    @Override
    void load() {
        Fixture.of(Transacao.class).addTemplate(TRANSACAO_1, new Rule() {
            {
                add("tipoTransacao", TipoTransacao.getTipoTransacaoByCodigo(1))
                add("data", "264")
                add("valor", new BigDecimal(120))
                add("cpf", "12345678910")
                add("cartao", "xpto264")
                add("hora", "001")
            }
        })
    }

}
