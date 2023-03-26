package br.com.fiap.todotarefs.models;


import java.time.LocalDateTime;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="tdt_tarefa")
public class Tarefa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name ="nm_tarefa")
    private String nome;
    @Column(name="ds_tarefa")
    private String descricao;
    @Column(name="dt_criacao")
    private LocalDateTime dataCriacao;
    @Column(name="dt_termino")
    private Date dataTermino;
    @Column(name="ds_favoritado")
    private boolean favoritado;
    @Column(name="st_categoria")
    private boolean stts;
    @ManyToOne(fetch = FetchType.LAZY)
    private Categoria categoria;
    
    
    public Tarefa() {
    	
    }
    
    
    
	public Tarefa(Long id, String nome, String descricao, LocalDateTime dataCriacao, Date dataTermino,
			boolean favoritado, boolean stts, Categoria categoria) {
		
		this.id = id;
		this.nome = nome;
		this.descricao = descricao;
		this.dataCriacao = dataCriacao;
		this.dataTermino = dataTermino;
		this.favoritado = favoritado;
		this.stts = stts;
		this.categoria = categoria;
	}



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
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public LocalDateTime getDataCriacao() {
		return dataCriacao;
	}
	public void setDataCriacao(LocalDateTime dataCriacao) {
		this.dataCriacao = dataCriacao;
	}
	public Date getDataTermino() {
		return dataTermino;
	}
	public void setDataTermino(Date dataTermino) {
		this.dataTermino = dataTermino;
	}
	public boolean isFavoritado() {
		return favoritado;
	}
	public void setFavoritado(boolean favoritado) {
		this.favoritado = favoritado;
	}
	public boolean isStts() {
		return stts;
	}
	public void setStts(boolean stts) {
		this.stts = stts;
	}
	public Categoria getCategoria() {
		return categoria;
	}
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
    
    



    

    
}
