package quiz.framework.core;

import quiz.framework.interfaces.EstrategiaPontuacao;
import quiz.framework.interfaces.QuizView;

public interface QuizFactory {
    QuizView criarView();
    EstrategiaPontuacao criarEstrategiaPontuacao();
    GerenciadorPerguntas criarGerenciadorPerguntas();
}
