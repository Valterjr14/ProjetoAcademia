package br.com.sysacademia.controller;

import br.com.sysacademia.model.Exercicio;
import br.com.sysacademia.model.Treino;
import br.com.sysacademia.service.ExercicioService;
import br.com.sysacademia.service.TreinoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

// Controlador para gerenciar treinos
@Controller /* Indica que esta classe é um controlador do Spring */
@RequestMapping("/treinos") /* Mapeia as requisições para /treinos */
public class TreinoController {

    //Injeção de dependência dos serviços
    private final TreinoService treinoService;
    private final ExercicioService exercicioService;

    //Construtor
    public TreinoController(TreinoService treinoService, ExercicioService exercicioService) {
        this.treinoService = treinoService;
        this.exercicioService = exercicioService;
    }

    //Lista todos os treinos
    @GetMapping
    public String listarTreinos(Model model) {
        model.addAttribute("treinos", treinoService.listarTodos());
        return "treino/lista-treinos";
    }

    //Formulário para novo treino
    @GetMapping("/novo/{alunoId}")
    public String novoTreinoForm(@PathVariable Long alunoId, Model model) {
        model.addAttribute("treino", new Treino());
        model.addAttribute("alunoId", alunoId);
        return "treino/form-treino";
    }

    //Salva um novo treino
    @PostMapping("/salvar/{alunoId}")
    public String salvarTreino(@PathVariable Long alunoId, @ModelAttribute Treino treino) {
        treinoService.criarTreinoParaAluno(treino, alunoId);
        return "redirect:/alunos/" + alunoId; 
    }

    //Detalhes de um treino específico
    @GetMapping("/{id}")
    public String detalhesTreino(@PathVariable Long id, Model model) {
        treinoService.buscarPorId(id).ifPresent(treino -> {
            model.addAttribute("treino", treino);
            List<Exercicio> todosExercicios = exercicioService.listarTodos();
            model.addAttribute("todosExercicios", todosExercicios);
        });
        return "treino/detalhes-treino";
    }

    //Adiciona um exercício a um treino
    @PostMapping("/{treinoId}/adicionar-exercicio")
    public String adicionarExercicio(
            @PathVariable Long treinoId,
            @RequestParam String exercicioNome, 
            @RequestParam int series,
            @RequestParam int repeticoes) {
        
        Optional<Exercicio> exercicioOpt = exercicioService.buscarPorNome(exercicioNome);   //Busca o exercício pelo nome
        //Verifica se o exercício foi encontrado
        if (exercicioOpt.isPresent()) {
            treinoService.adicionarExercicioAoTreino(treinoId, exercicioOpt.get().getId(), series, repeticoes);
        } else {
            System.out.println("Exercício com nome '" + exercicioNome + "' não encontrado.");
        }

        return "redirect:/treinos/" + treinoId;
    }

}
