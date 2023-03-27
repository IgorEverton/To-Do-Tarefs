package br.com.fiap.todotarefs.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.todotarefs.models.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

}
