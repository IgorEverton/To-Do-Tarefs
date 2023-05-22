package br.com.fiap.todotarefs.controllers;


import java.util.ArrayList;
import java.util.List;

import jakarta.transaction.Transactional;
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
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import br.com.fiap.todotarefs.exception.RestNotFoundException;
import br.com.fiap.todotarefs.models.Categoria;
import br.com.fiap.todotarefs.models.Tarefa;
import br.com.fiap.todotarefs.repository.CategoriaRepository;
import jakarta.validation.Valid;
import org.springframework.web.util.UriComponentsBuilder;


@RequestMapping("/api/categorias")
@RestController
public class CategoriaController {


    @Autowired
    private CategoriaRepository categoriaRepository;

    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody Categoria categoria, UriComponentsBuilder uriBuilder){
        categoriaRepository.save(categoria);
        var uri=uriBuilder.path("/categoria/{id}").buildAndExpand(categoria.getId()).toUri();
        return ResponseEntity.created(uri).body(categoria);
    }

    @GetMapping("/{id}")

    public ResponseEntity getCategoria(@PathVariable Long id){
        var categoria=categoriaRepository.getReferenceById(id);
        return ResponseEntity.ok(categoria);
    }


    @PutMapping
    @Transactional
    public ResponseEntity atualizar(@RequestBody Categoria categoriaDados) {
        var categoria=categoriaRepository.getReferenceById(categoriaDados.getId());
        categoria.atualizar(categoriaDados);
        return ResponseEntity.ok(categoria);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity excluir(@PathVariable Long id) {
        var categoria=categoriaRepository.getReferenceById(id);
        categoria.excluir();
        return ResponseEntity.noContent().build();
    }
}