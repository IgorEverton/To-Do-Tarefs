package br.com.fiap.todotarefs.controllers;

import java.time.LocalDate;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.todotarefs.controllers.models.Usuario;

public class UsuarioController {
    @GetMapping("/api/usuarios")
    public Usuario show(){
        Usuario user_1 = new Usuario(0, 
        "Genivlado",
        LocalDate.of(04, 17, 1995),
         "geni@gmail.com",
          "11-8002-8922", 
          true);

          return user_1;
    }
    
}
