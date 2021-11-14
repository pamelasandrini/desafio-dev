package br.com.desafio.transacao.entities;

public enum TipoTransacao {

    DEBITO("Débito", 1, NaturezaTipoTransacao.ENTRADA),
    BOLETO("Boleto", 2, NaturezaTipoTransacao.SAIDA),
    FINANCIAMENTO("Financiamento", 3, NaturezaTipoTransacao.SAIDA),
    CREDITO("Crédito", 4, NaturezaTipoTransacao.ENTRADA),
    RECEBIMENTO_EMPRESTIMO("Recebimento Empréstimo", 5, NaturezaTipoTransacao.ENTRADA),
    VENDAS("Vendas", 6, NaturezaTipoTransacao.ENTRADA),
    RECEBIMENTO_TED("Recebimento TED", 7, NaturezaTipoTransacao.ENTRADA),
    RECEBIMENTO_DOC("Recebimento DOC", 8, NaturezaTipoTransacao.ENTRADA),
    ALUGUEL("Aluguel", 9, NaturezaTipoTransacao.SAIDA);

    private final String tipo;
    private final int codigo;
    private final NaturezaTipoTransacao naturezaTipoTransacao;

    TipoTransacao(final String tipo, final int codigo, final NaturezaTipoTransacao naturezaTipoTransacao) {

        this.tipo = tipo;
        this.codigo = codigo;
        this.naturezaTipoTransacao = naturezaTipoTransacao;
    }

    public String getTipo() {
        return tipo;
    }

    public int getCodigo() {
        return codigo;
    }

    public static TipoTransacao getTipoTransacaoByCodigo(final int codigo) {
        for (final TipoTransacao value : TipoTransacao.values()) {
            if (value.getCodigo() == codigo) {
                return value;
            }
        }
        throw new RuntimeException("Tipo de transação inválida!");
    }

    public NaturezaTipoTransacao getNaturezaTipoTransacao() {
        return naturezaTipoTransacao;
    }
}
