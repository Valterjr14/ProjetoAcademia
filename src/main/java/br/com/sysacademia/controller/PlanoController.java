package br.com.sysacademia.controller;
import br.com.sysacademia.model.Plano;
import br.com.sysacademia.service.PlanoService;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

// Controlador para gerenciar planos
@Controller /* Indica que esta classe é um controlador do Spring */
@RequestMapping("/planos")  /* Mapeia as requisições para /planos */
public class PlanoController {
    //Injeção de dependência do serviço de planos
    private final PlanoService planoService;

    //Construtor
    public PlanoController(PlanoService planoService) {
        this.planoService = planoService;
    }
    //Cria um novo plano  
    @GetMapping("/novo")
    public String novoPlanoForm(Model model) {
        model.addAttribute("plano", new Plano());
        return "plano/form-plano";
    }
    //Lista todos os planos
    @GetMapping
    public String listarPlanos(Model model) {
        model.addAttribute("planos", planoService.listarPlanos());
        return "plano/lista-planos";
    }
    //Salva um novo plano
    @PostMapping("/salvar")
    public String salvarPlano(@ModelAttribute Plano plano) {
        planoService.salvarPlano(plano);
        return "redirect:/planos";
    }
    //Edita um plano existente
    @GetMapping("/editar/{id}")
    public String editarPlanoForm(@PathVariable Long id, Model model) {
        Optional<Plano> plano = planoService.buscarPorId(id);
        if (plano.isPresent()) {
            model.addAttribute("plano", plano.get());
            return "plano/form-plano";
        }
        return "redirect:/planos";
    }
    //Busca um plano por ID
    @GetMapping("/{id}")
    public Optional<Plano> buscarPorId(@PathVariable Long id) {
        return planoService.buscarPorId(id);
    }
    //Deleta um plano por ID
    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        planoService.deletarPlano(id);
    }
}
