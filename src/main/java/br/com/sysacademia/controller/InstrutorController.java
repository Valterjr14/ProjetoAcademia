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
import java.util.List;

// Controlador para gerenciar instrutores
@Controller /* Indica que esta classe é um controlador do Spring */
@RequestMapping("/instrutores") /* Mapeia as requisições para /instrutores */
public class InstrutorController {

    //Injeção de dependência dos serviços
    private final InstrutorService instrutorService;
    private final AlunoService alunoService;
    private final AvaliacaoFisicaService avaliacaoFisicaService;

    //Construtor
    public InstrutorController(InstrutorService instrutorService, AlunoService alunoService, AvaliacaoFisicaService avaliacaoFisicaService) {
        this.instrutorService = instrutorService;
        this.alunoService = alunoService;
        this.avaliacaoFisicaService = avaliacaoFisicaService;
    }

    //Painel do instrutor
    @GetMapping("/painel")
    public String painelInstrutor(@RequestParam(name = "q", required = false) String query, Model model) {
        instrutorService.buscarPorId(1L).ifPresent(instrutor -> {
            model.addAttribute("instrutor", instrutor);
        }); 
        //Busca por alunos
        List<Aluno> alunos;
        //Verifica se há um termo de busca
        if (query != null && !query.isEmpty()) {
            alunos = alunoService.buscarPorNome(query); //Busca alunos pelo nome
        } else {
            alunos = alunoService.listarAlunos();   //Lista todos os alunos
        }    
        //Adiciona os alunos e o termo de busca ao modelo
        model.addAttribute("alunos", alunos);   
        model.addAttribute("termoBusca", query);
        
        return "instrutor/painel";  //Retorna a view para o painel do instrutor
    }

    //Gerencia um aluno específico
    @GetMapping("/gerenciar-aluno/{alunoId}")
    public String gerenciarAluno(@PathVariable Long alunoId, Model model) {
        alunoService.buscarPorId(alunoId).ifPresent(aluno -> {
            model.addAttribute("aluno", aluno);
        });
        return "instrutor/gerenciar-aluno";
    }

    //Formulário para nova avaliação
    @GetMapping("/gerenciar-aluno/{alunoId}/nova-avaliacao")     
    public String novaAvaliacaoForm(@PathVariable Long alunoId, Model model) {
        model.addAttribute("avaliacao", new AvaliacaoFisica()); 
        model.addAttribute("alunoId", alunoId);
        return "instrutor/form-avaliacao";
    }

    //Salva uma nova avaliação
    @PostMapping("/gerenciar-aluno/{alunoId}/salvar-avaliacao")
    public String salvarAvaliacao(@PathVariable Long alunoId, @ModelAttribute AvaliacaoFisica avaliacao) {
        alunoService.buscarPorId(alunoId).ifPresent(aluno -> {
            avaliacao.setAluno(aluno);
            avaliacao.setData(LocalDate.now());
            avaliacaoFisicaService.salvar(avaliacao);
        });
        return "redirect:/instrutores/gerenciar-aluno/" + alunoId;
    }
    
    //Formulario para novo instrutor
    @GetMapping("/novo")
    public String novoInstrutorForm(Model model) {
        model.addAttribute("instrutor", new Instrutor());
        return "cadastro-instrutor";
    }

    //Salva um novo instrutor
    @PostMapping("/salvar")
    public String salvarInstrutor(@ModelAttribute Instrutor instrutor) {
        instrutorService.salvar(instrutor);
        return "redirect:/login.html";
    }
}