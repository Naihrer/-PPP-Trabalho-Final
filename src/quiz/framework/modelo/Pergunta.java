package quiz.framework.modelo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// Pergunta de múltipla escolha: enunciado + alternativas + qual é a correta.
public final class Pergunta {

    private final String enunciado;
    private final List<Alternativa> alternativas;
    private final Alternativa alternativaCorreta;

    public Pergunta(String enunciado, List<Alternativa> alternativas, Alternativa alternativaCorreta) {
        if (enunciado == null || enunciado.isBlank()) {
            throw new IllegalArgumentException("O enunciado da pergunta não pode ser vazio.");
        }
        if (alternativas == null || alternativas.size() < 2) {
            throw new IllegalArgumentException("A pergunta deve ter pelo menos duas alternativas.");
        }
        if (alternativaCorreta == null || !alternativas.contains(alternativaCorreta)) {
            throw new IllegalArgumentException("A alternativa correta deve estar entre as alternativas informadas.");
        }

        this.enunciado = enunciado;
        this.alternativas = Collections.unmodifiableList(new ArrayList<>(alternativas));
        this.alternativaCorreta = alternativaCorreta;
    }

    public String getEnunciado() {
        return enunciado;
    }

    public List<Alternativa> getAlternativas() {
        return alternativas;
    }

    public Alternativa getAlternativaCorreta() {
        return alternativaCorreta;
    }

    public boolean isRespostaCorreta(Alternativa resposta) {
        return alternativaCorreta.equals(resposta);
    }

    @Override
    public String toString() {
        return enunciado;
    }
}
