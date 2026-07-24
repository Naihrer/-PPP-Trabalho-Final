package quiz.framework.core;

import quiz.framework.modelo.Pergunta;
import java.util.List;

public class GerenciadorPerguntas {
    private final List<Pergunta> perguntas;

    public GerenciadorPerguntas(List<Pergunta> perguntas) {
        this.perguntas = perguntas;
    }

    public List<Pergunta> getPerguntas() { return perguntas; }
}
