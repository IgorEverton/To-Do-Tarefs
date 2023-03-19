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

import br.com.fiap.todotarefs.controllers.models.Tarefa;

@RestController
public class TarefaController {
    
    Logger log = LoggerFactory.getLogger(TarefaController.class);

    List<Tarefa> tarefas = new ArrayList<>();

    @GetMapping("/api/tarefas")
    public List<Tarefa> index(){
            

        return tarefas;
}

    @PostMapping("/api/tarefas")
    public ResponseEntity<Tarefa> create(@RequestBody Tarefa tarefa){
        log.info("Cadastrando tarefa" + tarefa);
        tarefa.setId(tarefas.size()+1l);
        tarefas.add(tarefa);

        return ResponseEntity.status(HttpStatus.CREATED).body(tarefa);
    }


   
    @GetMapping("/api/tarefas/{id}")
    public ResponseEntity<Tarefa> show(@PathVariable Long id){
        log.info("Buscando tarefa com id "+id);
        var tarefaEncontrada = tarefas.stream().filter(d-> d.getId().equals(id)).findFirst();
        
        if (tarefaEncontrada.isEmpty())
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

                
        
        
        return ResponseEntity.ok(tarefaEncontrada.get());
        
    }
    @DeleteMapping("/api/tarefas/{id}")
    public ResponseEntity<Tarefa> destroy(@PathVariable Long id){
        log.info("Deletando tarefa com id "+id);
        var tarefaEncontrada = tarefas.stream().filter(d-> d.getId().equals(id)).findFirst();
        
        if (tarefaEncontrada.isEmpty())
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

        tarefas.remove(tarefaEncontrada.get());
        
        
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();

}
    @PutMapping("/api/tarefas/{id}")
    public ResponseEntity<Tarefa> update(@PathVariable Long id, @RequestBody Tarefa tarefa){
        log.info("Alterando tarefa com id "+id);
        var tarefaEncontrada = tarefas.stream().filter(d-> d.getId().equals(id)).findFirst();
        
        if (tarefaEncontrada.isEmpty())
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

        tarefas.remove(tarefaEncontrada.get());
        tarefa.setId(id);
        tarefas.add(tarefa);
        
        
        return ResponseEntity.ok(tarefa);
}
}