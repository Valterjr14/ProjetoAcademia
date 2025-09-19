package br.com.sysacademia.service;

import br.com.sysacademia.model.Recepcionista;
import br.com.sysacademia.repository.RecepcionistaRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;;

@Service
public class RecepcionistaService {
    private final RecepcionistaRepository recepcionistaRepository;
    private final PasswordEncoder passwordEncoder;

    public RecepcionistaService(RecepcionistaRepository recepcionistaRepository, PasswordEncoder passwordEncoder){
        this.recepcionistaRepository = recepcionistaRepository;
        this.passwordEncoder = passwordEncoder;
    }
    
    public Recepcionista salvar(Recepcionista recepcionista){
        recepcionista.setSenha(passwordEncoder.encode(recepcionista.getSenha()));
        return recepcionistaRepository.save(recepcionista);
    }
}
