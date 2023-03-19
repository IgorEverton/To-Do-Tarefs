package br.com.fiap.todotarefs.controllers;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.todotarefs.controllers.models.Categoria;
import br.com.fiap.todotarefs.controllers.models.Tarefa;


@RestController
public class CategoriaController {
    
    Logger log = LoggerFactory.getLogger(CategoriaController.class);

    List<Categoria> categorias = new ArrayList<>();


    @GetMapping("/api/categorias")
    public List<Categoria> index(){
        
        return categorias;
    }
    @PostMapping("/api/categorias")
    public ResponseEntity<Categoria> create(@RequestBody Categoria categoria){
        log.info("Cadastrando Categoria" + categoria);
        categoria.setId(categorias.size()+1l);
        categorias.add(categoria);

        return ResponseEntity.status(HttpStatus.CREATED).body(categoria);
    }

    @GetMapping("/api/categorias/{id}")
    public ResponseEntity<Categoria> show(@PathVariable Long id){
        log.info("Buscando categoria com ID"+id);
        var categoriaEncontrada = categorias.stream().filter(c -> c.getId().equals(id)).findFirst();

        if (categoriaEncontrada.isEmpty())
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();


        return ResponseEntity.ok(categoriaEncontrada.get());
    }

    @DeleteMapping("/api/categorias/{id}")
    public ResponseEntity<Categoria> destroy(@PathVariable Long id){
        log.info("Deletando categoria com ID"+id);
        var categoriaEncontrada = categorias.stream().filter(c -> c.getId().equals(id)).findFirst();

        if (categoriaEncontrada.isEmpty())
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            
        categorias.remove(categoriaEncontrada.get());

        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
    @PutMapping("/api/categorias/{id}")
    public ResponseEntity<Categoria> update(@PathVariable Long id, @RequestBody Categoria categoria){
        log.info("Alterando categoria com id "+ id);
        var categoriaEncontrada = categorias.stream().filter(c -> c.getId().equals(id)).findFirst();
        
        if(categoriaEncontrada.isEmpty())
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        
        categorias.remove(categoriaEncontrada.get());
        categoria.setId(id);
        categorias.add(categoria);


        return ResponseEntity.ok(categoria);
    }
}
