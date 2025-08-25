package br.com.sysacademia.controller;

import br.com.sysacademia.model.Aluno;
import br.com.sysacademia.model.Plano;
import br.com.sysacademia.service.AlunoService;
import br.com.sysacademia.service.PlanoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;

@Controller
@RequestMapping("/alunos")
public class AlunoController {

    private final AlunoService service;
    private final PlanoService planoService;
    public AlunoController(AlunoService service, PlanoService planoService) {
        this.service = service;
        this.planoService = planoService;
    }
    
    @GetMapping("/novo")
    public String novoAlunoForm(Model model) {
        model.addAttribute("aluno", new Aluno());  
        model.addAttribute("todosOsPlanos", planoService.listarPlanos()); 
        return "aluno/cadastro-aluno"; 
    }
    
    @PostMapping("/salvar")
    public String salvarAluno(@ModelAttribute Aluno aluno) {
        service.salvarAluno(aluno);
        return "redirect:/sucesso";
    }
    @GetMapping
    public String listarAlunos(Model model) {
        model.addAttribute("alunos", service.listarAlunos());
        return "aluno/lista-alunos";
    }

    @GetMapping("/{id}")
    public String detalhesAluno(@PathVariable Long id, Model model) {
        service.buscarPorId(id).ifPresent(aluno -> {
            model.addAttribute("aluno", aluno);
        });
        return "aluno/detalhes-aluno";
    }
    
    @PostMapping("/{id}/deletar")
    public String deletarAluno(@PathVariable Long id) {
        service.deletarAluno(id);
        return "redirect:/instrutores/painel";
    }

    @GetMapping("/painel")
    public String painelAluno(Authentication authentication, Model model) {
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        String email = userDetails.getUsername();

        service.buscarPorEmail(email).ifPresent(aluno -> {
            model.addAttribute("aluno", aluno);
        });

        return "aluno/painel";
    }
}