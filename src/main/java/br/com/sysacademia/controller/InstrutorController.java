package br.com.sysacademia.controller;

import br.com.sysacademia.model.Instrutor;
import br.com.sysacademia.service.InstrutorService;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;


import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/instrutores")
public class InstrutorController {

    private final InstrutorService instrutorService;

    public InstrutorController(InstrutorService instrutorService) {
        this.instrutorService = instrutorService;
    }

    @GetMapping("/novo")
    public String novoInstrutorForm(Model model) {
        model.addAttribute("instrutor", new Instrutor());
        return "cadastro-instrutor";
    }

    @PostMapping("/salvar")
    public String salvarInstrutor(@ModelAttribute Instrutor instrutor) {
        System.out.println("Cadastrando instrutor: " + instrutor.getNome());
        instrutorService.salvar(instrutor);
        return "redirect:/login.html";
    }

    @PostMapping
    public Instrutor criar(@RequestBody Instrutor instrutor) {
        System.out.println("Cadastrando instrutor: " + instrutor.getNome());
        return instrutorService.salvar(instrutor);
    }

    @GetMapping
    public List<Instrutor> listar() {
        System.out.println("Listando instrutores...");
        return instrutorService.listarTodos();
    }

    @GetMapping("/{id}")
    public Optional<Instrutor> buscarPorId(@PathVariable Long id) {
        System.out.println("Buscando instrutor com id " + id);
        return instrutorService.buscarPorId(id);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        System.out.println("Removendo instrutor com id " + id);
        instrutorService.deletar(id);
    }
}
