package br.com.sysacademia.controller;
import br.com.sysacademia.model.Plano;
import br.com.sysacademia.service.PlanoService;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Controller;

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
    @PostMapping
    public Plano criar(@RequestBody Plano plano) {
        return planoService.salvarPlano(plano);
    }
    //Lista todos os planos
    @GetMapping
    public List<Plano> listar() {
        return planoService.listarPlanos();
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
