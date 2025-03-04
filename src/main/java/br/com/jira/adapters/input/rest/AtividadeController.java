package br.com.jira.adapters.input.rest;

import br.com.jira.core.business.Atividade;
import br.com.jira.core.service.AtividadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/atividades")
public class AtividadeController {

    private final AtividadeService atividadeService;

    @Autowired
    public AtividadeController(AtividadeService atividadeService) {
        this.atividadeService = atividadeService;
    }

    @PostMapping
    public ResponseEntity<String> criarAtividade(@RequestBody AtividadeDTO atividadeDTO) {
        atividadeService.criarAtividade(atividadeDTO);
        return ResponseEntity.ok("Atividade criada com sucesso");
    }

    @GetMapping("/relatorios")
    public List<Atividade> buscarPorDia(@RequestParam String data) {
        LocalDate dia = LocalDate.parse(data);
        return atividadeService.buscarRelatoriosPorDia(dia);
    }
}