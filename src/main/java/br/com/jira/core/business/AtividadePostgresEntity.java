package br.com.jira.core.business;

import br.com.jira.adapters.input.rest.dto.request.StatusAtividade;
import br.com.jira.commons.StatusAtividadeEnum;
import jakarta.persistence.*;

import java.sql.Date;


@Entity(name = "atividades")
public class AtividadePostgresEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_seq")
    @SequenceGenerator(name = "user_seq", sequenceName = "user_sequence", allocationSize = 1)
    private Long id;
    private String nome;
    private Date dataCriacao;
    private Date dataInicio;
    private Date dataFinalizacao;
    private String comentario;
    private Integer minutosTrabalhados;
    @Enumerated(EnumType.STRING)
    private StatusAtividadeEnum status;

    public AtividadePostgresEntity(String nome, String comentario, StatusAtividadeEnum status) {
        this.nome=nome;
        this.comentario=comentario;
        this.status=status;
    }

    public AtividadePostgresEntity(){}

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

    public Date getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(Date dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public Date getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(Date dataInicio) {
        this.dataInicio = dataInicio;
    }

    public Date getDataFinalizacao() {
        return dataFinalizacao;
    }

    public void setDataFinalizacao(Date dataFinalizacao) {
        this.dataFinalizacao = dataFinalizacao;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public Integer getMinutosTrabalhados() {
        return minutosTrabalhados;
    }

    public void setMinutosTrabalhados(Integer minutosTrabalhados) {
        this.minutosTrabalhados = minutosTrabalhados;
    }

    public StatusAtividadeEnum getStatus() {
        return status;
    }

    public void setStatus(StatusAtividadeEnum status) {
        this.status = status;
    }

    public AtividadePostgresEntity(String nome) {
        this.nome = nome;
        //this.dataCriacao = new ;
        this.status = StatusAtividadeEnum.NAO_RELACIONADO;
    }

    public void iniciar() {
//        if (status != StatusAtividade.NAO_RELACIONADO) {
//            throw new IllegalStateException("A atividade já foi iniciada.");
//        }
//        this.status = StatusAtividade.PENDENTE;
//        this.dataInicio = LocalDateTime.now();
    }

    public void adicionarHoras(int minutos, String comentario) {
//        if (status != StatusAtividade.PENDENTE) {
//            throw new IllegalStateException("Apenas atividades pendentes podem receber horas.");
//        }
//        if (minutos <= 0) {
//            throw new IllegalArgumentException("Os minutos devem ser maiores que zero.");
//        }
//        this.minutosTrabalhados += minutos;
//        this.comentario += "\n" + comentario;
    }

    public void finalizar() {
//        if (status != StatusAtividade.PENDENTE) {
//            throw new IllegalStateException("Apenas atividades pendentes podem ser finalizadas.");
//        }
//        this.status = StatusAtividade.FINALIZADA;
//        this.dataFinalizacao = LocalDateTime.now();
    }

    public String getTempoTrabalhadoFormatado() {
        double horas = minutosTrabalhados / 60.0;
        return String.format("%.1fh", horas);
    }
}
