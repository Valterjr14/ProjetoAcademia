package br.com.sysacademia.controller;

import br.com.sysacademia.model.Exercicio;
import br.com.sysacademia.service.ExercicioService;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Controller;

//Controlador para gerenciar exercícios
@Controller /* Indica que esta classe é um controlador do Spring */
@RequestMapping("/exercicios")  /* Mapeia as requisições para /exercicios */
public class ExercicioController {
    //Injeção de dependência do serviço de exercícios
    private final ExercicioService exercicioService;

    //Construtor
    public ExercicioController(ExercicioService exercicioService) {
        this.exercicioService = exercicioService;
    }

    //Cria um novo exercício
    @PostMapping    /* Mapeia a requisição POST para /exercicios */
    public Exercicio criar(@RequestBody Exercicio exercicio) {
        return exercicioService.salvar(exercicio);
    }

    //Lista todos os exercícios
    @GetMapping
    public List<Exercicio> listar() {
        return exercicioService.listarTodos();
    }

    //Busca um exercício pelo ID
    @GetMapping("/{id}")
    public Optional<Exercicio> buscarPorId(@PathVariable Long id) {
        return exercicioService.buscarPorId(id);
    }

    //Deleta um exercício pelo ID
    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        exercicioService.deletar(id);
    }
}
