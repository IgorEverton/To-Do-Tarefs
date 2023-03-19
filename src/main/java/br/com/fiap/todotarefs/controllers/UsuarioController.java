package br.com.fiap.todotarefs.controllers;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
import br.com.fiap.todotarefs.controllers.models.Usuario;


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
        
    }
}
