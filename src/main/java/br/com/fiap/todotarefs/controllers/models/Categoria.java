package br.com.fiap.todotarefs.controllers.models;

public class Categoria {
    private int id;
    private String ds_categoria;
    private Tarefa tarefa;

    
    public Categoria(){
        
    }

    public Categoria(int id, String ds_categoria, Tarefa tarefa) {
        this.id = id;
        this.ds_categoria = ds_categoria;
        this.tarefa = tarefa;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getDs_categoria() {
        return ds_categoria;
    }
    public void setDs_categoria(String ds_categoria) {
        this.ds_categoria = ds_categoria;
    }
    public Tarefa getTarefa() {
        return tarefa;
    }
    public void setTarefa(Tarefa tarefa) {
        this.tarefa = tarefa;
    }

    
}
