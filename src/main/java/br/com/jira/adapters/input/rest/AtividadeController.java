package br.com.jira.adapters.input.rest;

import br.com.jira.core.business.Atividade;
import br.com.jira.core.service.AtividadeService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping("/atividade")
public class AtividadeController {

    private final AtividadeService atividadeService;

    public AtividadeController(AtividadeService atividadeService) {
        this.atividadeService = atividadeService;
    }


    @PostMapping
    public Atividade criarAtividade(@RequestParam String nome){
        return atividadeService.criarAtividade(nome);
    }

    @PostMapping
    public Atividade iniciarAtividade(@PathVariable Long id){
        return atividadeService.iniciarAtividade(id);
    }

    @PostMapping("/{id}/iniciar")
    public Atividade adicionarHoras(@PathVariable Long id,
                                    @RequestParam int minutos,
                                    @RequestParam String comentario){
        return atividadeService.adicionarHoras(id, minutos, comentario);
    }

    @GetMapping("/relatorios")
    public List<Atividade> buscarPorDia(@RequestParam String data){
        LocalDate dia = LocalDate.parse(data);
        return atividadeService.buscarRelatoriosPorDia(dia);
    }
}
