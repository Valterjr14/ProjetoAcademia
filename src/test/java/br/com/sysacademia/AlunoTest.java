package br.com.sysacademia;

import br.com.sysacademia.model.Aluno;
import br.com.sysacademia.model.Plano;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class AlunoTest {

    @Test
    void criacaoTesteAluno(){
        Plano plano = new Plano();
        Aluno aluno = new Aluno("Junior", "jn@gn.com", "senha3782", "123", "12345678901", plano);

        assertEquals("Junior", aluno.getNome());
        assertEquals("jn@gn.com", aluno.getEmail());
        assertEquals("123", aluno.getMatricula());
        assertEquals(plano, aluno.getPlano());
    }
}
