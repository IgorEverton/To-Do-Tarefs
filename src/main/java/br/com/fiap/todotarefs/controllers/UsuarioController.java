package br.com.fiap.todotarefs.controllers;


import java.util.ArrayList;
import java.util.List;

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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import br.com.fiap.todotarefs.exception.RestNotFoundException;
import br.com.fiap.todotarefs.models.Usuario;
import br.com.fiap.todotarefs.repository.UsuarioRepository;
import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.RequestBody;

@RequestMapping("/api/usuarios")
@RestController
public class UsuarioController {

    Logger log = LoggerFactory.getLogger(UsuarioController.class);

    List<Usuario> usuarios = new ArrayList<>();

    @Autowired//injeção de dependencias
    UsuarioRepository usuarioRepository;

    @GetMapping
    public List<Usuario> index(){
        return usuarioRepository.findAll();
    }
    @PostMapping("/api/usuarios")
    public ResponseEntity<Object> create(@RequestBody @Valid Usuario usuario, BindingResult result){
        log.info("Cadastrando Usuário"+usuario);
        usuarios.add(usuario);

        return ResponseEntity.status(HttpStatus.CREATED).body(usuario);
    }
    
    @GetMapping("{id}")
    public ResponseEntity<Object> show(@PathVariable Long id){
        log.info("Buscando usuário com ID"+id);
        var usuario = usuarioRepository.findById(id).orElseThrow(() -> new RestNotFoundException("Usuario não encontrada"));
        return ResponseEntity.ok(usuario);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Usuario> destroy(@PathVariable Long id){
        log.info("apagando Usuario com id " + id);
        usuarioRepository.delete(getConta(id));
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/api/usuarios/{id}")
    public ResponseEntity<Usuario> update(@PathVariable Long id, @RequestBody @Valid Usuario usuario){
        log.info("alterando conta com id " + id);
        getConta(id);
        usuario.setId(id);
        usuarioRepository.save(usuario);
        return ResponseEntity.ok(usuario);
    }
    private Usuario getConta(Long id) {
        return usuarioRepository.findById(id)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuário não encontrado"));
}
}
