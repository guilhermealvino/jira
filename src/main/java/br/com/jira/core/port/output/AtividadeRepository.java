package br.com.jira.core.port.output;

import br.com.jira.core.business.Atividade;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface AtividadeRepository extends CrudRepository<Atividade, Long> {

    Atividade salvar(Atividade atividade);

    Optional<Atividade> buscarPorId(Long id);

    List<Atividade> buscarFinalizadasPorPeriodo(LocalDate dia);

    List<Atividade> buscarFinalizadasPorDia(LocalDate dia);

    List<Atividade> buscarFinalizadasPorDia(LocalDateTime inicio, LocalDateTime fim);
}
