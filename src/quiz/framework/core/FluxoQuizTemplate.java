package quiz.framework.core;

import quiz.framework.interfaces.EstrategiaPontuacao;
import quiz.framework.interfaces.QuizObserver;
import quiz.framework.interfaces.QuizView;
import quiz.framework.modelo.Alternativa;
import quiz.framework.modelo.Pergunta;
import quiz.framework.modelo.Resultado;

import java.util.ArrayList;
import java.util.List;

public abstract class FluxoQuizTemplate {
    protected QuizView view;
    protected EstrategiaPontuacao estrategia;
    protected GerenciadorPerguntas gerenciador;
    protected Resultado resultado;

    // Lista de Observers cadastrados
    private final List<QuizObserver> observers = new ArrayList<>();

    public void adicionarObserver(QuizObserver observer) {
        if (observer != null && !observers.contains(observer)) {
            observers.add(observer);
        }
    }

    public void removerObserver(QuizObserver observer) {
        observers.remove(observer);
    }

    private void notificarInicio() {
        for (QuizObserver obs : observers) {
            obs.aoIniciarQuiz();
        }
    }

    private void notificarResposta(Pergunta pergunta, boolean acertou, int pontos) {
        for (QuizObserver obs : observers) {
            obs.aoResponderPergunta(pergunta, acertou, pontos);
        }
    }

    private void notificarFim(Resultado resultado) {
        for (QuizObserver obs : observers) {
            obs.aoFinalizarQuiz(resultado);
        }
    }

    // Método Template
    public final void executarQuiz() {
        configurarDependencias();
        resultado = new Resultado();

        notificarInicio();
        view.exibirMensagemInicial();

        for (Pergunta pergunta : gerenciador.getPerguntas()) {
            view.exibirPergunta(pergunta);
            Alternativa respostaSelecionada = view.obterResposta(pergunta);

            if (respostaSelecionada == null) continue;

            boolean acertou = pergunta.isRespostaCorreta(respostaSelecionada);
            int pontosVariacao = 0;

            if (acertou) {
                pontosVariacao = estrategia.calcularPontosAcerto();
                resultado.registrarAcerto(pontosVariacao);
            } else {
                pontosVariacao = -estrategia.calcularPenalidadeErro();
                resultado.registrarErro(estrategia.calcularPenalidadeErro());
            }

            // Notifica todos os observadores cadastrados
            notificarResposta(pergunta, acertou, pontosVariacao);
            view.exibirFeedback(acertou, pergunta.getAlternativaCorreta());
        }

        notificarFim(resultado);
        view.exibirResultadoFinal(resultado);
    }

    protected abstract void configurarDependencias();
}