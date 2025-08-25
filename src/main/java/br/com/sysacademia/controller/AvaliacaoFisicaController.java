package br.com.sysacademia.controller;

import br.com.sysacademia.model.Aluno;
import br.com.sysacademia.model.AvaliacaoFisica;
import br.com.sysacademia.service.AlunoService;
import br.com.sysacademia.service.AvaliacaoFisicaService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/avaliacoes")
public class AvaliacaoFisicaController {

    private final AvaliacaoFisicaService avaliacaoFisicaService;
    private final AlunoService alunoService;

    public AvaliacaoFisicaController(AvaliacaoFisicaService avaliacaoFisicaService, AlunoService alunoService) {
        this.avaliacaoFisicaService = avaliacaoFisicaService;
        this.alunoService = alunoService;
    }

    @GetMapping("/novo")
    public String novaAvaliacaoForm(Model model) {
        model.addAttribute("avaliacao", new AvaliacaoFisica());
        model.addAttribute("alunos", alunoService.listarAlunos());
        return "nova-avaliacao";
    }

    @PostMapping("/salvar")
    public String salvarAvaliacao(@ModelAttribute AvaliacaoFisica avaliacao, @RequestParam("aluno.id") Long alunoId) {
        Optional<Aluno> alunoOptional = alunoService.buscarPorId(alunoId);
        if (alunoOptional.isPresent()) {
            avaliacao.setAluno(alunoOptional.get());
            avaliacaoFisicaService.salvar(avaliacao);
            return "redirect:/avaliacoes/visualizar/" + avaliacao.getId();
        } else {
            return "redirect:/instrutores/painel";
        }
    }

    @GetMapping("/visualizar/{id}")
    public String visualizarAvaliacao(@PathVariable Long id, Model model) {
        Optional<AvaliacaoFisica> avaliacaoOptional = avaliacaoFisicaService.buscarPorId(id);
        if (avaliacaoOptional.isPresent()) {
            model.addAttribute("avaliacao", avaliacaoOptional.get());
            return "visualizar-avaliacao";
        } else {
            return "redirect:/instrutores/painel";
        }
    }
}
