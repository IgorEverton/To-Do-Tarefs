package br.com.fiap.todotarefs.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.fiap.todotarefs.models.Tarefa;
import br.com.fiap.todotarefs.repository.TarefaRepository;
import jakarta.transaction.Transactional;

@RequestMapping("/api/tarefas")
@RestController
public class TarefaController {
    
  @Autowired
  private TarefaRepository tarefaRepository;
  
  
  @PostMapping
  @Transactional
  public ResponseEntity adicionar(@RequestBody Tarefa tarefa,UriComponentsBuilder uriBuilder) {
	    tarefaRepository.save(tarefa);
		var uri=uriBuilder.path("/tarefa/{id}").buildAndExpand(tarefa.getId()).toUri();
		return ResponseEntity.created(uri).body(tarefa);
  }
  
  @GetMapping("/{id}")
  public ResponseEntity getTarefa(@PathVariable Long id) {
	  var tarefa=tarefaRepository.getReferenceById(id);
	  return ResponseEntity.ok(tarefa);
  }
  
  @PutMapping
  @Transactional
  public ResponseEntity atualizar(@RequestBody Tarefa tarefaDados) {
	  var tarefa = tarefaRepository.getReferenceById(tarefaDados.getId());
	  tarefa.atulizar(tarefaDados);
	  return ResponseEntity.ok(tarefa);
  }
  
  @DeleteMapping("/{id}")
  @Transactional
  public ResponseEntity excluir(@PathVariable Long id) {
	  var tarefa=tarefaRepository.getReferenceById(id);
	  tarefa.excluir();
	  return ResponseEntity.noContent().build();
  }
  
  

}