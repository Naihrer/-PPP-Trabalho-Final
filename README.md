# Framework de Quiz Orientado a Objetos

Este projeto é um framework extensível e reutilizável para criação de jogos de Quiz, desenvolvido para a disciplina de Princípios e Padrões de Projetos (PPP). O sistema foi projetado com foco em forte desacoplamento, separando a engine principal (regras de fluxo) das camadas de apresentação (UI) e regras de negócio.

---

## Arquitetura e Padrões de Projeto

O framework centraliza a execução do quiz, enquanto as aplicações concretas definem o comportamento específico. Os seguintes Padrões de Projeto (GoF) foram implementados:

*   **Template Method (`FluxoQuizTemplate`):** Define o esqueleto do algoritmo do jogo (iniciar, iterar sobre perguntas, calcular pontos, notificar observers e exibir resultado). As subclasses apenas configuram os ganchos de dependência.
*   **Strategy (`EstrategiaPontuacao`):** Isola o cálculo de pontuação. Permite plugar regras diferentes (ex: pontuação simples vs. pontuação com penalidade por erro) sem alterar o núcleo do jogo.
*   **Abstract Factory (`QuizFactory`):** Centraliza e encapsula a criação das famílias de objetos relacionados (View, Strategy e Gerenciador de Perguntas) para cada aplicação específica.
*   **Observer (`QuizObserver`):** Estabelece uma relação de publicação-assinatura. Permite monitorar eventos da partida (início, respostas, fim) em tempo real, possibilitando sistemas de Ranking sem acoplar o placar à lógica do Quiz.

Além dos padrões clássicos, o projeto aplica os princípios do **SOLID**, com destaque para a Inversão de Dependência (DIP) por meio da injeção do repositório de dados (`RankingRepository`) nos observadores, eliminando estados globais estáticos.

---

## Aplicações Desenvolvidas

Para provar a flexibilidade do framework, foram construídas duas aplicações distintas rodando sobre a mesma engine:

### 1. Quiz de Programação Java (Multiplayer)
*   **Interface:** Gráfica (Java Swing).
*   **Regra de Pontos:** Acerto Simples (+10 pontos / 0 penalidade).
*   **Diferenciais:**
    *   Sistema de Lobby Multiplayer gerenciando troca de turnos.
    *   Sistema automático de Rodadas de Desempate (Morte Súbita) em caso de empate na liderança.
    *   Observer integrado para imprimir o Ranking Global de todos os jogadores no console do servidor.

### 2. Quiz de Lógica Proposicional
*   **Interface:** Terminal / Console (Scanner/System.out).
*   **Regra de Pontos:** Com Penalidade (+15 pontos / -5 penalidade).
*   **Diferenciais:** Focado em treinamento individual de rápido acesso e execução direta via console.

---

## Como Executar

Certifique-se de ter o Java JDK (versão 8 ou superior) instalado em sua máquina.

**Para jogar o Quiz de Programação (Swing + Multiplayer):**
1. Navegue até a classe `MainProgramacao`.
2. Caminho: `src/quiz/aplicacao/programacao/config/MainProgramacao.java`
3. Execute o método principal (`main`).

**Para jogar o Quiz de Lógica (Terminal):**
1. Navegue até a classe `MainLogica`.
2. Caminho: `src/quiz/aplicacao/logica/config/MainLogica.java`
3. Execute o método principal (`main`) e siga as instruções no console.

---

## Autores

*   Rhian
*   Angelo
