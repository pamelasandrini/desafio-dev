package br.com.desafio.transacao.outlayer.gateway.repository.sqlserver;

import br.com.desafio.transacao.outlayer.gateway.repository.entities.TransacaoEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransacaoRepository extends CrudRepository<TransacaoEntity, Integer> {

    List<TransacaoEntity> findByIdLoja(Integer idLoja);
}
