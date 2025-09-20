package br.com.sysacademia.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.sysacademia.model.Aluno;
import br.com.sysacademia.service.AlunoService;

import java.util.List;


@Controller
@RequestMapping("/recepcionista")
public class RecepcionistaController {
    private final AlunoService alunoService;

    public RecepcionistaController(AlunoService alunoService){
        this.alunoService = alunoService;
    }

    @GetMapping("/painel")
    public String painelRecepcionista() {
        return "recepcionista/painel";
    }
    
    @GetMapping("/alunos")
    public String listarAlunos(Model model, @RequestParam(name = "q", required = false) String query) {
        List<Aluno> alunos;
        if (query != null && !query.isEmpty()) {
            alunos = alunoService.buscarPorNome(query);
        } else {
            alunos = alunoService.listarAlunos();
        }
        model.addAttribute("alunos", alunos);
        model.addAttribute("termoBusca", query);
        return "recepcionista/lista-alunos";
    }
    
}
