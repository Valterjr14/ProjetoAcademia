package br.com.sysacademia.controller;

import br.com.sysacademia.model.Exercicio;
import br.com.sysacademia.model.Treino;
import br.com.sysacademia.service.AlunoService;
import br.com.sysacademia.service.ExercicioService;
import br.com.sysacademia.service.TreinoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/treinos")
public class TreinoController {

    private final TreinoService treinoService;
    private final AlunoService alunoService;
    private final ExercicioService exercicioService;

    public TreinoController(TreinoService treinoService, AlunoService alunoService, ExercicioService exercicioService) {
        this.treinoService = treinoService;
        this.alunoService = alunoService;
        this.exercicioService = exercicioService;
    }

    @GetMapping
    public String listarTreinos(Model model) {
        model.addAttribute("treinos", treinoService.listarTodos());
        return "treino/lista-treinos";
    }

    @GetMapping("/novo/{alunoId}")
    public String novoTreinoForm(@PathVariable Long alunoId, Model model) {
        model.addAttribute("treino", new Treino());
        model.addAttribute("alunoId", alunoId);
        return "treino/form-treino";
    }

    @PostMapping("/salvar/{alunoId}")
    public String salvarTreino(@PathVariable Long alunoId, @ModelAttribute Treino treino) {
        treinoService.criarTreinoParaAluno(treino, alunoId);
        return "redirect:/alunos/" + alunoId; 
    }

    @GetMapping("/{id}")
    public String detalhesTreino(@PathVariable Long id, Model model) {
        treinoService.buscarPorId(id).ifPresent(treino -> {
            model.addAttribute("treino", treino);
            List<Exercicio> todosExercicios = exercicioService.listarTodos();
            model.addAttribute("todosExercicios", todosExercicios);
        });
        return "treino/detalhes-treino";
    }

    @PostMapping("/{treinoId}/adicionar-exercicio")
    public String adicionarExercicio(
            @PathVariable Long treinoId,
            @RequestParam Long exercicioId,
            @RequestParam int series,
            @RequestParam int repeticoes) {
        
        treinoService.adicionarExercicioAoTreino(treinoId, exercicioId, series, repeticoes);
        return "redirect:/treinos/" + treinoId;
    }

}
