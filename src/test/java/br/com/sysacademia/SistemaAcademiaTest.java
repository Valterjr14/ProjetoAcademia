package br.com.sysacademia;

import br.com.sysacademia.model.*;
import br.com.sysacademia.service.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
public class SistemaAcademiaTest {

    @Autowired
    private AlunoService alunoService;
    @Autowired
    private PlanoService planoService;
    @Autowired
    private InstrutorService instrutorService;
    @Autowired
    private AvaliacaoFisicaService avaliacaoFisicaService;

    @Test
    void testCriacaoESalvarAluno() {
        Plano plano = new Plano("Plano Teste", new BigDecimal("100.0"), 1);
        planoService.salvarPlano(plano);
        Aluno aluno = new Aluno("Joao da Silva", "joao@email.com", "senha123", "M001", "12345678901", plano);
        Aluno alunoSalvo = alunoService.salvarAluno(aluno);
        assertNotNull(alunoSalvo.getId());
        assertEquals("Joao da Silva", alunoSalvo.getNome());
    }

    @Test
    void testBuscarAlunoPorMatricula() {
        Plano plano = new Plano("Plano Teste", new BigDecimal("100.0"), 1);
        planoService.salvarPlano(plano);
        Aluno aluno = new Aluno("Maria Oliveira", "maria@email.com", "senha456", "M002", "98765432109", plano);
        alunoService.salvarAluno(aluno);
        Aluno alunoEncontrado = alunoService.buscarPorMatricula("M002");
        assertNotNull(alunoEncontrado);
        assertEquals("Maria Oliveira", alunoEncontrado.getNome());
    }

    @Test
    void testListarTodosAlunos() {
        Plano plano = new Plano("Plano Teste", new BigDecimal("100.0"), 1);
        planoService.salvarPlano(plano);
        Aluno aluno1 = new Aluno("Carlos Pereira", "carlos@email.com", "senha789", "M003", "11122233344", plano);
        Aluno aluno2 = new Aluno("Ana Souza", "ana@email.com", "senhaabc", "M004", "55566677788", plano);
        alunoService.salvarAluno(aluno1);
        alunoService.salvarAluno(aluno2);
        List<Aluno> alunos = alunoService.listarAlunos();
        assertEquals(2, alunos.size());
    }
    
    @Test
    void testSalvarEPesquisarPlano() {
        Plano plano = new Plano("Plano Teste", new BigDecimal("100.0"), 1);
        Plano planoSalvo = planoService.salvarPlano(plano);
        assertNotNull(planoSalvo.getId());
        Optional<Plano> planoEncontrado = planoService.buscarPorId(planoSalvo.getId());
        assertTrue(planoEncontrado.isPresent());
    }
    
    @Test
    void testDeletarPlano() {
        Plano plano = new Plano("Plano Teste", new BigDecimal("100.0"), 1);
        Plano planoSalvo = planoService.salvarPlano(plano);
        planoService.deletarPlano(planoSalvo.getId());
        Optional<Plano> planoEncontrado = planoService.buscarPorId(planoSalvo.getId());
        assertFalse(planoEncontrado.isPresent());
    }

    @Test
    void testCriarEListarInstrutor() {
        Instrutor instrutor = new Instrutor("Marcos Santos", "marcos@email.com", "senha123", "Musculação");
        Instrutor instrutorSalvo = instrutorService.salvar(instrutor);
        assertNotNull(instrutorSalvo.getId());
        List<Instrutor> instrutores = instrutorService.listarTodos();
        assertFalse(instrutores.isEmpty());
        assertEquals(1, instrutores.size());
    }
    
    @Test
    void testCriarEListarAvaliacaoFisica() {
        Aluno aluno = new Aluno("Pedro", "pedro@email.com", "senha123", "M005", "12312312312", null);
        alunoService.salvarAluno(aluno);
        AvaliacaoFisica avaliacao = new AvaliacaoFisica(LocalDate.now(), 75.0, 18.0, 1.70, aluno);
        AvaliacaoFisica avaliacaoSalva = avaliacaoFisicaService.salvar(avaliacao);
        assertNotNull(avaliacaoSalva.getId());
        assertEquals(75.0, avaliacaoSalva.getPeso());
    }
}
