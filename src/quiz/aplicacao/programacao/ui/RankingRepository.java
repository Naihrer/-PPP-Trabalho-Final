package quiz.aplicacao.programacao.ui;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class RankingRepository {

    private final Map<String, Integer> rankingMap = new HashMap<>();

    public void adicionarOuAtualizarPontos(String nomeJogador, int pontos) {
        int pontosAtuais = rankingMap.getOrDefault(nomeJogador, 0);
        rankingMap.put(nomeJogador, pontosAtuais + pontos);
    }

    public int getPontosJogador(String nomeJogador) {
        return rankingMap.getOrDefault(nomeJogador, 0);
    }

    public Map<String, Integer> getRankingGlobal() {
        return Collections.unmodifiableMap(rankingMap);
    }
}