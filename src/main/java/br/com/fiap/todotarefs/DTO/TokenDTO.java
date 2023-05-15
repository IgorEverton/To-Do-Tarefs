package br.com.fiap.todotarefs.DTO;

import br.com.fiap.todotarefs.models.Usuario;

public record TokenDTO(
        String token
) {
    public TokenDTO(String token){
        this.token=token;
    }
}
