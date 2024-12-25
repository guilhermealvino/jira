package br.com.jira.adapters.output.postgres;

import br.com.jira.core.business.Atividade;
import br.com.jira.core.port.output.AtividadeRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public class AtividadeRepositoryPostgresAdapter implements AtividadeRepository {

    private final AtividadeRepositoryPostgresAdapter repositoryPostgres;

    public AtividadeRepositoryPostgresAdapter(AtividadeRepositoryPostgresAdapter repositoryPostgres) {
        this.repositoryPostgres = repositoryPostgres;
    }

    @Override
    public List<Atividade> buscarFinalizadasPorDia(LocalDate dia) {
        LocalDateTime inicio = dia.atStartOfDay();
        LocalDateTime fim = dia.plusDays(1).atStartOfDay().minusNanos(1);
        return repositoryPostgres.buscarFinalizadasPorDia(inicio, fim);
    }

    @Override
    public List<Atividade> buscarFinalizadasPorDia(LocalDateTime inicio, LocalDateTime fim) {
        return List.of();
    }
}
