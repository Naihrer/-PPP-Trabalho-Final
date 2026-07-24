package quiz.aplicacao.programacao.config;

import quiz.aplicacao.programacao.ui.RankingObserver;
import quiz.aplicacao.programacao.ui.RankingRepository;
import quiz.framework.core.FluxoQuizTemplate;
import quiz.framework.core.QuizFactory;

public class QuizProgramacao extends FluxoQuizTemplate {

    private final String nomeJogador;
    private final RankingRepository repository;

    public QuizProgramacao(String nomeJogador, RankingRepository repository) {
        this.nomeJogador = nomeJogador;
        this.repository = repository;
    }

    @Override
    protected void configurarDependencias() {
        QuizFactory fabrica = new FabricaQuizProgramacao();
        this.view = fabrica.criarView();
        this.estrategia = fabrica.criarEstrategiaPontuacao();
        this.gerenciador = fabrica.criarGerenciadorPerguntas();

        this.adicionarObserver(new RankingObserver(nomeJogador, repository));
    }
}