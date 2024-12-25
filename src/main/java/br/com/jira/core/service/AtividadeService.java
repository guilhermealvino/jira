package br.com.jira.core.service;

import br.com.jira.core.business.Atividade;
import br.com.jira.domain.AtividadeRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class AtividadeService {

    private final AtividadeRepository atividadeRepository;

    public AtividadeService(AtividadeRepository atividadeRepository) {
        this.atividadeRepository = atividadeRepository;
    }

    public Atividade criarAtividade(String nome){
        Atividade atividade = new Atividade(nome);
        return atividadeRepository.salvar(atividade);
    }

    public Atividade iniciarAtividade(Long id){
        Atividade atividade = atividadeRepository.buscarPorId(id)
                .orElseThrow(() -> new IllegalArgumentException("Atividade não encontrada."));
                atividade.iniciar();
                return atividadeRepository.salvar(atividade);
    }

    public Atividade adicionarHoras(Long id, int minutos, String comentario){
        Atividade atividade = atividadeRepository.buscarPorId(id)
                .orElseThrow(() -> new IllegalArgumentException("Atividade nao encontrada"));
                atividade.adicionarHoras(minutos, comentario);
                return atividadeRepository.salvar(atividade);
    }

    public Atividade finalizarAtividade(Long id){
        Atividade atividade = atividadeRepository.buscarPorId(id)
                .orElseThrow(() ->new IllegalArgumentException("Atividade nao encontrada."));
        atividade.finalizar();
        return atividadeRepository.salvar(atividade);
    }

    public List<Atividade> buscarRelatoriosPorDia(LocalDate dia){
        return atividadeRepository.buscarFinalizadasPorPeriodo(dia);
    }

}
