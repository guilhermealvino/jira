package br.com.jira.domain.usecases;

import br.com.jira.adapters.out.repositories.AtividadeRepository;
import br.com.jira.domain.model.Atividade;

public class CriarAtividadeUseCase {

    private final AtividadeRepository repository;

    public CriarAtividadeUseCase(AtividadeRepository repository) {
        this.repository = repository;
    }

    public Atividade executar(Long projetoId, String comentario) {
        Atividade atividade = new Atividade(projetoId, comentario);
        return repository.salvar(atividade);
    }
}