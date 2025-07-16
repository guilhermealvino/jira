package br.com.jira.adapters.input.rest;

import br.com.jira.commons.StatusAtividadeEnum;
import br.com.jira.core.business.AtividadeMongoEntity;
import br.com.jira.core.service.AtividadeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;


public class CriarAtividadeRequest {

    private String nome;
    private String descricao;
    private StatusAtividadeEnum status;

    AtividadeMongoEntity atividadeMongoEntity = new AtividadeMongoEntity("Nome da atividade");

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

    public StatusAtividadeEnum getStatus() {
        return status;
    }

    public void setStatus(StatusAtividadeEnum status) {
        this.status = status;
    }

    public AtividadeService getAtividadeService() {
        return atividadeService;
    }

    private final AtividadeService atividadeService;

    public CriarAtividadeRequest(AtividadeService atividadeService) {
        this.atividadeService = atividadeService;
    }

    @PostMapping
    public ResponseEntity<String> criarAtividade(@RequestBody CriarAtividadeRequest atividadeDTO) {
        atividadeService.criarAtividade(atividadeDTO);
        return ResponseEntity.ok("Atividade Criada com sucesso");
    }

    @PostMapping
    public AtividadeMongoEntity iniciarAtividade(@PathVariable Long id) {
        return atividadeService.iniciarAtividade(id);
    }

    @PostMapping("/{id}/iniciar")
    public AtividadeMongoEntity adicionarHoras(@PathVariable Long id,
                                               @RequestParam int minutos,
                                               @RequestParam String comentario) {
        return atividadeService.adicionarHoras(id, minutos, comentario);
    }

}
