package quiz.framework.modelo;

public final class Resultado {
    private int acertos = 0;
    private int erros = 0;
    private int pontuacaoFinal = 0;

    public void registrarAcerto(int pontosGanhos) {
        acertos++;
        pontuacaoFinal += pontosGanhos;
    }

    public void registrarErro(int penalidade) {
        erros++;
        pontuacaoFinal -= penalidade;
    }

    public int getAcertos() { return acertos; }
    public int getErros() { return erros; }
    public int getPontuacaoFinal() { return pontuacaoFinal; }
}
