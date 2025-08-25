package br.com.sysacademia.controller;

import br.com.sysacademia.model.Aluno;
import br.com.sysacademia.model.AvaliacaoFisica;
import br.com.sysacademia.model.Instrutor;
import br.com.sysacademia.service.AlunoService;
import br.com.sysacademia.service.AvaliacaoFisicaService;
import br.com.sysacademia.service.InstrutorService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Optional;

@Controller
@RequestMapping("/instrutores")
public class InstrutorController {

    private final InstrutorService instrutorService;
    private final AlunoService alunoService;
    private final AvaliacaoFisicaService avaliacaoFisicaService;

    public InstrutorController(InstrutorService instrutorService, AlunoService alunoService, AvaliacaoFisicaService avaliacaoFisicaService) {
        this.instrutorService = instrutorService;
        this.alunoService = alunoService;
        this.avaliacaoFisicaService = avaliacaoFisicaService;
    }

    @GetMapping("/painel")
    public String painelInstrutor(Model model) {
        Optional<Instrutor> instrutorOpt = instrutorService.buscarPorId(1L);

        Instrutor instrutor = instrutorOpt.orElse(new Instrutor("Instrutor Padrão", "", "", ""));
        model.addAttribute("instrutor", instrutor);

        model.addAttribute("alunos", alunoService.listarAlunos());
    
        return "instrutor/painel";
    }

    @GetMapping("/gerenciar-aluno/{alunoId}")
    public String gerenciarAluno(@PathVariable Long alunoId, Model model) {
        alunoService.buscarPorId(alunoId).ifPresent(aluno -> {
            model.addAttribute("aluno", aluno);
        });
        return "instrutor/gerenciar-aluno";
    }

    @GetMapping("/gerenciar-aluno/{alunoId}/nova-avaliacao")
    public String novaAvaliacaoForm(@PathVariable Long alunoId, Model model) {
        model.addAttribute("avaliacao", new AvaliacaoFisica());
        model.addAttribute("alunoId", alunoId);
        return "instrutor/form-avaliacao";
    }

    @PostMapping("/gerenciar-aluno/{alunoId}/salvar-avaliacao")
    public String salvarAvaliacao(@PathVariable Long alunoId, @ModelAttribute AvaliacaoFisica avaliacao) {
        alunoService.buscarPorId(alunoId).ifPresent(aluno -> {
            avaliacao.setAluno(aluno);
            avaliacao.setData(LocalDate.now());
            avaliacaoFisicaService.salvar(avaliacao);
        });
        return "redirect:/instrutores/gerenciar-aluno/" + alunoId;
    }
    
    @GetMapping("/novo")
    public String novoInstrutorForm(Model model) {
        model.addAttribute("instrutor", new Instrutor());
        return "cadastro-instrutor";
    }

    @PostMapping("/salvar")
    public String salvarInstrutor(@ModelAttribute Instrutor instrutor) {
        instrutorService.salvar(instrutor);
        return "redirect:/login.html";
    }
}