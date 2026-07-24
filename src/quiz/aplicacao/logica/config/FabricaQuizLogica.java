package quiz.aplicacao.logica.config;

import quiz.aplicacao.logica.regras.PontuacaoComPenalidade;
import quiz.aplicacao.logica.ui.ConsoleQuizView;
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

public class FabricaQuizLogica implements QuizFactory {

    @Override
    public QuizView criarView() {
        return new ConsoleQuizView();
    }

    @Override
    public EstrategiaPontuacao criarEstrategiaPontuacao() {
        return new PontuacaoComPenalidade();
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
                "Se P é verdadeiro e Q é falso, o valor lógico da conjunção (P ^ Q) é:",
                new Alternativa("F (Falso)"), // Correta
                new Alternativa("V (Verdadeiro)")
        ));

        // P2
        perguntas.add(criarPerguntaRandomizada(
                "Qual conector resulta em Verdadeiro apenas quando exatamente uma das proposições for verdadeira?",
                new Alternativa("Disjunção Exclusiva (P XOR Q)"), // Correta
                new Alternativa("Bicondicional (P <-> Q)"),
                new Alternativa("Condicional (P -> Q)")
        ));

        // P3
        perguntas.add(criarPerguntaRandomizada(
                "Uma proposição composta que é SEMPRE verdadeira, independentemente das simples, é uma:",
                new Alternativa("Tautologia"), // Correta
                new Alternativa("Contradição"),
                new Alternativa("Contingência")
        ));

        // P4
        perguntas.add(criarPerguntaRandomizada(
                "Uma proposição composta que resulta em FALSO em todas as linhas de sua tabela-verdade é uma:",
                new Alternativa("Contradição"), // Correta
                new Alternativa("Tautologia"),
                new Alternativa("Equivalência")
        ));

        // P5
        perguntas.add(criarPerguntaRandomizada(
                "Na condicional (P -> Q), se o antecedente P for FALSO, qual é o valor lógico da condicional?",
                new Alternativa("Verdadeiro"), // Correta
                new Alternativa("Falso")
        ));

        // P6
        perguntas.add(criarPerguntaRandomizada(
                "Pelas Leis de De Morgan, qual é a negação lógica da conjunção ~(P ^ Q)?",
                new Alternativa("~P v ~Q"), // Correta
                new Alternativa("~P ^ ~Q"),
                new Alternativa("P v Q")
        ));

        // P7
        perguntas.add(criarPerguntaRandomizada(
                "Pelas Leis de De Morgan, qual é a negação lógica da disjunção ~(P v Q)?",
                new Alternativa("~P ^ ~Q"), // Correta
                new Alternativa("~P v ~Q"),
                new Alternativa("P ^ Q")
        ));

        // P8
        perguntas.add(criarPerguntaRandomizada(
                "Qual é a contrapositiva equivalente da condicional (P -> Q)?",
                new Alternativa("~Q -> ~P"), // Correta
                new Alternativa("Q -> P"),
                new Alternativa("~P -> ~Q")
        ));

        // P9
        perguntas.add(criarPerguntaRandomizada(
                "Quantas linhas possui a tabela-verdade de uma proposição composta contendo 3 proposições simples (P, Q, R)?",
                new Alternativa("8 linhas"), // Correta
                new Alternativa("4 linhas"),
                new Alternativa("16 linhas")
        ));

        // P10
        perguntas.add(criarPerguntaRandomizada(
                "Qual equivalência lógica é frequentemente usada para reescrever a condicional (P -> Q)?",
                new Alternativa("Negação (~) e Disjunção (v)"), // Correta
                new Alternativa("Apenas Negação (~)"),
                new Alternativa("Conjunção (^) e Disjunção (v)")
        ));

        // Embaralha a ordem final das perguntas
        Collections.shuffle(perguntas);

        return new GerenciadorPerguntas(perguntas);
    }
}