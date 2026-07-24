package quiz.aplicacao.programacao.ui;

import quiz.framework.interfaces.QuizObserver;
import quiz.framework.modelo.Pergunta;
import quiz.framework.modelo.Resultado;

import java.util.Map;

public class RankingObserver implements QuizObserver {

    private final String nomeJogador;
    private final RankingRepository rankingRepository; // Dependência Injetada

    public RankingObserver(String nomeJogador, RankingRepository rankingRepository) {
        this.nomeJogador = nomeJogador;
        this.rankingRepository = rankingRepository;
        this.rankingRepository.adicionarOuAtualizarPontos(nomeJogador, 0);
    }

    @Override
    public void aoIniciarQuiz() {
        System.out.println("[SISTEMA] " + nomeJogador + " iniciou o Quiz!");
    }

    @Override
    public void aoResponderPergunta(Pergunta pergunta, boolean acertou, int pontosObtidos) {
        rankingRepository.adicionarOuAtualizarPontos(nomeJogador, pontosObtidos);
        int pontosTotais = rankingRepository.getPontosJogador(nomeJogador);

        System.out.printf("[SISTEMA] %s %s! (Pontos Totais: %d)\n",
                nomeJogador, (acertou ? "acertou" : "errou"), pontosTotais);
    }

    @Override
    public void aoFinalizarQuiz(Resultado resultado) {
        System.out.println("\n===========================");
        System.out.println("    RANKING MULTIPLAYER    ");
        System.out.println("===========================");
        for (Map.Entry<String, Integer> entry : rankingRepository.getRankingGlobal().entrySet()) {
            System.out.println("-> " + entry.getKey() + ": " + entry.getValue() + " pontos");
        }
        System.out.println("===========================\n");
    }
}