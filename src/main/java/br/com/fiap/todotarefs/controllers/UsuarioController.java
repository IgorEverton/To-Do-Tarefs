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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.todotarefs.models.Usuario;

import org.springframework.web.bind.annotation.RequestBody;


public class UsuarioController {

    Logger log = LoggerFactory.getLogger(UsuarioController.class);

    List<Usuario> usuarios = new ArrayList<>();

    @GetMapping("/api/usuarios")
    public List<Usuario> index(){
    
          return usuarios;
    }
    @PostMapping("/api/usuarios")
    public ResponseEntity<Usuario> create(@RequestBody Usuario usuario){
        log.info("Cadastrando Usuário"+usuario);
        usuario.setId(usuarios.size()+1l);
        usuarios.add(usuario);

        return ResponseEntity.status(HttpStatus.CREATED).body(usuario);
    }
    
    @GetMapping("/api/usuarios/{id}")
    public ResponseEntity<Usuario> show(@PathVariable Long id){
        log.info("Buscando usuário com ID"+id);
        var usuarioEncontrado = usuarios.stream().filter(u -> u.getId().equals(id)).findFirst();

        if(usuarioEncontrado.isEmpty())
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        return ResponseEntity.ok(usuarioEncontrado.get());
    }

    @DeleteMapping("/api/usuarios/{id}")
    public ResponseEntity<Usuario> destroy(@PathVariable Long id){
        log.info("Deletando usuário com ID"+id);
        var usuarioEncontrado = usuarios.stream().filter(u -> u.getId().equals(id)).findFirst();

        if(usuarioEncontrado.isEmpty())
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

        usuarios.remove(usuarioEncontrado.get());

        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PutMapping("/api/usuarios/{id}")
    public ResponseEntity<Usuario> update(@PathVariable Long id, @RequestBody Usuario usuario){
        log.info("Alterando usuário com ID"+id);
        var usuarioEncontrado = usuarios.stream().filter(u -> u.getId().equals(id)).findFirst();

        if(usuarioEncontrado.isEmpty())
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

        usuarios.remove(usuarioEncontrado.get());
        usuario.setId(id);
        usuarios.add(usuario);

        return ResponseEntity.ok(usuario);
    }
}
