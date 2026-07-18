package quiz.framework.modelo;

// Acumula o placar do jogador: acertos, erros e pontuação final.
// Quem calcula quanto vale cada acerto/erro é a EstrategiaPontuacao (Strategy).
public final class Resultado {

    private int acertos;
    private int erros;
    private int pontuacaoFinal;

    public void registrarAcerto(int pontosGanhos) {
        acertos++;
        pontuacaoFinal += pontosGanhos;
    }

    public void registrarErro(int penalidade) {
        erros++;
        pontuacaoFinal -= penalidade;
    }

    public int getAcertos() {
        return acertos;
    }

    public int getErros() {
        return erros;
    }

    public int getTotalRespondidas() {
        return acertos + erros;
    }

    public int getPontuacaoFinal() {
        return pontuacaoFinal;
    }

    @Override
    public String toString() {
        return String.format(
                "Resultado: %d acerto(s), %d erro(s), pontuação final = %d",
                acertos, erros, pontuacaoFinal
        );
    }
}
