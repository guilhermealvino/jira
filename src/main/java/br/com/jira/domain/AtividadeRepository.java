package br.com.jira.domain;

import br.com.jira.core.business.Atividade;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;


public interface AtividadeRepository {
    Atividade salvar(Atividade atividade);
    Optional<Atividade> buscarPorId(Long Id);

    List<Atividade> buscarFinalizadasPorPeriodo(LocalDate dia);
}
