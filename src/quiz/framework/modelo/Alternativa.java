package quiz.framework.modelo;

import java.util.Objects;

// Representa uma alternativa de resposta de uma Pergunta.
public final class Alternativa {

    private final String texto;

    public Alternativa(String texto) {
        if (texto == null || texto.isBlank()) {
            throw new IllegalArgumentException("O texto da alternativa não pode ser vazio.");
        }
        this.texto = texto;
    }

    public String getTexto() {
        return texto;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Alternativa)) return false;
        Alternativa that = (Alternativa) o;
        return texto.equals(that.texto);
    }

    @Override
    public int hashCode() {
        return Objects.hash(texto);
    }

    @Override
    public String toString() {
        return texto;
    }
}
