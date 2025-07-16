package br.com.jira.adapters.output.mongo;


import br.com.jira.core.business.AtividadeMongoEntity;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface AtividadeMongoRepository extends MongoRepository<AtividadeMongoEntity, ObjectId> {
    List<AtividadeMongoEntity> findByStatusAndDataFinalizacaoBetween(String Status,
                                                                     LocalDateTime inicio,
                                                                     LocalDateTime fim);
}
