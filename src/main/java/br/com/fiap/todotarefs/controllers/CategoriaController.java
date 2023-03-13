package br.com.fiap.todotarefs.controllers;

import java.time.LocalDate;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.todotarefs.controllers.models.Categoria;
import br.com.fiap.todotarefs.controllers.models.Tarefa;

public class CategoriaController {
    

    @GetMapping("/api/categorias")
    public Categoria show(){
        Tarefa tarefa_1 = new Tarefa
         ("treino perna", 
         1, 
         "treino de perna da semana 1 a 3", 
         LocalDate.now(), 
         0);
        Categoria categoria = new Categoria(1,
         "Categoria de tarefas de treinos semana 1 ao 3", 
         tarefa_1
         );
        return categoria;
    }
}
