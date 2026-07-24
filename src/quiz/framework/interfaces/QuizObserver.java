package quiz.framework.interfaces;

import quiz.framework.modelo.Pergunta;
import quiz.framework.modelo.Resultado;

public interface QuizObserver {
    void aoIniciarQuiz();
    void aoResponderPergunta(Pergunta pergunta, boolean acertou, int pontosObtidos);
    void aoFinalizarQuiz(Resultado resultado);
}