package br.com.jira.adapters.output.postgres;

import br.com.jira.core.business.Atividade;
import br.com.jira.core.port.output.AtividadeRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public class AtividadeRepositoryPostgresAdapter implements AtividadeRepository {

    private final AtividadeRepositoryPostgresAdapter repositoryPostgres;

    @Override
    public Atividade salvar(Atividade atividade) {
        // Implementação para salvar a atividade no banco de dados
        return null;
    }

    @Override
    public Optional<Atividade> buscarPorId(Long id) {
        // Implementação para buscar a atividade por ID no banco de dados
        return Optional.empty();
    }

    @Override
    public List<Atividade> buscarFinalizadasPorPeriodo(LocalDate dia) {
        // Implementação para buscar atividades finalizadas por período no banco de dados
        return List.of();
    }

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

    @Override
    public <S extends Atividade> S save(S entity) {
        return null;
    }

    @Override
    public <S extends Atividade> Iterable<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public Optional<Atividade> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Long aLong) {
        return false;
    }

    @Override
    public Iterable<Atividade> findAll() {
        return null;
    }

    @Override
    public Iterable<Atividade> findAllById(Iterable<Long> longs) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(Long aLong) {

    }

    @Override
    public void delete(Atividade entity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends Long> longs) {

    }

    @Override
    public void deleteAll(Iterable<? extends Atividade> entities) {

    }

    @Override
    public void deleteAll() {

    }
}
