package br.com.desafio.transacao.entities;

public enum NaturezaTipoTransacao {

    ENTRADA("Entrada", "+"),
    SAIDA("Saída", "-");

    private final String natureza;
    private final String sinal;

    NaturezaTipoTransacao(final String natureza, final String sinal) {

        this.natureza = natureza;
        this.sinal = sinal;
    }

    public String getNatureza() {
        return natureza;
    }

    public String getSinal() {
        return sinal;
    }
}
