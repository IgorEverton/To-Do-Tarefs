package br.com.fiap.todotarefs.controllers;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
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

import br.com.fiap.todotarefs.models.Tarefa;
import br.com.fiap.todotarefs.repository.TarefaRepository;

@RequestMapping("/api/tarefas")
@RestController
public class TarefaController {
    
    Logger log = LoggerFactory.getLogger(TarefaController.class);

    List<Tarefa> tarefas = new ArrayList<>();
    
    @Autowired//injeção de dependencias
    TarefaRepository repository;

    @GetMapping
    public List<Tarefa> index(){
        return repository.findAll();
}

    @PostMapping
    public ResponseEntity<Tarefa> create(@RequestBody Tarefa tarefa){
        log.info("Cadastrando tarefa" + tarefa);

        repository.save(tarefa);

        return ResponseEntity.status(HttpStatus.CREATED).body(tarefa);
    }


   
    @GetMapping("{id}")
    public ResponseEntity<Tarefa> show(@PathVariable Long id){
        log.info("Buscando tarefa com id "+id);
        var tarefaEncontrada = repository.findById(id);
        
        if (tarefaEncontrada.isEmpty())
            return ResponseEntity.notFound().build();       
        return ResponseEntity.ok(tarefaEncontrada.get());
        
    }
    @DeleteMapping("{id}")
    public ResponseEntity<Tarefa> destroy(@PathVariable Long id){
        log.info("Deletando tarefa com id "+id);
        var tarefaEncontrada = repository.findById(id);
        
        if (tarefaEncontrada.isEmpty())
            return ResponseEntity.notFound().build();

        repository.delete(tarefaEncontrada.get());
        
        
        return ResponseEntity.noContent().build();

}
    @PutMapping("{id}")
    public ResponseEntity<Tarefa> update(@PathVariable Long id, @RequestBody Tarefa tarefa){
        log.info("Alterando tarefa com id "+id);
        var tarefaEncontrada = repository.findById(id);
        
        if (tarefaEncontrada.isEmpty())
            return ResponseEntity.notFound().build();
        
           
        tarefa.setId(id);

        repository.save(tarefa);

        return ResponseEntity.ok(tarefa);
}
}