package br.com.sysacademia;

import br.com.sysacademia.model.*;
import br.com.sysacademia.repository.*;
import br.com.sysacademia.service.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class SistemaAcademiaTest {

    @Autowired
    private AlunoService alunoService;
    @Autowired
    private AlunoRepository alunoRepository;
    @Autowired
    private PlanoService planoService;
    @Autowired
    private PlanoRepository planoRepository;
    @Autowired
    private InstrutorService instrutorService;
    @Autowired
    private InstrutorRepository instrutorRepository;
    @Autowired
    private AvaliacaoFisicaService avaliacaoFisicaService;
    @Autowired
    private AvaliacaoFisicaRepository avaliacaoFisicaRepository;
    @Autowired
    private ExercicioService exercicioService;
    @Autowired
    private ExercicioRepository exercicioRepository;
    @Autowired
    private TreinoService treinoService;
    @Autowired
    private TreinosRepository treinosRepository;


    @BeforeEach
    void setUp() {
        // Limpar os repositórios antes de cada teste para garantir um ambiente limpo
        alunoRepository.deleteAll();
        planoRepository.deleteAll();
        instrutorRepository.deleteAll();
        avaliacaoFisicaRepository.deleteAll();
        exercicioRepository.deleteAll();
        treinosRepository.deleteAll();
    }

    @Test
    void testCriacaoESalvarAluno() {
        Plano plano = new Plano("Plano Teste", 150.0, 3);
        planoService.salvarPlano(plano);
        Aluno aluno = new Aluno("Joao da Silva", "joao@email.com", "senha123", "M001", "12345678901", plano);
        Aluno alunoSalvo = alunoService.salvarAluno(aluno);
        assertNotNull(alunoSalvo.getId());
        assertEquals("Joao da Silva", alunoSalvo.getNome());
    }

    @Test
    void testBuscarAlunoPorMatricula() {
        Plano plano = new Plano("Plano Teste", 150.0, 3);
        planoService.salvarPlano(plano);
        Aluno aluno = new Aluno("Maria Oliveira", "maria@email.com", "senha456", "M002", "98765432109", plano);
        alunoService.salvarAluno(aluno);
        Aluno alunoEncontrado = alunoService.buscarPorMatricula("M002");
        assertNotNull(alunoEncontrado);
        assertEquals("Maria Oliveira", alunoEncontrado.getNome());
    }

    @Test
    void testListarTodosAlunos() {
        Plano plano = new Plano("Plano Teste", 150.0, 3);
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
        Plano plano = new Plano("Plano Bronze", 100.0, 1);
        Plano planoSalvo = planoService.salvarPlano(plano);
        assertNotNull(planoSalvo.getId());
        Optional<Plano> planoEncontrado = planoService.buscarPorId(planoSalvo.getId());
        assertTrue(planoEncontrado.isPresent());
        assertEquals("Plano Bronze", planoEncontrado.get().getNomePlano());
    }
    
    @Test
    void testDeletarPlano() {
        Plano plano = new Plano("Plano Prata", 200.0, 6);
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

    @Test
    void testCriarEListarExercicio() {
        Exercicio exercicio = new Exercicio("Supino Reto");
        Exercicio exercicioSalvo = exercicioService.salvar(exercicio);
        assertNotNull(exercicioSalvo.getId());
        List<Exercicio> exercicios = exercicioService.listarTodos();
        assertFalse(exercicios.isEmpty());
        assertEquals("Supino Reto", exercicios.get(0).getNome());
    }
    
    @Test
    void testAdicionarExercicioAOTreino() {
        Treino treino = new Treino("Treino de Peito", "Iniciante", 45);
        treinosRepository.save(treino);
        Exercicio exercicio = new Exercicio("Crucifixo");
        exercicioRepository.save(exercicio);
        //treinoService.adicionarExercicioAoTreino(treino, exercicio, 12, 3);
        assertEquals(1, treino.getListaExercicios().size());
        assertEquals("Crucifixo", treino.getListaExercicios().get(0).getExercicio().getNome());
    }
}
