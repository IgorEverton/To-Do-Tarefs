package br.com.fiap.todotarefs.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.todotarefs.models.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long>{

}
