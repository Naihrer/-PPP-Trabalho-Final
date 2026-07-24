package quiz.aplicacao.logica.regras;

import quiz.framework.interfaces.EstrategiaPontuacao;

public class PontuacaoComPenalidade implements EstrategiaPontuacao {

    @Override
    public int calcularPontosAcerto() {
        return 15;
    }

    @Override
    public int calcularPenalidadeErro() {
        return 5;
    }
}