package br.com.fiap.todotarefs.DTO.usuario;

import java.time.LocalDate;

public record AtualizaUsuarioDTO(
        Long id,
        String nome,
        LocalDate dataNscimento,
        String email,
        String telefone,
        boolean ativo,
        String senha
) {
}
