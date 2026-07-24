package quiz.aplicacao.programacao.config;

import quiz.aplicacao.programacao.ui.RankingRepository;

import javax.swing.JOptionPane;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class LobbyMultiplayer {

    private final RankingRepository rankingRepository = new RankingRepository();

    public void iniciarJogo() {
        // 1. Configuração de Jogadores
        String qtdStr = JOptionPane.showInputDialog(
                null,
                "Bem-vindo ao Multiplayer!\nQuantos jogadores vão participar?",
                "Configuração do Quiz",
                JOptionPane.QUESTION_MESSAGE
        );

        if (qtdStr == null || qtdStr.trim().isEmpty()) {
            System.exit(0);
        }

        int qtdJogadores = 1;
        try {
            qtdJogadores = Integer.parseInt(qtdStr);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Número inválido. Iniciando com 1 jogador.");
        }

        List<String> nomes = new ArrayList<>();
        for (int i = 1; i <= qtdJogadores; i++) {
            String nome = JOptionPane.showInputDialog(
                    null,
                    "Digite o nome do Jogador " + i + ":",
                    "Registro de Jogadores",
                    JOptionPane.QUESTION_MESSAGE
            );

            if (nome == null || nome.trim().isEmpty()) {
                nome = "Jogador " + i;
            }
            nomes.add(nome);
        }

        // 2. Rodada Regular
        for (int i = 0; i < nomes.size(); i++) {
            String jogadorAtual = nomes.get(i);

            JOptionPane.showMessageDialog(
                    null,
                    "Vez do jogador: " + jogadorAtual + "!\nClique em OK quando estiver pronto.",
                    "Troca de Turno",
                    JOptionPane.INFORMATION_MESSAGE
            );

            QuizProgramacao app = new QuizProgramacao(jogadorAtual, rankingRepository);
            app.executarQuiz();

            if (i < nomes.size() - 1) {
                JOptionPane.showMessageDialog(
                        null,
                        "Turno de " + jogadorAtual + " encerrado!\nChame o próximo jogador.",
                        "Fim de Turno",
                        JOptionPane.WARNING_MESSAGE
                );
            }
        }

        // 3. Verificação de Empates e Desempate
        if (nomes.size() > 1) {
            verificarETratarDesempate();
        } else {
            String campeao = nomes.get(0);
            int pontos = rankingRepository.getPontosJogador(campeao);
            exibirCampeao(campeao, pontos);
        }

        System.exit(0);
    }

    private void verificarETratarDesempate() {
        boolean haEmpate = true;
        int rodadaDesempate = 1;

        while (haEmpate) {
            Map<String, Integer> ranking = rankingRepository.getRankingGlobal();

            // Encontra a pontuação máxima atual
            int maiorPontuacao = Integer.MIN_VALUE;
            for (int pontos : ranking.values()) {
                if (pontos > maiorPontuacao) {
                    maiorPontuacao = pontos;
                }
            }

            // Descobre quais jogadores estão empatados com a pontuação maxima
            List<String> empatados = new ArrayList<>();
            for (Map.Entry<String, Integer> entry : ranking.entrySet()) {
                if (entry.getValue() == maiorPontuacao) {
                    empatados.add(entry.getKey());
                }
            }

            // Se apenas 1 pessoa tem a maior pontuação, eh o campeao
            if (empatados.size() == 1) {
                haEmpate = false;
                exibirCampeao(empatados.get(0), maiorPontuacao);
            } else {
                // Notifica a rodada de desempate
                JOptionPane.showMessageDialog(
                        null,
                        " EMPATE DETECTADO! \n\nJogadores empatados na liderança (" + maiorPontuacao + " pts): "
                                + String.join(", ", empatados) +
                                "\nIniciando Rodada Extra de Desempate #" + rodadaDesempate + "!",
                        "DESEMPATE!",
                        JOptionPane.WARNING_MESSAGE
                );

                // Cada jogador empatado joga mais uma partida para tentar desempatar
                for (String jogador : empatados) {
                    JOptionPane.showMessageDialog(
                            null,
                            "RODADA EXTRA!\nVez do jogador: " + jogador,
                            "Desempate #" + rodadaDesempate,
                            JOptionPane.INFORMATION_MESSAGE
                    );

                    QuizProgramacao appDesempate = new QuizProgramacao(jogador, rankingRepository);
                    appDesempate.executarQuiz();
                }

                rodadaDesempate++;
            }
        }
    }

    private void exibirCampeao(String nomeCampeao, int pontos) {
        String mensagem = String.format(
                " TROFÉU DE CAMPEÃO \n\n" +
                        "O grande vencedor do Quiz é:\n" +
                        " %s \n\n" +
                        "Pontuação Final: %d pontos!\n" +
                        "Parabéns!",
                nomeCampeao, pontos
        );

        JOptionPane.showMessageDialog(
                null,
                mensagem,
                "Fim do Jogo - Campeão!",
                JOptionPane.INFORMATION_MESSAGE
        );
    }
}