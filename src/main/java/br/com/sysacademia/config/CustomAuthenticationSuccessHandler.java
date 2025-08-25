package br.com.sysacademia.config;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;
import java.io.IOException;

//Manipulador de sucesso de autenticação personalizado
@Component  /*Anotação que indica que esta classe é um componente do Spring*/
public class CustomAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

    //Método chamado quando a autenticação é bem-sucedida
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
                                        Authentication authentication) throws IOException, ServletException {

        //Redireciona o usuário com base em seu papel
        for (GrantedAuthority auth : authentication.getAuthorities()) {
            //Verifica se o usuário é um instrutor
            if ("ROLE_INSTRUTOR".equals(auth.getAuthority())) {
                response.sendRedirect("/instrutores/painel");
                return;
            } else if ("ROLE_ALUNO".equals(auth.getAuthority())) {  /* Verifica se o usuário é um aluno */
                response.sendRedirect("/alunos/painel");
                return;
            }
        }

        response.sendRedirect("/"); // Redireciona para a página inicial
    }
}
