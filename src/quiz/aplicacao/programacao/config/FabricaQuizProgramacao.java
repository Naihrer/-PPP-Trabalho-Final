package quiz.aplicacao.programacao.config;

import quiz.aplicacao.programacao.regras.PontuacaoAcertoSimples;
import quiz.aplicacao.programacao.ui.SwingQuizView;
import quiz.framework.core.GerenciadorPerguntas;
import quiz.framework.core.QuizFactory;
import quiz.framework.interfaces.EstrategiaPontuacao;
import quiz.framework.interfaces.QuizView;
import quiz.framework.modelo.Alternativa;
import quiz.framework.modelo.Pergunta;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class FabricaQuizProgramacao implements QuizFactory {

    @Override
    public QuizView criarView() {
        return new SwingQuizView();
    }

    @Override
    public EstrategiaPontuacao criarEstrategiaPontuacao() {
        return new PontuacaoAcertoSimples();
    }

    // Método auxiliar para criar a Pergunta com as alternativas já embaralhadas
    private Pergunta criarPerguntaRandomizada(String enunciado, Alternativa correta, Alternativa... incorretas) {
        List<Alternativa> listaAlts = new ArrayList<>();
        listaAlts.add(correta);
        listaAlts.addAll(Arrays.asList(incorretas));

        // Embaralha as alternativas
        Collections.shuffle(listaAlts);

        return new Pergunta(enunciado, listaAlts, correta);
    }

    @Override
    public GerenciadorPerguntas criarGerenciadorPerguntas() {
        List<Pergunta> perguntas = new ArrayList<>();

        // P1
        perguntas.add(criarPerguntaRandomizada(
                "Qual pilar da POO oculta os detalhes internos de implementação?",
                new Alternativa("Encapsulamento"), // Correta
                new Alternativa("Polimorfismo"),
                new Alternativa("Herança")
        ));

        // P2
        perguntas.add(criarPerguntaRandomizada(
                "Qual dos seguintes tipos de dados NÃO é primitivo em Java?",
                new Alternativa("String"), // Correta
                new Alternativa("int"),
                new Alternativa("boolean")
        ));

        // P3
        perguntas.add(criarPerguntaRandomizada(
                "Qual palavra-chave em Java impede que uma classe seja herdada?",
                new Alternativa("final"), // Correta
                new Alternativa("static"),
                new Alternativa("abstract")
        ));

        // P4
        perguntas.add(criarPerguntaRandomizada(
                "Qual conceito ocorre quando dois métodos na mesma classe possuem o mesmo nome, mas parâmetros diferentes?",
                new Alternativa("Sobrecarga (Overloading)"), // Correta
                new Alternativa("Sobrescrita (Overriding)"),
                new Alternativa("Abstração")
        ));

        // P5
        perguntas.add(criarPerguntaRandomizada(
                "Qual estrutura em Java garante o contrato de métodos sem poder ser instanciada diretamente?",
                new Alternativa("Interface"), // Correta
                new Alternativa("Classe Concreta"),
                new Alternativa("Enum")
        ));

        // P6
        perguntas.add(criarPerguntaRandomizada(
                "Qual componente da JVM é responsável por desalocar memória de objetos não utilizados?",
                new Alternativa("Garbage Collector"), // Correta
                new Alternativa("JVM Compiler"),
                new Alternativa("Thread Scheduler")
        ));

        // P7
        perguntas.add(criarPerguntaRandomizada(
                "Qual coleção do Java Collections Framework NÃO permite elementos duplicados?",
                new Alternativa("HashSet"), // Correta
                new Alternativa("ArrayList"),
                new Alternativa("LinkedList")
        ));

        // P8
        perguntas.add(criarPerguntaRandomizada(
                "Qual bloco de código é utilizado em Java para capturar e tratar exceções em tempo de execução?",
                new Alternativa("try-catch-finally"), // Correta
                new Alternativa("if-else"),
                new Alternativa("switch-case")
        ));

        // P9
        perguntas.add(criarPerguntaRandomizada(
                "A estrutura de dados Pilha (Stack) opera sob qual princípio?",
                new Alternativa("LIFO (Last In, First Out)"), // Correta
                new Alternativa("FIFO (First In, First Out)"),
                new Alternativa("Acesso Aleatório")
        ));

        // P10
        perguntas.add(criarPerguntaRandomizada(
                "Qual é a complexidade de tempo de pior caso do algoritmo de ordenação Bubble Sort?",
                new Alternativa("O(n^2)"), // Correta
                new Alternativa("O(1)"),
                new Alternativa("O(log n)")
        ));

        // Embaralha a ordem final das perguntas
        Collections.shuffle(perguntas);

        return new GerenciadorPerguntas(perguntas);
    }
}