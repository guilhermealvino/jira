package br.com.jira.core.port.output;

import br.com.jira.core.business.Atividade;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public interface AtividadeRepository {

    List<Atividade> buscarFinalizadasPorDia(LocalDate dia);

    List<Atividade> buscarFinalizadasPorDia(LocalDateTime inicio, LocalDateTime fim);
}
