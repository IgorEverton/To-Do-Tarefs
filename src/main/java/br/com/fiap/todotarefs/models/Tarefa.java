package br.com.fiap.todotarefs.models;


import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Tarefa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private int categoria_id;
    private String descricao;
    private LocalDate data;
    

    protected Tarefa(){}

    public Tarefa(String titulo, int categoria_id, String descricao, LocalDate data, Long id) {
        this.titulo = titulo;
        this.categoria_id = categoria_id;
        this.descricao = descricao;
        this.data = data;
        this.id = id;
    }


    public String getTitulo() {
        return titulo;
    }


    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }


    public int getCategoria_id() {
        return categoria_id;
    }


    public void setCategoria_id(int categoria_id) {
        this.categoria_id = categoria_id;
    }


    public String getDescricao() {
        return descricao;
    }


    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }


    public LocalDate getData() {
        return data;
    }


    public void setData(LocalDate data) {
        this.data = data;
    }


    public Long getId() {
        return id;
    }


    public void setId(Long id) {
        this.id = id;
    }


    @Override
    public String toString() {
        return "Tarefa [titulo=" + titulo + ", categoria_id=" + categoria_id + ", descricao=" + descricao + ", data="
                + data + ", id=" + id + "]";
    }

    

    

    
}