package br.com.desafio.transacao.usecases;

import br.com.desafio.transacao.entities.Loja;
import br.com.desafio.transacao.entities.TipoTransacao;
import br.com.desafio.transacao.entities.Transacao;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.google.common.base.Charsets.UTF_8;

@Service
@RequiredArgsConstructor
public class ExtractTransacaoFile {

    private final ValidateFileFormat validateFileFormat;

    public Map<Loja, List<Transacao>> execute(final MultipartFile file) {
        validateFileFormat.execute(file);

        final Map<Loja, List<Transacao>> transacaoMap = new HashMap<>();

        try {
            final String lines = new String(file.getBytes(), UTF_8);

            for (final String line : lines.split("\n")) {
                final Loja loja = getLojaFromLine(line);
                final Transacao transacao = getTransacaoFromLine(line);

                if (transacaoMap.containsKey(loja)) {
                    transacaoMap.get(loja).add(transacao);
                } else {
                    final List<Transacao> transacaoList = new ArrayList<>();
                    transacaoList.add(transacao);
                    transacaoMap.put(loja, transacaoList);
                }
            }
        } catch (final Exception e) {
            throw new RuntimeException("Arquivo inválido!", e);
        }

        return transacaoMap;
    }

    private Transacao getTransacaoFromLine(final String line) {
        return Transacao.builder()
            .tipoTransacao(
                TipoTransacao.getTipoTransacaoByCodigo(
                    Integer.valueOf(getValue(line, 0, 1))
                )
            )
            .data(getValue(line, 1, 9))
            .valor(new BigDecimal(getValue(line, 9, 19)))
            .cpf(getValue(line, 19, 30))
            .cartao(getValue(line, 30, 42))
            .hora(getValue(line, 42, 48))
            .build();
    }

    private Loja getLojaFromLine(final String line) {
        return Loja.builder()
            .dono(getValue(line, 48, 62).trim())
            .nome(getValue(line, 62, line.length()).trim())
            .build();
    }

    private String getValue(final String line, final int initialPosion, final int finalPosition) {
        return line.substring(initialPosion, finalPosition);
    }
}
