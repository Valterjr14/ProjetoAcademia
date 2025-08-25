package br.com.sysacademia.config;

import br.com.sysacademia.model.Exercicio;
import br.com.sysacademia.service.ExercicioService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.List;

@Configuration
public class DataInitializerConfig {

    @Bean
    CommandLineRunner initDatabase(ExercicioService exercicioService) {
        return args -> {
            List<String> nomesExercicios = Arrays.asList(
                "Supino Reto",
                "Crucifixo",
                "Agachamento Livre",
                "Levantamento Terra",
                "Remada Curvada",
                "Puxada Alta (Pulley)",
                "Desenvolvimento com Halteres",
                "Elevação Lateral",
                "Rosca Direta",
                "Tríceps na Polia",
                "Leg Press",
                "Cadeira Extensora",
                "Mesa Flexora",
                "Panturrilha em Pé"
            );

            if (exercicioService.listarTodos().isEmpty()) {
                 System.out.println("Cadastrando exercícios iniciais...");
                for (String nome : nomesExercicios) {
                    exercicioService.salvar(new Exercicio(nome));
                }
                System.out.println("Carga inicial de exercícios concluída.");
            } else {
                System.out.println("Exercícios já cadastrados. Carga inicial ignorada.");
            }
        };
    }
}
