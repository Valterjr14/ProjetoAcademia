package br.com.sysacademia.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler; 

//Configuração de segurança
@Configuration      /* Indica que esta classe é uma configuração do Spring */
@EnableWebSecurity  /* Habilita a segurança da web no aplicativo */
public class SecurityConfig {

    //Injeção de dependência do manipulador de sucesso de autenticação
    private final AuthenticationSuccessHandler authenticationSuccessHandler;

    //Construtor
    public SecurityConfig(AuthenticationSuccessHandler authenticationSuccessHandler) {
        this.authenticationSuccessHandler = authenticationSuccessHandler;
    }

    //Define um bean para o codificador de senhas
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    //Configura a cadeia de filtros de segurança
@Bean
public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    http
        .authorizeHttpRequests(authorize -> authorize
            // Rotas públicas que não exigem login
            .requestMatchers("/css/**", "/login", "/sucesso.html", "/alunos/novo", "/alunos/salvar", "/instrutores/novo", "/instrutores/salvar").permitAll()
            
            // Rotas protegidas por papel
            .requestMatchers("/recepcionista/**").hasRole("RECEPCIONISTA")
            .requestMatchers("/planos/**").hasRole("RECEPCIONISTA")
            .requestMatchers("/instrutores/**").hasRole("INSTRUTOR")
            .requestMatchers("/alunos/**").hasAnyRole("ALUNO", "INSTRUTOR", "RECEPCIONISTA") // Alunos e Instrutores podem ver detalhes de alunos
            
            // Qualquer outra requisição precisa de autenticação
            .anyRequest().authenticated()
        )
        .formLogin(form -> form
            .loginPage("/login")
            .successHandler(authenticationSuccessHandler)
            .permitAll()
        )
        .logout(logout -> logout.permitAll());
    return http.build();
}
}
