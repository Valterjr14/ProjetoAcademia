package br.com.sysacademia.config;

import br.com.sysacademia.model.Exercicio;
import br.com.sysacademia.model.Plano;
import br.com.sysacademia.repository.ExercicioRepository;
import br.com.sysacademia.repository.PlanoRepository;
import br.com.sysacademia.service.ExercicioService;
import br.com.sysacademia.service.PlanoService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

@Configuration
public class DataInitializerConfig {

    @Bean
    CommandLineRunner initDatabase(ExercicioService exercicioService, PlanoRepository planoRepository) {
        return args -> {
    List<String> nomesExercicios = Arrays.asList(
        "Supino reto com barra",
        "Supino reto com halteres",
        "Supino inclinado com barra",
        "Supino inclinado com halteres",
        "Supino declinado com barra",
        "Supino declinado com halteres",
        "Crucifixo reto",
        "Crucifixo inclinado",
        "Peck deck",
        "Cross-over polia alta",
        "Cross-over polia média",
        "Cross-over polia baixa",
        "Flexão de braço",
        "Puxada alta frente",
        "Puxada alta costas",
        "Puxada supinada",
        "Remada baixa",
        "Remada curvada com barra",
        "Remada curvada com halteres",
        "Remada cavalinho (barra T)",
        "Barra fixa",
        "Pullover",
        "Levantamento terra",
        "Desenvolvimento militar com barra",
        "Desenvolvimento militar com halteres",
        "Desenvolvimento no Smith",
        "Elevação lateral",
        "Elevação frontal",
        "Encolhimento de ombros",
        "Remada alta",
        "Rosca direta",
        "Rosca alternada",
        "Rosca martelo",
        "Rosca concentrada",
        "Rosca scott",
        "Rosca 21",
        "Tríceps pulley barra",
        "Tríceps pulley corda",
        "Tríceps francês",
        "Tríceps testa",
        "Mergulho em paralelas",
        "Mergulho no banco",
        "Coice de tríceps",
        "Agachamento livre",
        "Agachamento no Smith",
        "Hack squat",
        "Agachamento búlgaro",
        "Sissy squat",
        "Leg press",
        "Afundo",
        "Cadeira extensora",
        "Stiff",
        "Levantamento terra romeno",
        "Mesa flexora deitado",
        "Mesa flexora sentado",
        "Mesa flexora em pé",
        "Bom dia",
        "Hip thrust",
        "Glute bridge",
        "Cadeira abdutora",
        "Abdução em 4 apoios",
        "Elevação de panturrilha em pé",
        "Elevação de panturrilha sentado",
        "Abdominal reto solo",
        "Abdominal na máquina",
        "Abdominal na bola",
        "Elevação de pernas",
        "Abdominal na cadeira romana",
        "Abdominal oblíquo",
        "Prancha frontal",
        "Prancha lateral",
        "Prancha instável",
        "Ab wheel",
        "Extensão lombar",
        "Glute ham raise",
        "Clean",
        "Clean and jerk",
        "Snatch",
        "Power clean",
        "Power snatch",
        "Overhead squat",
        "Deadlift convencional",
        "Deadlift sumô",
        "Deadlift romeno",
        "Front squat",
        "Back squat",
        "Thruster",
        "Push press",
        "Push jerk",
        "Split jerk",
        "Pull-up kipping",
        "Pull-up butterfly",
        "Chest-to-bar pull-up",
        "Muscle-up na barra",
        "Muscle-up nas argolas",
        "Toes-to-bar",
        "Handstand push-up",
        "Handstand walk",
        "Pistol squat",
        "Rope climb",
        "Ring dips",
        "Burpee",
        "Burpee over bar",
        "Burpee box jump",
        "Box jump",
        "Box jump step down",
        "Double unders",
        "Remo ergômetro",
        "Assault bike",
        "Echo bike",
        "Corrida curta distância",
        "Corrida longa distância",
        "Wall ball",
        "Kettlebell swing",
        "Kettlebell snatch",
        "Kettlebell clean and jerk",
        "Sled push",
        "Sled pull",
        "Farmer’s carry",
        "Suitcase carry"
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

            System.out.println("Verificando e cadastrando planos de matrícula...");
            if (planoRepository.count() == 0) {
                Plano mensal = new Plano("Plano Mensal", new BigDecimal("150.00"), 1);
                Plano trimestral = new Plano("Plano Trimestral", new BigDecimal("400.00"), 3);
                Plano anual = new Plano("Plano Anual", new BigDecimal("1700.00"), 12);

                planoRepository.saveAll(Arrays.asList(mensal, trimestral, anual));
                System.out.println("Planos iniciais cadastrados.");
            } else {
                System.out.println("Planos de matrícula já existem. Carga inicial ignorada.");
            }
        };
    }
}
