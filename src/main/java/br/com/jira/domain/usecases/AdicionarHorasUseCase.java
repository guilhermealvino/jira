package br.com.jira.domain.usecases;

import br.com.jira.adapters.out.repositories.AtividadeRepository;

public class AdicionarHorasUseCase {

    private final AtividadeRepository atividadeRepository;

    public AdicionarHorasUseCase(AtividadeRepository atividadeRepository) {
        this.atividadeRepository = atividadeRepository;
    }
}
