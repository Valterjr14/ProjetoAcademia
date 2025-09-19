package br.com.sysacademia.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/recepcionista")
public class RecepcionistaController {

    @GetMapping("/painel")
    public String painelRecepcionista() {
        return "recepcionista/painel";
    }
    
    
}
