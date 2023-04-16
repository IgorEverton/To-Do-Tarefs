package br.com.fiap.todotarefs.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.todotarefs.models.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long>{

    Page<Categoria> findByDescricaoContaining(String descricao, Pageable pageable);

}