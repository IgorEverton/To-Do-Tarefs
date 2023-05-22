package br.com.fiap.todotarefs.DTO.usuario;

import br.com.fiap.todotarefs.models.Usuario;

import java.time.LocalDate;

public record RetornarUsuarioDTO(
        String nome,
        LocalDate dataNscimento,
        String email,
        String telefone,
        boolean ativo

) {
    public RetornarUsuarioDTO(Usuario usuario){
        this(usuario.getNome(),usuario.getDataNscimento(),usuario.getEmail(),usuario.getTelefone(),usuario.isAtivo());
    }
}
