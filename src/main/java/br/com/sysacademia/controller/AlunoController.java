package br.com.sysacademia.controller;

import br.com.sysacademia.model.Aluno;
import br.com.sysacademia.service.AlunoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/alunos")
public class AlunoController {

    private final AlunoService service;
    public AlunoController(AlunoService service) {
        this.service = service;
    }
    
    @GetMapping("/novo")
    public String novoAlunoForm(Model model) {
        model.addAttribute("aluno", new Aluno());   
        return "cadastro-aluno"; 
    }
    
    @PostMapping("/salvar")
    public String salvarAluno(@ModelAttribute Aluno aluno) {
        service.salvarAluno(aluno);
        return "redirect:/sucesso.html";
    }
    @GetMapping
    public String listarAlunos(Model model) {
        model.addAttribute("alunos", service.listarAlunos());
        return "alunos/lista";
    }
}