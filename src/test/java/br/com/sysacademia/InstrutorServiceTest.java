package br.com.sysacademia.service;

import br.com.sysacademia.model.Aluno;
import br.com.sysacademia.model.AvaliacaoFisica;
import br.com.sysacademia.model.Instrutor;
import br.com.sysacademia.model.Plano;
import br.com.sysacademia.model.Treino;
import br.com.sysacademia.repository.AlunoRepository;
import br.com.sysacademia.repository.InstrutorRepository;
import br.com.sysacademia.repository.PlanoRepository;
import br.com.sysacademia.repository.TreinosRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
public class InstrutorServiceTest {

    @Autowired
    private InstrutorService instrutorService;

    @Autowired
    private AlunoService alunoService;

    @Autowired
    private TreinoService treinoService;

    @Autowired
    private PlanoService planoService;

    @Autowired
    private InstrutorRepository instrutorRepository;

    @Autowired
    private AlunoRepository alunoRepository;

    @Autowired
    private PlanoRepository planoRepository;

    @Autowired
    private TreinosRepository treinosRepository;

    private Instrutor instrutor;
    private Aluno aluno;
    private Plano plano;

    @BeforeEach
    void setUp() {
        // Inicializa o instrutor e o plano antes de cada teste
        instrutor = new Instrutor("Instrutor Teste", "instrutor@test.com", "senha123", "Musculação");
        plano = new Plano("Premium", 500.0, 6);
        aluno = new Aluno("Aluno Teste", "aluno@test.com", "senha123", "M001", "12345678901", plano);
        
        // Salva as entidades no banco de dados para que possam ser usadas nos testes
        instrutorRepository.save(instrutor);
        planoRepository.save(plano);
        alunoRepository.save(aluno);
    }

    @Test
    void testCadastrarAluno() {
        // Verifica se o aluno foi salvo com sucesso
        Aluno alunoSalvo = alunoRepository.findById(aluno.getId()).orElse(null);
        assertNotNull(alunoSalvo);
        assertEquals("Aluno Teste", alunoSalvo.getNome());
    }

    @Test
    void testInstrutorPodeCriarTreinoParaAluno() {
        // O instrutor cria um novo treino para um aluno específico.
        // A lógica de negócio está na classe Instrutor.
        Treino treino = new Treino("Treino de Força", "Avançado", 60);
        instrutor.criarTreino(aluno, treino);
        
        // O serviço de treino salva o treino e a associação com o aluno.
        treinoService.salvarTreino(treino);
        
        // Busca o aluno e verifica se o treino foi adicionado
        Aluno alunoAtualizado = alunoRepository.findById(aluno.getId()).orElse(null);
        assertNotNull(alunoAtualizado);
        assertFalse(alunoAtualizado.getTreinos().isEmpty());
        assertEquals("Treino de Força", alunoAtualizado.getTreinos().get(0).getDescricaoTreino());
    }

    @Test
    void testInstrutorPodeRealizarAvaliacaoParaAluno() {
        // O instrutor realiza a avaliação para um aluno específico.
        // A lógica de negócio está na classe Instrutor.
        AvaliacaoFisica avaliacao = new AvaliacaoFisica(LocalDate.now(), 80.0, 15.0, 1.75);
        instrutor.realizarAvaliacao(aluno, avaliacao);

        // Busca o aluno e verifica se a avaliação foi adicionada
        Aluno alunoAtualizado = alunoRepository.findById(aluno.getId()).orElse(null);
        assertNotNull(alunoAtualizado);
        assertFalse(alunoAtualizado.getAvaliacoes().isEmpty());
        assertEquals(80.0, alunoAtualizado.getAvaliacoes().get(0).getPeso());
    }
    
    @Test
    void testInstrutorPodeAdicionarAluno() {
        // O instrutor adiciona um aluno à sua lista de alunos
        instrutorService.adicionarAluno(instrutor, aluno);

        // Busca o instrutor e verifica se o aluno foi adicionado
        Instrutor instrutorAtualizado = instrutorRepository.findById(instrutor.getId()).orElse(null);
        assertNotNull(instrutorAtualizado);
        assertTrue(instrutorAtualizado.getAlunos().contains(aluno));
    }
}