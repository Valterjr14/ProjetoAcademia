package br.com.sysacademia.service;

import br.com.sysacademia.model.Aluno;
import br.com.sysacademia.model.Instrutor;
import br.com.sysacademia.model.Recepcionista;
import br.com.sysacademia.repository.AlunoRepository;
import br.com.sysacademia.repository.InstrutorRepository;
import br.com.sysacademia.repository.RecepcionistaRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import java.util.Collections;
import java.util.Optional;

//Serviço para a autenticação de usuários
@Service    /* Indica que esta classe é um serviço do Spring */
public class CustomUserDetailsService implements UserDetailsService {
    //Injeção de dependências
    private final AlunoRepository alunoRepository;
    private final InstrutorRepository instrutorRepository;
    private final RecepcionistaRepository recepcionistaRepository;

    //Construtor
    public CustomUserDetailsService(AlunoRepository alunoRepository, InstrutorRepository instrutorRepository, RecepcionistaRepository recepcionistaRepository) {
        this.alunoRepository = alunoRepository;
        this.instrutorRepository = instrutorRepository;
        this.recepcionistaRepository = recepcionistaRepository;
    }

    //Método para carregar um usuário pelo email
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<Instrutor> instrutorOpt = instrutorRepository.findByEmail(email);  /* Busca um instrutor pelo email */
        //Verifica se o instrutor foi encontrado
        if (instrutorOpt.isPresent()) {
            Instrutor instrutor = instrutorOpt.get();   /* Obtém o instrutor encontrado */
            return new User(instrutor.getEmail(), instrutor.getSenha(), Collections.singletonList(() -> "ROLE_INSTRUTOR")); /* Retorna os detalhes do instrutor */
        }

        Optional<Aluno> alunoOpt = alunoRepository.findByEmail(email);  /* Busca um aluno pelo email */
        //Verifica se o aluno foi encontrado
        if (alunoOpt.isPresent()) {
            Aluno aluno = alunoOpt.get();   /* Obtém o aluno encontrado */
            return new User(aluno.getEmail(), aluno.getSenha(), Collections.singletonList(() -> "ROLE_ALUNO")); /* Retorna os detalhes do aluno */
        }

        Optional<Recepcionista> recepcionistaOpt = recepcionistaRepository.findByEmail(email);
        if (recepcionistaOpt.isPresent()) {
            Recepcionista recepcionista = recepcionistaOpt.get();
            return new User(recepcionista.getEmail(), recepcionista.getSenha(), Collections.singletonList(() -> "ROLE_RECEPCIONISTA"));     
        }

        throw new UsernameNotFoundException("Usuário não encontrado com o email: " + email);    /* Lança uma exceção se usuário não encontrado */
    }
}
