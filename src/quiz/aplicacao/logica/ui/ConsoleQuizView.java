package quiz.aplicacao.logica.ui;

import quiz.framework.interfaces.QuizView;
import quiz.framework.modelo.Alternativa;
import quiz.framework.modelo.Pergunta;
import quiz.framework.modelo.Resultado;
import java.util.List;
import java.util.Scanner;

public class ConsoleQuizView implements QuizView {
    private final Scanner scanner = new Scanner(System.in);

    public void mostrarMensagem(String mensagem) {
        System.out.println(mensagem);
    }

    public void fechar() {
        if (scanner != null) {
            scanner.close();
        }
    }

    @Override
    public void exibirMensagemInicial() {
        System.out.println("=========================================");
        System.out.println(" Quiz de Lógica Proposicional (Terminal)");
        System.out.println("=========================================");
    }

    @Override
    public void exibirPergunta(Pergunta pergunta) {
        System.out.println("\nPergunta: " + pergunta.getEnunciado());
        List<Alternativa> alts = pergunta.getAlternativas();
        for (int i = 0; i < alts.size(); i++) {
            System.out.println((i + 1) + ") " + alts.get(i).getTexto());
        }
    }

    @Override
    public Alternativa obterResposta(Pergunta pergunta) {
        System.out.print("Sua resposta (número): ");
        int escolha = scanner.nextInt();
        return pergunta.getAlternativas().get(escolha - 1);
    }

    @Override
    public void exibirFeedback(boolean acertou, Alternativa correta) {
        if (acertou) {
            System.out.println("[RESULTADO] Acertou!");
        } else {
            System.out.println("[RESULTADO] Errou! A correta era: " + correta.getTexto());
        }
    }

    @Override
    public void exibirResultadoFinal(Resultado resultado) {
        System.out.println("\n=========================================");
        System.out.println("            RESULTADO FINAL              ");
        System.out.println("=========================================");
        System.out.println("Acertos: " + resultado.getAcertos());
        System.out.println("Erros: " + resultado.getErros());
        System.out.println("Pontuação Final: " + resultado.getPontuacaoFinal());
        System.out.println("=========================================");

        System.out.println("\nDeseja jogar novamente?");
        System.out.println("1 - Sim");
        System.out.println("2 - Sair");
        System.out.print("Escolha uma opção: ");

        int opcao = scanner.nextInt();

        if (opcao == 1) {
            // Reinicia o quiz no console
            new quiz.aplicacao.logica.config.QuizLogica().executarQuiz();
        } else {
            System.out.println("\nObrigado por jogar! Até a próxima.");
            fechar();
            System.exit(0);
        }
    }
}