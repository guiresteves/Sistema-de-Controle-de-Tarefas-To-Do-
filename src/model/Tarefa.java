package model;

import java.time.LocalDate;

public class Tarefa {

    private final long id;
    private String titulo;
    private String descricao;
    private boolean concluido;
    private final LocalDate dataCriacao;

    public Tarefa(long id, String titulo, String descricao, boolean concluido, LocalDate dataCriacao) {
        this.id = id;
        this.titulo = titulo;
        this.descricao = descricao;
        this.concluido = concluido;
        this.dataCriacao = dataCriacao;
    }

    public long getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public boolean isConcluido() {
        return concluido;
    }

    public void setConcluido(boolean concluido) {
        this.concluido = concluido;
    }

    public LocalDate getDataCriacao() {
        return dataCriacao;
    }
}
