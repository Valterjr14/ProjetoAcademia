# SistemaAcademia
Sistema de Gestão para Academias

Este é um sistema web desenvolvido como projeto final da disciplina de Programação Orientada a Objetos, voltado para a gestão de academias.
A aplicação permite gerenciar alunos, instrutores, treinos, avaliações físicas e planos de matrícula, com áreas separadas para instrutores e alunos.

Padrões Utilizados

O sistema foi estruturado seguindo o padrão MVC (Model-View-Controller):
•    Model: representa os dados do sistema (aluno, instrutor, treino, etc.).
•    View: interface feita em Thymeleaf + HTML.
•    Controller: faz a ponte entre a interface e a lógica de negócio.
Além disso, aplicamos os padrões Repository e Service:
•    Repository: responsável por lidar com o banco de dados, centralizando as operações de CRUD e evitando a necessidade de escrever consultas SQL dentro do código da aplicação.
•    Service: concentra a lógica de negócio, permitindo que os controllers fiquem mais organizados e cuidem apenas das requisições.

Optamos por utilizar Repository e Service porque entendemos que esses padrões ajudam a manter o sistema mais claro e bem estruturado. Durante o desenvolvimento, percebemos que eles facilitam a divisão de responsabilidades e deixam o projeto mais limpo e até mais fácil de testar e manter.
