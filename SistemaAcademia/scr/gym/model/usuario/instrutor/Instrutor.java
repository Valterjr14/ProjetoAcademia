package scr.gym.model.usuario.instrutor;

import scr.gym.model.usuario.Usuario;

public class Instrutor extends Usuario {
    private String especialidade;

    public Instrutor(String nome, String email, String senha, String especialidade) {
        super(nome, email, senha);
        this.especialidade = especialidade;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }
    @Override
    public String toString() {
        return "Instrutor{" +
                "nome='" + getNome() + '\'' +
                ", email='" + getEmail() + '\'' +
                ", senha='" + getSenha() + '\'' +
                ", especialidade='" + especialidade + '\'' +
                '}';
    }
}
