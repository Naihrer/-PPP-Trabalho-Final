package quiz.aplicacao.programacao.regras;

import quiz.framework.interfaces.EstrategiaPontuacao;

public class PontuacaoAcertoSimples implements EstrategiaPontuacao {
    @Override
    public int calcularPontosAcerto() { return 10; }

    @Override
    public int calcularPenalidadeErro() { return 0; }
}
