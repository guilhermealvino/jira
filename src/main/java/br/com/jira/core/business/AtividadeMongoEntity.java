package br.com.jira.core.business;

import br.com.jira.commons.StatusAtividadeEnum;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document(collection = "meu_mongo")
public class AtividadeMongoEntity {

    @Id
    private ObjectId id;
    private String nome;
    private LocalDateTime dataCriacao;
    private LocalDateTime dataInicio;
    private LocalDateTime dataFinalizacao;
    private String comentario;
    private int minutosTrabalhados;
    private StatusAtividadeEnum status;

    public AtividadeMongoEntity(String nome, String comentario, StatusAtividadeEnum status) {
        this.nome=nome;
        this.comentario=comentario;
        this.status=status;
    }

    public AtividadeMongoEntity(){}

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
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

    public StatusAtividadeEnum getStatus() {
        return status;
    }

    public void setStatus(StatusAtividadeEnum status) {
        this.status = status;
    }

    public AtividadeMongoEntity(String nome) {
        this.nome = nome;
        this.dataCriacao = LocalDateTime.now();
        this.status = StatusAtividadeEnum.NAO_RELACIONADO;
    }

    public void iniciar() {
        if (status != StatusAtividadeEnum.NAO_RELACIONADO) {
            throw new IllegalStateException("A atividade já foi iniciada.");
        }
        this.status = StatusAtividadeEnum.PENDENTE;
        this.dataInicio = LocalDateTime.now();
    }

    public void adicionarHoras(int minutos, String comentario) {
        if (status != StatusAtividadeEnum.PENDENTE) {
            throw new IllegalStateException("Apenas atividades pendentes podem receber horas.");
        }
        if (minutos <= 0) {
            throw new IllegalArgumentException("Os minutos devem ser maiores que zero.");
        }
        this.minutosTrabalhados += minutos;
        this.comentario += "\n" + comentario;
    }

    public void finalizar() {
        if (status != StatusAtividadeEnum.PENDENTE) {
            throw new IllegalStateException("Apenas atividades pendentes podem ser finalizadas.");
        }
        this.status = StatusAtividadeEnum.FINALIZADA;
        this.dataFinalizacao = LocalDateTime.now();
    }

    public String getTempoTrabalhadoFormatado() {
        double horas = minutosTrabalhados / 60.0;
        return String.format("%.1fh", horas);
    }
}
