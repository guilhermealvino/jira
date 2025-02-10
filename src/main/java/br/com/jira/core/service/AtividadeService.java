package br.com.jira.core.service;

import br.com.jira.adapters.input.rest.AtividadeDTO;
import br.com.jira.commons.StatusAtividade;
import br.com.jira.core.business.Atividade;
import br.com.jira.domain.AtividadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class AtividadeService {

    @Autowired
    private AtividadeRepository atividadeRepository;

    public Atividade criarAtividade(AtividadeDTO atividadeDTO) {
        Atividade atividade = new Atividade(
                atividadeDTO.getNome(),
                atividadeDTO.getDescricao(),
                atividadeDTO.getStatus()
        );
        return atividadeRepository.salvar(atividade);
    }

    public Atividade iniciarAtividade(Long id) {
        Atividade atividade = atividadeRepository.buscarPorId(id)
                .orElseThrow(() -> new IllegalArgumentException("Atividade não encontrada."));
        atividade.iniciar();
        return atividadeRepository.salvar(atividade);
    }

    public Atividade adicionarHoras(Long id, int minutos, String comentario) {
        Atividade atividade = atividadeRepository.buscarPorId(id)
                .orElseThrow(() -> new IllegalArgumentException("Atividade nao encontrada"));
        atividade.adicionarHoras(minutos, comentario);
        return atividadeRepository.salvar(atividade);
    }

    public Atividade finalizarAtividade(Long id) {
        Atividade atividade = atividadeRepository.buscarPorId(id)
                .orElseThrow(() -> new IllegalArgumentException("Atividade nao encontrada."));
        atividade.finalizar();
        return atividadeRepository.salvar(atividade);
    }

    public List<Atividade> buscarRelatoriosPorDia(LocalDate dia) {
        return atividadeRepository.buscarFinalizadasPorPeriodo(dia);
    }
}