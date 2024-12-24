package br.com.jira.adapters.out.repositories;

import br.com.jira.domain.model.Atividade;

import java.util.Optional;

public interface AtividadeRepository {

    Atividade salvar(Atividade atividade);
    Optional<Atividade> buscarPorId(Long id);
}
