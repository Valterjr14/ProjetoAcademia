package br.com.sysacademia.service;

import br.com.sysacademia.model.Aluno;
import br.com.sysacademia.model.Instrutor;
import br.com.sysacademia.repository.AlunoRepository;
import br.com.sysacademia.repository.InstrutorRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Optional;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final AlunoRepository alunoRepository;
    private final InstrutorRepository instrutorRepository;

    public CustomUserDetailsService(AlunoRepository alunoRepository, InstrutorRepository instrutorRepository) {
        this.alunoRepository = alunoRepository;
        this.instrutorRepository = instrutorRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<Instrutor> instrutorOpt = instrutorRepository.findByEmail(email);
        if (instrutorOpt.isPresent()) {
            Instrutor instrutor = instrutorOpt.get();
            return new User(instrutor.getEmail(), instrutor.getSenha(), Collections.singletonList(() -> "ROLE_INSTRUTOR"));
        }

        Optional<Aluno> alunoOpt = alunoRepository.findByEmail(email);
        if (alunoOpt.isPresent()) {
            Aluno aluno = alunoOpt.get();
            return new User(aluno.getEmail(), aluno.getSenha(), Collections.singletonList(() -> "ROLE_ALUNO"));
        }

        throw new UsernameNotFoundException("Usuário não encontrado com o email: " + email);
    }
}
