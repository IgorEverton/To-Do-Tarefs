package br.com.fiap.todotarefs.models;
import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name="tdt_usuario")
public class Usuario {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nm_usuario;
    private LocalDate dt_nascimento;
    private String ds_email;
    private String nr_telefone;
    private boolean st_conta;
    
    
    public Usuario() {
		// TODO Auto-generated constructor stub
	}
    
    
    
	public Usuario(Long id, String nm_usuario, LocalDate dt_nascimento, String ds_email, String nr_telefone,
			boolean st_conta) {
		super();
		this.id = id;
		this.nm_usuario = nm_usuario;
		this.dt_nascimento = dt_nascimento;
		this.ds_email = ds_email;
		this.nr_telefone = nr_telefone;
		this.st_conta = st_conta;
	}



	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNm_usuario() {
		return nm_usuario;
	}
	public void setNm_usuario(String nm_usuario) {
		this.nm_usuario = nm_usuario;
	}
	public LocalDate getDt_nascimento() {
		return dt_nascimento;
	}
	public void setDt_nascimento(LocalDate dt_nascimento) {
		this.dt_nascimento = dt_nascimento;
	}
	public String getDs_email() {
		return ds_email;
	}
	public void setDs_email(String ds_email) {
		this.ds_email = ds_email;
	}
	public String getNr_telefone() {
		return nr_telefone;
	}
	public void setNr_telefone(String nr_telefone) {
		this.nr_telefone = nr_telefone;
	}
	public boolean isSt_conta() {
		return st_conta;
	}
	public void setSt_conta(boolean st_conta) {
		this.st_conta = st_conta;
	}
    
    
    

}
