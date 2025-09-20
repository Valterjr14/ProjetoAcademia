package br.com.sysacademia.controller;

import br.com.sysacademia.model.Aluno;
import br.com.sysacademia.service.AlunoService;
import br.com.sysacademia.service.PlanoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;

//Classe responsável pelo gerenciamento dos alunos
@Controller /* Indica que esta classe é um controlador do Spring */
@RequestMapping("/alunos")  /* Mapeia as requisições para /alunos */
public class AlunoController {

    //Injeção de dependência dos serviços
    private final AlunoService service;
    private final PlanoService planoService;

    //Construtor
    public AlunoController(AlunoService service, PlanoService planoService) {
        this.service = service;
        this.planoService = planoService;
    }

    //Exibe o formulário para cadastro de um novo aluno
    @GetMapping("/novo")    /* Mapeia a requisição GET para /alunos/novo */
    public String novoAlunoForm(Model model) {
        model.addAttribute("aluno", new Aluno());  //Cria um novo objeto Aluno
        model.addAttribute("todosOsPlanos", planoService.listarPlanos());   //Lista todos os planos disponíveis
        return "aluno/cadastro-aluno";  //Retorna o template de cadastro de aluno
    }

    //Salva um novo aluno
    @PostMapping("/salvar") /* Mapeia a requisição POST para /alunos/salvar */
    public String salvarAluno(@ModelAttribute Aluno aluno) {
        service.salvarAluno(aluno);
        if(aluno.getId() != null){
            return "redirect:/recepcionista/alunos";
        }
        return "redirect:/sucesso";
    }

    //Lista todos os alunos
    @GetMapping /* Mapeia a requisição GET para /alunos */
    public String listarAlunos(Model model) {
        model.addAttribute("alunos", service.listarAlunos());
        return "aluno/lista-alunos";
    }

    @GetMapping("/editar/{id}")
    public String editarAlunoForm(@PathVariable Long id, Model model){
        service.buscarPorId(id).ifPresent(aluno -> {
            model.addAttribute("aluno", aluno);
            model.addAttribute("todosOsPlanos", planoService.listarPlanos());
        });
        return "aluno/cadastro-aluno";
    }
    //Exibe os detalhes de um aluno
    @GetMapping("/{id}")    /* Mapeia a requisição GET para /alunos/{id} */
    public String detalhesAluno(@PathVariable Long id, Model model) {
        service.buscarPorId(id).ifPresent(aluno -> {
            model.addAttribute("aluno", aluno);
        }); //Adiciona o aluno encontrado ao modelo
        return "aluno/detalhes-aluno";  //Retorna o template de detalhes do aluno
    }

    //Deleta um aluno
    @PostMapping("/{id}/deletar")   /* Mapeia a requisição POST para /alunos/{id}/deletar */
    public String deletarAluno(@PathVariable Long id) {
        service.deletarAluno(id);   //Deleta o aluno com o ID especificado
        return "redirect:/instrutores/painel";  //Redireciona para o painel do instrutor após a deleção
    }

    //Exibe o painel do aluno
    @GetMapping("/painel")  /* Mapeia a requisição GET para /alunos/painel */
    public String painelAluno(Authentication authentication, Model model) {
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();  //Obtém os detalhes do usuário autenticado
        String email = userDetails.getUsername();   //Obtém o email do usuário autenticado
        //Busca o aluno pelo email
        service.buscarPorEmail(email).ifPresent(aluno -> {
            model.addAttribute("aluno", aluno);
        });

        return "aluno/painel";  //Retorna o template do painel do aluno
    }
}