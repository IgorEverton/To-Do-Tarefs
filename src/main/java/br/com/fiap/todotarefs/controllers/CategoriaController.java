package br.com.fiap.todotarefs.controllers;


import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import br.com.fiap.todotarefs.exception.RestNotFoundException;
import br.com.fiap.todotarefs.models.Categoria;
import br.com.fiap.todotarefs.models.Tarefa;
import br.com.fiap.todotarefs.repository.CategoriaRepository;
import jakarta.validation.Valid;



@RestController
public class CategoriaController {
    
    Logger log = LoggerFactory.getLogger(CategoriaController.class);

    List<Categoria> categorias = new ArrayList<>();

    @Autowired
    CategoriaRepository categoriaRepository;


    @GetMapping
    public Page<EntityModel<Categoria>> index(@RequestParam(required = false) String descricao, @PageableDefault(size = 5)Pageable pageable){
        Page<Categoria> categoria;
        categoria=(descricao == null)?  categoriaRepository.findAll(pageable):
        categoriaRepository.findByDescricaoContaining(descricao, pageable);
        return categoria.map((tarefa) -> 
        tarefa.toModel());
    }
    @PostMapping
    public ResponseEntity<Object> create(@RequestBody @Valid Categoria categoria, BindingResult result){
        log.info("cadastrando categoria: " + categoria);
        categoriaRepository.save(categoria);
        return ResponseEntity.status(HttpStatus.CREATED).body(categoria.toModel());
    }

    @GetMapping("{id}")
    public EntityModel<Categoria> show(@PathVariable Long id){
        log.info("buscando tarefa com id " + id);
        var categoria = categoriaRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.FORBIDDEN, "Tarefa não encontrada"));
        return categoria.toModel();
    }

    @DeleteMapping("/api/categorias/{id}")
    public ResponseEntity<Categoria> destroy(@PathVariable Long id){
        log.info("Deletando categoria com id "+id);
        var categoria = categoriaRepository.findById(id).orElseThrow(() -> new RestNotFoundException("tarefa não encontrada"));
        

        categoriaRepository.delete(categoria);
        
        
        return ResponseEntity.noContent().build();
    }
    @PutMapping("/api/categorias/{id}")
    public EntityModel<Categoria> update(@PathVariable Long id, @RequestBody Categoria categoria){
        log.info("Alterando tarefa com id "+id);
        categoriaRepository.findById(id).orElseThrow(() -> new RestNotFoundException("tarefa não encontrada"));
        
        categoria.setId(id);

        categoriaRepository.save(categoria);

        return categoria.toModel();
    }
}
