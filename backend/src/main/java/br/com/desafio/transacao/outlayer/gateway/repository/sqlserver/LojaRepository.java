package br.com.desafio.transacao.outlayer.gateway.repository.sqlserver;

import br.com.desafio.transacao.outlayer.gateway.repository.entities.LojaEntity;
import org.springframework.data.repository.CrudRepository;

public interface LojaRepository extends CrudRepository<LojaEntity, Integer> {
}
