package br.com.fiap.todotarefs.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import br.com.fiap.todotarefs.models.Tarefa;

public interface TarefaRepository extends JpaRepository<Tarefa, Long>{
    Page<Tarefa> findByDescricaoContaining(String descricao, Pageable pageable);
}
