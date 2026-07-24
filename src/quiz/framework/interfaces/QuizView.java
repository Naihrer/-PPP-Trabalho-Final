package quiz.framework.interfaces;

import quiz.framework.modelo.Alternativa;
import quiz.framework.modelo.Pergunta;
import quiz.framework.modelo.Resultado;

public interface QuizView {
    void exibirMensagemInicial();
    void exibirPergunta(Pergunta pergunta);
    Alternativa obterResposta(Pergunta pergunta);
    void exibirFeedback(boolean acertou, Alternativa correta);
    void exibirResultadoFinal(Resultado resultado);
}
