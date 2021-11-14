package br.com.desafio.transacao.outlayer.entrypoints;


import br.com.desafio.transacao.entities.Loja;
import br.com.desafio.transacao.outlayer.gateway.repository.LojaGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/lojas")
public class LojaController {

    private final LojaGateway lojaGateway;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Loja> getLojas() {

        return lojaGateway.getLojas();
    }
}
