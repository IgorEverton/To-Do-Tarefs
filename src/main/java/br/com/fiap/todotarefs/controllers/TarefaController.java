package br.com.fiap.todotarefs.controllers;

import java.util.ArrayList;
import java.util.List;
import org.springframework.hateoas.EntityModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import br.com.fiap.todotarefs.exception.RestNotFoundException;
import br.com.fiap.todotarefs.models.Tarefa;
import br.com.fiap.todotarefs.repository.TarefaRepository;
import br.com.fiap.todotarefs.repository.UsuarioRepository;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequestMapping("/api/tarefas")
@RestController
public class TarefaController {
    
    Logger log = LoggerFactory.getLogger(TarefaController.class);

    List<Tarefa> tarefas = new ArrayList<>();
    
    @Autowired
    TarefaRepository tarefaRepository;
    @Autowired
    UsuarioRepository usuarioRepository;


    @GetMapping
    public Page<EntityModel<Tarefa>> index(@RequestParam(required = false) String descricao, @PageableDefault(size = 5)Pageable pageable){
        Page<Tarefa> tarefas;
        tarefas=(descricao == null)?  tarefaRepository.findAll(pageable):
        tarefaRepository.findByDescricaoContaining(descricao, pageable);
        return tarefas.map((tarefa) -> 
        tarefa.toModel());
    }

    @PostMapping
    public ResponseEntity<EntityModel<Tarefa>> create(@RequestBody @Valid Tarefa tarefa, BindingResult result){
        log.info("cadastrando tarefa: " + tarefa);
        tarefaRepository.save(tarefa);
        return ResponseEntity.status(HttpStatus.CREATED).body(tarefa.toModel());
    }


   
    @GetMapping("{id}")
    public EntityModel<Tarefa> show(@PathVariable Long id){
        log.info("buscando tarefa com id " + id);
        var tarefa = tarefaRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.FORBIDDEN, "Tarefa não encontrada"));
        return tarefa.toModel();
        
    }
    @DeleteMapping("{id}")
    public ResponseEntity<Tarefa> destroy(@PathVariable Long id){
        log.info("Deletando tarefa com id "+id);
        var tarefa = tarefaRepository.findById(id).orElseThrow(() -> new RestNotFoundException("tarefa não encontrada"));
        

            tarefaRepository.delete(tarefa);
        
        
        return ResponseEntity.noContent().build();

}
    @PutMapping("{id}")
    public EntityModel<Tarefa> update(@PathVariable Long id, @RequestBody @Valid Tarefa tarefa){
        log.info("Alterando tarefa com id "+id);
        tarefaRepository.findById(id).orElseThrow(() -> new RestNotFoundException("tarefa não encontrada"));
        
        tarefa.setId(id);

        tarefaRepository.save(tarefa);

        return tarefa.toModel();
}
}