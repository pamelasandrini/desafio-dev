package br.com.desafio.transacao.outlayer.entrypoints;


import br.com.desafio.transacao.entities.Loja;
import br.com.desafio.transacao.entities.Saldo;
import br.com.desafio.transacao.outlayer.gateway.repository.LojaGateway;
import br.com.desafio.transacao.usecases.ObterSaldoEmConta;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/lojas")
public class LojaController {

    private final LojaGateway lojaGateway;
    private final ObterSaldoEmConta obterSaldoEmConta;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Loja> getLojas() {

        return lojaGateway.getLojas();
    }

    @GetMapping("/{id}/saldo")
    @ResponseStatus(HttpStatus.OK)
    public Saldo getTransacoesByLoja(@RequestParam final int lojaId) {

        return obterSaldoEmConta.execute(lojaId);
    }
}
