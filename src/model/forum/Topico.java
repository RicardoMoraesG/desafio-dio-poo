package model.forum;

import model.Dev;

import java.util.Objects;

public class Topico extends Argumento{
    String nomeDoForum;

    public Topico(Dev dev, String texto, String nomeDoForum) {
        super(dev, texto);
        this.nomeDoForum = nomeDoForum;
    }
    @Override
    public void listar(){
        System.out.println("LISTA DE TÓPICOS " + this.nomeDoForum.toUpperCase());

        for(Argumento argumento : this.getRespostas()){
            System.out.print("Dev: " + argumento.getDev().getNome());
            System.out.println(" [Resposta para : " + argumento.getId() + " " + argumento.getTexto() + "]");
        }
    }
    @Override
    public String toString() {
        return "Topico{" +
                "nomeDoForum='" + nomeDoForum + '\'' +
                ", id='" + id + '\'' +
                ", dev=" + dev +
                ", texto='" + texto + '\'' +
                ", respostas=" + respostas +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Topico)) return false;
        Topico topico = (Topico) o;
        return Objects.equals(nomeDoForum, topico.nomeDoForum);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nomeDoForum);
    }

    public String getForum() {
        return nomeDoForum;
    }

    public void setForum(String forum) {
        this.nomeDoForum = forum;
    }
}
