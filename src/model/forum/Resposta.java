package model.forum;

import model.Dev;

import java.util.Objects;

/**
 * A classe resposta é uma extensão da classe Argumento,
 * para apontar para uma pergunta.
 */
public class Resposta extends Argumento{
    Argumento pergunta;

    /**
     *
     * @param dev a pessoa que cria a resposta.
     * @param  Pergunta o argumento que será respondido.
     */
    public Resposta(Dev dev, String texto, Argumento Pergunta) {
        super(dev, texto);
        this.pergunta = Pergunta;

    }

    public Argumento getPergunta() {
        return pergunta;
    }

    @Override
    public String toString() {
        return "Resposta{" +
                "pergunta='" + pergunta + '\'' +
                ", id='" + id + '\'' +
                ", dev=" + dev +
                ", texto='" + texto + '\'' +
                ", respostas=" + respostas +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Resposta resposta)) return false;
        if (!super.equals(o)) return false;
        return Objects.equals(pergunta, resposta.pergunta);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), pergunta);
    }
}
