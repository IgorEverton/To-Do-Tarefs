package br.com.fiap.todotarefs.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.todotarefs.models.Usuario;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    Page<Usuario> findByDescricaoContaining(String descricao, Pageable pageable);

    UserDetails findByEmail(String username);
}