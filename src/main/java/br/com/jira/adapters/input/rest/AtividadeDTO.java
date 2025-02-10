package br.com.jira.adapters.input.rest;

import br.com.jira.commons.StatusAtividade;
import br.com.jira.core.business.Atividade;
import br.com.jira.core.service.AtividadeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("atividades")
public class AtividadeDTO {

    private String nome;
    private String descricao;
    private StatusAtividade status;

    Atividade atividade = new Atividade("Nome da atividade");

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public StatusAtividade getStatus() {
        return status;
    }

    public void setStatus(StatusAtividade status) {
        this.status = status;
    }

    public AtividadeService getAtividadeService() {
        return atividadeService;
    }

    private final AtividadeService atividadeService;

    public AtividadeDTO(AtividadeService atividadeService){
        this.atividadeService = atividadeService;
    }


//    @PostMapping
//    public Atividade criarAtividade(@RequestParam String nome){
//        return atividadeService.criarAtividade(nome);
//    }

    @PostMapping
    public ResponseEntity<String> criarAtividade(@RequestBody AtividadeDTO atividadeDTO){
        atividadeService.criarAtividade(atividadeDTO);
        return ResponseEntity.ok("Atividade Criada com sucesso");
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


}
