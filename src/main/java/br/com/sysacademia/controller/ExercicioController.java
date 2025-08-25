package br.com.sysacademia.controller;

import br.com.sysacademia.model.Exercicio;
import br.com.sysacademia.service.ExercicioService;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Controller;

@Controller
@RequestMapping("/exercicios")
public class ExercicioController {
    private final ExercicioService exercicioService;

    public ExercicioController(ExercicioService exercicioService) {
        this.exercicioService = exercicioService;
    }
    @PostMapping
    public Exercicio criar(@RequestBody Exercicio exercicio) {
        return exercicioService.salvar(exercicio);
    }
    @GetMapping
    public List<Exercicio> listar() {
        return exercicioService.listarTodos();
    }
    @GetMapping("/{id}")
    public Optional<Exercicio> buscarPorId(@PathVariable Long id) {
        return exercicioService.buscarPorId(id);
    }
    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        exercicioService.deletar(id);
    }
}
