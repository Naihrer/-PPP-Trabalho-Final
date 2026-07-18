package quiz.framework.interfaces;

import quiz.framework.modelo.Alternativa;
import quiz.framework.modelo.Pergunta;

// Strategy da pontuação. Cada aplicação implementa sua regra
// (ex: +10 por acerto sem penalidade, ou com penalidade por erro).
public interface EstrategiaPontuacao {

    int calcularPontosAcerto(Pergunta pergunta);

    int calcularPenalidadeErro(Pergunta pergunta, Alternativa respostaEscolhida);
}
