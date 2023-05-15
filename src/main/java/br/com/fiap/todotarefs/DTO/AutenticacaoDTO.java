package br.com.fiap.todotarefs.DTO;

import br.com.fiap.todotarefs.models.Usuario;

public record AutenticacaoDTO(
        String email,
        String senha
) {
    public  AutenticacaoDTO(Usuario usuario){
        this(usuario.getUsername(),usuario.getPassword());
    }
}
