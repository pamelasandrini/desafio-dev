package br.com.desafio.transacao.outlayer.entrypoints;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/trasacoes")
public class TransacaoController {

    @PostMapping("/upload")
    @ResponseStatus(HttpStatus.CREATED)
    public void uploadTransacoes(@RequestParam("file") final MultipartFile file) {

    }
}
