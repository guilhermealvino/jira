package br.com.jira.core.port.output.repository;

import br.com.jira.core.business.AtividadeMongoEntity;
import br.com.jira.core.business.AtividadePostgresEntity;
import br.com.jira.core.port.output.repository.custom.AtividadePostgresRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;


public interface AtividadePostgresRepository extends JpaRepository<AtividadePostgresEntity, Long>, AtividadePostgresRepositoryCustom {


//    List<AtividadeMongoEntity> buscarFinalizadasPorPeriodo(LocalDate dia);
//
//    List<AtividadeMongoEntity> buscarFinalizadasPorDia(LocalDate dia);
//
//    List<AtividadeMongoEntity> buscarFinalizadasPorDia(LocalDateTime inicio, LocalDateTime fim);
}
