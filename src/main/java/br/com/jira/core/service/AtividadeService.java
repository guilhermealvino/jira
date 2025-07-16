package br.com.jira.core.service;

import br.com.jira.adapters.input.rest.CriarAtividadeRequest;
import br.com.jira.adapters.output.mongo.AtividadeMongoRepository;
import br.com.jira.core.business.AtividadeMongoEntity;
import br.com.jira.core.business.AtividadePostgresEntity;
import br.com.jira.core.port.output.repository.AtividadePostgresRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class AtividadeService {

    private final AtividadeMongoRepository atividadeMongoRepository;
    private final AtividadePostgresRepository atividadePostgresRepository;

    public AtividadeService(AtividadeMongoRepository atividadeMongoRepository, AtividadePostgresRepository atividadePostgresRepository) {
        this.atividadeMongoRepository = atividadeMongoRepository;
        this.atividadePostgresRepository = atividadePostgresRepository;
    }

    public AtividadeMongoEntity criarAtividade(CriarAtividadeRequest atividadeDTO) {
        AtividadeMongoEntity atividadeMongoEntity = new AtividadeMongoEntity(
                atividadeDTO.getNome(),
                atividadeDTO.getDescricao(),
                atividadeDTO.getStatus()
        );

        AtividadePostgresEntity atividadePostgresEntity = new AtividadePostgresEntity(
                atividadeDTO.getNome(),
                atividadeDTO.getDescricao(),
                atividadeDTO.getStatus()
        );

        atividadeMongoRepository.save(atividadeMongoEntity);
        atividadePostgresRepository.save(atividadePostgresEntity);
        return null;
    }

    public AtividadeMongoEntity iniciarAtividade(Long id) {

        return null;

//        Atividade atividade = atividadeRepository.buscarPorId(id)
//                .orElseThrow(() -> new IllegalArgumentException("Atividade não encontrada."));
//        atividade.iniciar();
//        return atividadeRepository.salvar(atividade);
    }

    public AtividadeMongoEntity adicionarHoras(Long id, int minutos, String comentario) {
//        Atividade atividade = atividadeRepository.buscarPorId(id)
//                .orElseThrow(() -> new IllegalArgumentException("Atividade nao encontrada"));
//        atividade.adicionarHoras(minutos, comentario);
//        return atividadeRepository.salvar(atividade);
        return null;
    }

    public AtividadeMongoEntity finalizarAtividade(Long id) {
        return null;
//        Atividade atividade = atividadeRepository.buscarPorId(id)
//                .orElseThrow(() -> new IllegalArgumentException("Atividade nao encontrada."));
//        atividade.finalizar();
//        return atividadeRepository.salvar(atividade);
    }

    public List<AtividadeMongoEntity> buscarRelatoriosPorDia(LocalDate dia) {
        return null;//atividadeRepository.buscarFinalizadasPorPeriodo(dia);
    }
}