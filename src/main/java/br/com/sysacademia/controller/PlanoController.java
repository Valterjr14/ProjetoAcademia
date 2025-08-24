package br.com.sysacademia.controller;
import br.com.sysacademia.model.Plano;
import br.com.sysacademia.service.PlanoService;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/planos")
public class PlanoController {
    private final PlanoService planoService;

    public PlanoController(PlanoService planoService) {
        this.planoService = planoService;
    }
    @PostMapping
    public Plano criar(@RequestBody Plano plano) {
        return planoService.salvarPlano(plano);
    }
    @GetMapping
    public List<Plano> listar() {
        return planoService.listarPlanos();
    }
    @GetMapping("/{id}")
    public Optional<Plano> buscarPorId(@PathVariable Long id) {
        return planoService.buscarPorId(id);
    }
    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        planoService.deletarPlano(id);
    }
}
