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
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})	
@Table(name="tdt_categoria")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of="id")
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
	

	
	public void atualizar(Categoria categoria) {
		if(categoria.descricao!=null) {
			this.descricao=categoria.descricao;
		}
	}
	
	public void excluir() {
		this.stts=false;
	}
	

}