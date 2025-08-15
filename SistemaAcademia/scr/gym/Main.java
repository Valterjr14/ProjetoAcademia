package scr.gym;

import scr.gym.model.usuario.aluno.Aluno;
import scr.gym.model.usuario.instrutor.Instrutor;

public class Main {
    public static void main(String[] args) {
        Aluno usuario = new Aluno("Pedro", "pedro@example.com", "senha123", "12345");
        Instrutor instrutor = new Instrutor("Maria", "maria@example.com", "senha456", "Musculação");
        System.out.println("Nome: " + usuario.getNome());
        System.out.println("Email: " + usuario.getEmail());
        System.out.println("Senha: " + usuario.getSenha());
        System.out.println("Matrícula: " + usuario.getMatricula());
        System.out.println("Nome: " + instrutor.getNome());
        System.out.println("Email: " + instrutor.getEmail());
        System.out.println("Senha: " + instrutor.getSenha());
        System.out.println("Especialidade: " + instrutor.getEspecialidade());
    }
}
