package quiz.aplicacao.programacao.ui;

import quiz.framework.interfaces.QuizView;
import quiz.framework.modelo.Alternativa;
import quiz.framework.modelo.Pergunta;
import quiz.framework.modelo.Resultado;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class SwingQuizView implements QuizView {

    @Override
    public void exibirMensagemInicial() {
        JOptionPane.showMessageDialog(
                null,
                "Bem-vindo ao Quiz de Programação em Java!\nClique em OK para começar.",
                "Quiz de Programação",
                JOptionPane.INFORMATION_MESSAGE
        );
    }

    @Override
    public void exibirPergunta(Pergunta pergunta) {
    }

    @Override
    public Alternativa obterResposta(Pergunta pergunta) {
        JDialog dialog = new JDialog((Frame) null, "Quiz de Programação", true);
        dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        dialog.setLayout(new BorderLayout(15, 15));

        // Enunciado da Pergunta
        JLabel labelEnunciado = new JLabel("<html><body style='width: 320px;'><b>" + pergunta.getEnunciado() + "</b></body></html>");
        labelEnunciado.setFont(new Font("SansSerif", Font.PLAIN, 14));
        labelEnunciado.setBorder(BorderFactory.createEmptyBorder(15, 15, 5, 15));
        dialog.add(labelEnunciado, BorderLayout.NORTH);

        // Painel das Alternativas 
        JPanel panelOpcoes = new JPanel();
        panelOpcoes.setLayout(new BoxLayout(panelOpcoes, BoxLayout.Y_AXIS));
        panelOpcoes.setBorder(BorderFactory.createEmptyBorder(5, 20, 10, 20));

        ButtonGroup group = new ButtonGroup();
        List<Alternativa> alternativas = pergunta.getAlternativas();
        JRadioButton[] radioButtons = new JRadioButton[alternativas.size()];

        for (int i = 0; i < alternativas.size(); i++) {
            radioButtons[i] = new JRadioButton(alternativas.get(i).getTexto());
            radioButtons[i].setFont(new Font("SansSerif", Font.PLAIN, 13));
            group.add(radioButtons[i]);
            panelOpcoes.add(radioButtons[i]);
            panelOpcoes.add(Box.createRigidArea(new Dimension(0, 5)));
        }

        // Seleciona a primeira por padrão
        if (radioButtons.length > 0) {
            radioButtons[0].setSelected(true);
        }

        dialog.add(panelOpcoes, BorderLayout.CENTER);

        // Botão de Confirmaçao
        final Alternativa[] respostaEscolhida = new Alternativa[1];
        JButton btnConfirmar = new JButton("Confirmar Resposta");
        btnConfirmar.setFont(new Font("SansSerif", Font.BOLD, 12));
        btnConfirmar.addActionListener(e -> {
            for (int i = 0; i < radioButtons.length; i++) {
                if (radioButtons[i].isSelected()) {
                    respostaEscolhida[0] = alternativas.get(i);
                    break;
                }
            }
            dialog.dispose();
        });

        JPanel panelBotao = new JPanel();
        panelBotao.setBorder(BorderFactory.createEmptyBorder(0, 0, 15, 0));
        panelBotao.add(btnConfirmar);
        dialog.add(panelBotao, BorderLayout.SOUTH);

        // Ajusta tamanho e centraliza na tela
        dialog.pack();
        dialog.setLocationRelativeTo(null);
        dialog.setMinimumSize(new Dimension(400, 250));
        dialog.setVisible(true);

        return respostaEscolhida[0];
    }

    @Override
    public void exibirFeedback(boolean acertou, Alternativa correta) {
        if (acertou) {
            JOptionPane.showMessageDialog(
                    null,
                    "Resposta Correta!",
                    "Resultado",
                    JOptionPane.INFORMATION_MESSAGE
            );
        } else {
            JOptionPane.showMessageDialog(
                    null,
                    "Resposta Incorreta!\nA resposta certa era: " + correta.getTexto(),
                    "Resultado",
                    JOptionPane.ERROR_MESSAGE
            );
        }
    }

    @Override
    public void exibirResultadoFinal(Resultado resultado) {
        String mensagem = String.format(
                "Fim das suas perguntas!\n\nAcertos: %d\nErros: %d\nSua Pontuação: %d pontos",
                resultado.getAcertos(), resultado.getErros(), resultado.getPontuacaoFinal()
        );

        JOptionPane.showMessageDialog(
                null,
                mensagem,
                "Resultado do Turno",
                JOptionPane.INFORMATION_MESSAGE
        );
    }
}
