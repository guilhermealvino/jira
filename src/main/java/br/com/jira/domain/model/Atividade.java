package br.com.jira.domain.model;

import br.com.jira.commons.enums.StatusAtividade;

import java.time.LocalDateTime;

public class Atividade {
    private Long id;
    private Long projetoId;
    private LocalDateTime dataInicio;
    private LocalDateTime dataFim;
    private String comentario;
    private StatusAtividade status;
    private int minutosTrabalhados;

    public Atividade(Long projetoId, String comentario) {
        this.projetoId = projetoId;
        this.dataInicio = LocalDateTime.now();
        this.status = status.PENDENTE;
        this.comentario = comentario;
        this.minutosTrabalhados = 0;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getProjetoId() {
        return projetoId;
    }

    public void setProjetoId(Long projetoId) {
        this.projetoId = projetoId;
    }

    public LocalDateTime getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(LocalDateTime dataInicio) {
        this.dataInicio = dataInicio;
    }

    public LocalDateTime getDataFim() {
        return dataFim;
    }

    public void setDataFim(LocalDateTime dataFim) {
        this.dataFim = dataFim;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public StatusAtividade getStatus() {
        return status;
    }

    public void setStatus(StatusAtividade status) {
        this.status = status;
    }

    public int getMinutosTrabalhados() {
        return minutosTrabalhados;
    }

    public void setMinutosTrabalhados(int minutosTrabalhados) {
        this.minutosTrabalhados = minutosTrabalhados;
    }
}
