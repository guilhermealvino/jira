package br.com.jira.adapters.input.rest;

import br.com.jira.core.business.AtividadeMongoEntity;
import br.com.jira.core.service.AtividadeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping(path = "/atividades")
public class AtividadeController {

    private AtividadeService atividadeService;

    public AtividadeController(AtividadeService atividadeService) {
        this.atividadeService = atividadeService;
    }

    @PostMapping
    public String criarAtividade(@RequestBody CriarAtividadeRequest criarAtividadeRequest) {
        atividadeService.criarAtividade(criarAtividadeRequest);
        return "Atividade criada com sucesso";
    }

    @GetMapping(path = "/relatorios")
    public List<AtividadeMongoEntity> buscarPorDia(@RequestParam String data) {
        LocalDate dia = LocalDate.parse(data);
        return atividadeService.buscarRelatoriosPorDia(dia);
    }
}