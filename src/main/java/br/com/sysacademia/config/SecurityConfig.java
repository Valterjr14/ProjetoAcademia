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
                .requestMatchers("/css/**", "/login", "/sucesso.html").permitAll()
                .requestMatchers("/alunos/novo", "/instrutores/novo", "/planos/**", "/exercicios/**").hasRole("RECEPCIONISTA")
                .requestMatchers("/recepcionista/**").hasRole("RECEPCIONISTA")
                .requestMatchers("/instrutores/**").hasRole("INSTRUTOR")
                .requestMatchers("/alunos/**").hasAnyRole("ALUNO", "INSTRUTOR")
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
