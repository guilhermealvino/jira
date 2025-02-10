package br.com.jira.adapters.output.mongo;

import br.com.jira.core.business.Atividade;
import br.com.jira.core.port.output.AtividadeRepository;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Component
public class AtividadeRepositoryMongoAdapter implements AtividadeRepository {

    private final AtividadeRepositoryMongo repositoryMongo;

    public AtividadeRepositoryMongoAdapter(AtividadeRepositoryMongo repositoryMongo) {
        this.repositoryMongo = repositoryMongo;
    }

    @Override
    public Atividade salvar(Atividade atividade) {
        return null;
    }

    @Override
    public Optional<Atividade> buscarPorId(Long id) {
        return Optional.empty();
    }

    @Override
    public List<Atividade> buscarFinalizadasPorPeriodo(LocalDate dia) {
        return List.of();
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
