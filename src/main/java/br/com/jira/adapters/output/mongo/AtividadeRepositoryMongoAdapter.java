package br.com.jira.adapters.output.mongo;

import br.com.jira.core.business.Atividade;
import br.com.jira.core.port.output.AtividadeRepository;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Component
public class AtividadeRepositoryMongoAdapter implements AtividadeRepository {

    private final AtividadeRepositoryMongo repositoryMongo;

    public AtividadeRepositoryMongoAdapter(AtividadeRepositoryMongo repositoryMongo) {
        this.repositoryMongo = repositoryMongo;
    }

    @Override
    public List<Atividade> buscarFinalizadasPorDia(LocalDate dia) {
        LocalDateTime inicio = dia.atStartOfDay();
        LocalDateTime fim = dia.plusDays(1).atStartOfDay().minusNanos(1);
        return repositoryMongo.findByStatusAndDataFinalizacaoBetween("FINALIZADA", inicio, fim);
    }

    @Override
    public List<Atividade> buscarFinalizadasPorDia(LocalDateTime inicio, LocalDateTime fim) {
        return List.of();
    }
}
