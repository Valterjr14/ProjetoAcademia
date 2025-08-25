package br.com.sysacademia.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

//Controlador para gerenciar páginas
@Controller /* Indica que esta classe é um controlador do Spring */
public class PageController {

    //Página de login
    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }

    //Página de sucesso
    @GetMapping("/sucesso")
    public String sucessoPage() {
        return "sucesso";
    }
}