package br.com.desafio.transacao.outlayer.entrypoints;

import br.com.desafio.transacao.usecases.UploadTransactionsOrchestrator;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/transacoes")
public class TransacaoController {

    private final UploadTransactionsOrchestrator uploadTransactionsOrchestrator;

    @PostMapping("/upload")
    @ResponseStatus(HttpStatus.CREATED)
    public void uploadTransacoes(@RequestParam("file") final MultipartFile file) {
        uploadTransactionsOrchestrator.execute(file);
    }
}
