package br.com.adev.apptarefas.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.adev.apptarefas.model.Tarefa;
import br.com.adev.apptarefas.repository.TarefaRepository;

@RestController
@RequestMapping("/tarefas")
public class ApiTarefaController {

    @Autowired
    private TarefaRepository tarefaRepository;

    @GetMapping("/")
    public List<Tarefa> list(){
        return this.tarefaRepository.findAll();
    }
    @PostMapping("/nova")
    public Tarefa tarefa(@RequestBody Tarefa tarefa){
        return this.tarefaRepository.save(tarefa);
    }

}
