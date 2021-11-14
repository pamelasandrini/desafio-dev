package br.com.desafio.transacao.outlayer.gateway.repository.sqlserver;

import br.com.desafio.transacao.outlayer.gateway.repository.entities.TransacaoEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransacaoRepository extends CrudRepository<TransacaoEntity, Integer> {

}
