package br.com.sysacademia.controller;

import br.com.sysacademia.model.Aluno;
import br.com.sysacademia.model.AvaliacaoFisica;
import br.com.sysacademia.service.AlunoService;
import br.com.sysacademia.service.AvaliacaoFisicaService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;

//Classe responsável pela gestão das avaliações físicas
@Controller /* Indica que esta classe é um controlador do Spring */
@RequestMapping("/avaliacoes")  /* Mapeia as requisições para /avaliacoes */
public class AvaliacaoFisicaController {

    //Injeção de dependência dos serviços
    private final AvaliacaoFisicaService avaliacaoFisicaService;
    private final AlunoService alunoService;

    //Construtor
    public AvaliacaoFisicaController(AvaliacaoFisicaService avaliacaoFisicaService, AlunoService alunoService) {
        this.avaliacaoFisicaService = avaliacaoFisicaService;
        this.alunoService = alunoService;
    }

    //Exibe o formulário para nova avaliação física
    @GetMapping("/novo")    /* Mapeia a requisição GET para /avaliacoes/novo */
    public String novaAvaliacaoForm(Model model) {
        model.addAttribute("avaliacao", new AvaliacaoFisica()); //Cria um novo objeto AvaliacaoFisica
        model.addAttribute("alunos", alunoService.listarAlunos());  //Lista todos os alunos disponíveis
        return "nova-avaliacao";    //Retorna o template para nova avaliação
    }

    //Salva uma nova avaliação física
    @PostMapping("/salvar") /* Mapeia a requisição POST para /avaliacoes/salvar */
    public String salvarAvaliacao(@ModelAttribute AvaliacaoFisica avaliacao, @RequestParam("aluno.id") Long alunoId) {
        Optional<Aluno> alunoOptional = alunoService.buscarPorId(alunoId);  //Busca o aluno pelo ID
        //Verifica se o aluno existe
        if (alunoOptional.isPresent()) {
            avaliacao.setAluno(alunoOptional.get());    //Define o aluno na avaliação
            avaliacaoFisicaService.salvar(avaliacao);   //Salva a avaliação física
            return "redirect:/avaliacoes/visualizar/" + avaliacao.getId();  //Redireciona para a visualização da avaliação
        } else {
            return "redirect:/instrutores/painel";  //Redireciona para o painel do instrutor
        }
    }

    //Exibe os detalhes de uma avaliação física
    @GetMapping("/{id}")    /* Mapeia a requisição GET para /avaliacoes/{id} */
    public String visualizarAvaliacao(@PathVariable Long id, Model model) {
        avaliacaoFisicaService.buscarPorId(id).ifPresent(avaliacao -> {
            model.addAttribute("avaliacao", avaliacao); //Adiciona a avaliação ao modelo
        });
        return "avaliacao/detalhes-avaliacao"; //Retorna o template de detalhes da avaliação
    }
}
