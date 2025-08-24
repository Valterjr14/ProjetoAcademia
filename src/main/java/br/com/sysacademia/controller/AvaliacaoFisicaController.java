package br.com.sysacademia.controller;

import br.com.sysacademia.model.AvaliacaoFisica;
import br.com.sysacademia.service.AvaliacaoFisicaService;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/avaliacoes")
public class AvaliacaoFisicaController {

    private final AvaliacaoFisicaService avaliacaoFisicaService;

    public AvaliacaoFisicaController(AvaliacaoFisicaService avaliacaoFisicaService) {
        this.avaliacaoFisicaService = avaliacaoFisicaService;
    }

    @PostMapping
    public AvaliacaoFisica criar(@RequestBody AvaliacaoFisica avaliacao) {
        return avaliacaoFisicaService.salvar(avaliacao);
    }

    @GetMapping
    public List<AvaliacaoFisica> listar() {
        return avaliacaoFisicaService.listarTodos();
    }

    @GetMapping("/{id}")
    public Optional<AvaliacaoFisica> buscarPorId(@PathVariable Long id) {
        return avaliacaoFisicaService.buscarPorId(id);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        avaliacaoFisicaService.deletar(id);
    }
}
