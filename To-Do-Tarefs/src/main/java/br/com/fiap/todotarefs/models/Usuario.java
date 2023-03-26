package br.com.fiap.todotarefs.models;
import java.time.LocalDate;

public class Usuario {
    private Long id;
    private String nm_usuario;
    private LocalDate dt_nascimento;
    private String ds_email;
    private String nr_telefone;
    private boolean st_conta;

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return super.toString();
    }
    public Usuario(){
        
    }

    public Usuario(Long id, String nm_usuario, LocalDate dt_nascimento, String ds_email, String nr_telefone,
            boolean st_conta) {
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
