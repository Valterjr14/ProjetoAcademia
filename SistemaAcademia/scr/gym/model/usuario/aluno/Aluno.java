package scr.gym.model.usuario.aluno;

import scr.gym.model.usuario.Usuario;

public class Aluno extends Usuario {
    private String matricula;

    public Aluno(String nome, String email, String senha, String matricula) {
        super(nome, email, senha);
        this.matricula = matricula;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }
    @Override
    public String toString() {
        return "Aluno{" +
                "nome='" + getNome() + '\'' +
                ", email='" + getEmail() + '\'' +
                ", senha='" + getSenha() + '\'' +
                ", matricula='" + matricula + '\'' +
                '}';
    }
}
