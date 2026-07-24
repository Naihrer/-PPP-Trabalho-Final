package quiz.aplicacao.logica.config;

import quiz.framework.core.FluxoQuizTemplate;
import quiz.framework.core.QuizFactory;

public class QuizLogica extends FluxoQuizTemplate {

    @Override
    protected void configurarDependencias() {
        QuizFactory fabrica = new FabricaQuizLogica();
        this.view = fabrica.criarView();
        this.estrategia = fabrica.criarEstrategiaPontuacao();
        this.gerenciador = fabrica.criarGerenciadorPerguntas();
    }
}