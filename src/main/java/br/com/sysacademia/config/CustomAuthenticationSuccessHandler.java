package br.com.sysacademia.config;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class CustomAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
                                        Authentication authentication) throws IOException, ServletException {
        

        for (GrantedAuthority auth : authentication.getAuthorities()) {
            if ("ROLE_INSTRUTOR".equals(auth.getAuthority())) {
                response.sendRedirect("/instrutores/painel");
                return;
            } else if ("ROLE_ALUNO".equals(auth.getAuthority())) {
                response.sendRedirect("/alunos/painel");
                return;
            }
        }

        response.sendRedirect("/");
    }
}
