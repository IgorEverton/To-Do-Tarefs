package br.com.fiap.todotarefs.controllers;

import java.time.LocalDate;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.todotarefs.controllers.models.Tarefa;

@RestController
public class TarefaController {
    
    @GetMapping("/api/tarefas")
    public Tarefa show(){
            Tarefa tarefa = new Tarefa("Compra da semana", 
            1, 
            "Minhas compras semanais", 
            LocalDate.now(), 
            0);


        return tarefa;
}

}
