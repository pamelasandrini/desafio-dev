package br.com.desafio.transacao.usecases;

import br.com.desafio.transacao.entities.Transacao;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UploadTransactionsOrchestrator {

    private final ExtractTransacaoFile extractTransacaoFile;

    public void execute(final MultipartFile file) {

        final List<Transacao> transacaoList = extractTransacaoFile.execute(file);

        //TODO: salva no banco

    }
}
