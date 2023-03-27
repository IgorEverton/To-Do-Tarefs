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

import br.com.fiap.todotarefs.models.Categoria;
import br.com.fiap.todotarefs.repository.CategoriaRepository;
import jakarta.transaction.Transactional;

@RequestMapping("/api/categorias")
@RestController
public class CategoriaController {
	
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@PostMapping
	@Transactional
	public ResponseEntity cadastrar(@RequestBody Categoria categoria,UriComponentsBuilder uriBuilder){
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
