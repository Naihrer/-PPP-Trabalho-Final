package quiz.framework.modelo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class Pergunta {
    private final String enunciado;
    private final List<Alternativa> alternativas;
    private final Alternativa alternativaCorreta;

    public Pergunta(String enunciado, List<Alternativa> alternativas, Alternativa alternativaCorreta) {
        this.enunciado = enunciado;
        this.alternativas = Collections.unmodifiableList(new ArrayList<>(alternativas));
        this.alternativaCorreta = alternativaCorreta;
    }

    public String getEnunciado() { return enunciado; }
    public List<Alternativa> getAlternativas() { return alternativas; }
    public Alternativa getAlternativaCorreta() { return alternativaCorreta; }

    public boolean isRespostaCorreta(Alternativa resposta) {
        return alternativaCorreta.equals(resposta);
    }
}
