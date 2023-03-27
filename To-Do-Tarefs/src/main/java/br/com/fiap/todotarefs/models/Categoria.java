package br.com.fiap.todotarefs.models;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})	
@Table(name="tdt_categoria")
public class Categoria {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
	@Column(name="ds_categoria")
    private String descricao;
	@Column(name="st_categoria")
	private boolean stts;
	@JsonIgnore
	@OneToMany(mappedBy = "categoria")
	private List<Tarefa> tarefas = new ArrayList<>();
	
	public Categoria() {
		
	}
	
	public Categoria(Long id, String descricao, boolean stts) {
		super();
		this.id = id;
		this.descricao = descricao;
		this.stts = stts;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public boolean isStts() {
		return stts;
	}

	public void setStts(boolean stts) {
		this.stts = stts;
	}

	public List<Tarefa> getTarefas() {
		return tarefas;
	}

	public void setTarefas(List<Tarefa> tarefas) {
		this.tarefas = tarefas;
	}
	
	
	public void atualizar(Categoria categoria) {
		if(categoria.descricao!=null) {
			this.descricao=categoria.descricao;
		}
	}
	
	public void excluir() {
		this.stts=false;
	}
	

}
