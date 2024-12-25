package br.com.jira.adapters.output.mongo;

import br.com.jira.core.business.Atividade;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface AtividadeRepositoryMongo extends MongoRepository<Atividade, String> {

    List<Atividade> findByStatusAndDataFinalizacaoBetween(String Status,
                                                          LocalDateTime inicio,
                                                          LocalDateTime fim);
}
