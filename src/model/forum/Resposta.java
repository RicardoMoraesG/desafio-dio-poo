package model.forum;

import model.Dev;

import java.util.Objects;

/**
 * A classe resposta é uma extensão da classe Argumento,
 * para apontar para uma pergunta.
 */
public class Resposta extends Argumento{
    int pergunta;

    /**
     *
     * @param dev a pessoa que cria a resposta.
     * @param idPergunta o id (identicador) da pergunta.
     */
    public Resposta(Dev dev, String texto, int idPergunta) {
        super(dev, texto);
        this.pergunta = idPergunta;
    }

    public int getPergunta() {
        return pergunta;
    }

    public void setPergunta(int pergunta) {
        this.pergunta = pergunta;
    }
    @Override
    public void listar(){
        for(Argumento argumento : this.getRespostas()){
            System.out.print("Dev: " + argumento.getDev().getNome());
            System.out.println(" [Resposta para : " + this.getPergunta() + argumento.getId() + " " + argumento.getTexto() + "]");
        }
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
        if (!(o instanceof Resposta)) return false;
        if (!super.equals(o)) return false;
        Resposta resposta = (Resposta) o;
        return Objects.equals(pergunta, resposta.pergunta);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), pergunta);
    }
}
