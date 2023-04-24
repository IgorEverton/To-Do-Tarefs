package br.com.fiap.todotarefs.models;


import java.time.LocalDateTime;
import java.util.Date;

import org.springframework.data.domain.Pageable;
import org.springframework.hateoas.EntityModel;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import br.com.fiap.todotarefs.controllers.TarefaController;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
@Table(name="tdt_tarefa")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of="id")

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
    @ManyToOne()
    @JoinColumn(name="id_categoria")
    private Categoria categoria;
    
    

	public void atulizar(Tarefa tarefaDados) {
		if(tarefaDados.dataTermino!=null) {
				this.dataTermino=tarefaDados.dataTermino;
			
		}
		if(tarefaDados.descricao!=null) {
			this.descricao=tarefaDados.descricao;
		}
		if(tarefaDados.nome!=null) {
			this.nome=tarefaDados.nome;
		}
		
	}
	
	public void excluir() {
		this.stts=false;
	}
	
	public void favoritar() {
		this.favoritado=true;
	}
    public EntityModel<Tarefa> toModel(){
        return EntityModel.of(
        this,
        linkTo(methodOn(TarefaController.class).show(id)).withSelfRel(),
        linkTo(methodOn(TarefaController.class).destroy(id)).withRel("delete"),
        linkTo(methodOn(TarefaController.class).index(null, Pageable.unpaged())).withRel("all"));
    }
    
        
}