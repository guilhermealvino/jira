package br.com.jira.core.business;

import br.com.jira.commons.StatusAtividade;

import java.time.LocalDateTime;

public class Atividade {

    private Long id;
    private String nome;
    private LocalDateTime dataCriacao;
    private LocalDateTime dataInicio;
    private LocalDateTime dataFinalizacao;
    private String comentario;
    private int minutosTrabalhados;
    private StatusAtividade status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(LocalDateTime dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public LocalDateTime getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(LocalDateTime dataInicio) {
        this.dataInicio = dataInicio;
    }

    public LocalDateTime getDataFinalizacao() {
        return dataFinalizacao;
    }

    public void setDataFinalizacao(LocalDateTime dataFinalizacao) {
        this.dataFinalizacao = dataFinalizacao;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public int getMinutosTrabalhados() {
        return minutosTrabalhados;
    }

    public void setMinutosTrabalhados(int minutosTrabalhados) {
        this.minutosTrabalhados = minutosTrabalhados;
    }

    public StatusAtividade getStatus() {
        return status;
    }

    public void setStatus(StatusAtividade status) {
        this.status = status;
    }

    public Atividade(String nome) {
        this.nome = nome;
        this.dataCriacao = LocalDateTime.now();
        this.status = StatusAtividade.NAO_RELACIONADO;
    }

    public void iniciar() {
        if (status != StatusAtividade.NAO_RELACIONADO) {
            throw new IllegalStateException("A atividade já foi iniciada.");
        }
        this.status = StatusAtividade.PENDENTE;
        this.dataInicio = LocalDateTime.now();
    }

    public void adicionarHoras(int minutos, String comentario) {
        if (status != StatusAtividade.PENDENTE) {
            throw new IllegalStateException("Apenas atividades pendentes podem receber horas.");
        }
        if (minutos <= 0) {
            throw new IllegalArgumentException("Os minutos devem ser maiores que zero.");
        }
        this.minutosTrabalhados += minutos;
        this.comentario += "\n" + comentario;
    }

    public void finalizar() {
        if (status != StatusAtividade.PENDENTE) {
            throw new IllegalStateException("Apenas atividades pendentes podem ser finalizadas.");
        }
        this.status = StatusAtividade.FINALIZADA;
        this.dataFinalizacao = LocalDateTime.now();
    }

    public String getTempoTrabalhadoFormatado() {
        double horas = minutosTrabalhados / 60.0;
        return String.format("%.1fh", horas);
    }
}
