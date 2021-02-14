package br.com.adev.apptarefas.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.adev.apptarefas.model.Tarefa;
import br.com.adev.apptarefas.repository.TarefaRepository;

@Controller
public class TarefasController {
    
    @Autowired
    private TarefaRepository tr;

    @GetMapping("/hello")
    public String hello(){
        return "hello";
    }
    @RequestMapping("/")
    public ModelAndView listaTarefas(){
        ModelAndView mv = new ModelAndView("index");
        Iterable<Tarefa> tarefas = tr.findAll();
        mv.addObject("tarefas", tarefas);
        return mv;
    }

    @RequestMapping(value="/novaTarefa", method=RequestMethod.GET)
    public String form(){
        return "/formTarefa";
    }
    @RequestMapping(value="/novaTarefa", method=RequestMethod.POST)
    public String form(Tarefa tarefa){
        tr.save(tarefa);
        return "redirect:/";
    }
    @RequestMapping("/deletarTarefa")
    public String deletarTarefa(long id){
        Tarefa tarefa = tr.findById(id);
        tr.delete(tarefa);
        return "redirect:/";
    }
    @RequestMapping(value="/{id}", method=RequestMethod.GET)
    public ModelAndView detalhesTarefa(@PathVariable("id") long id){
        Tarefa tarefa = tr.findById(id);
        ModelAndView mv = new ModelAndView("/formTarefa");//("/detalhesTarefa");
        mv.addObject("tarefa", tarefa);
        return mv;
    }

    @RequestMapping(value="/{id}", method=RequestMethod.POST)
    public String detalhesTarefaPost(@PathVariable("id") long id, Tarefa tarefa, BindingResult result, RedirectAttributes attributes){
        tr.save(tarefa);
        return "redirect:/";
    }
}
