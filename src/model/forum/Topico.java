package model.forum;

import model.Dev;

import java.util.Objects;

public class Topico extends Argumento{
    String nomeDoForum;

    public Topico(Dev dev, String texto, String nomeDoForum) {
        super(dev, texto);
        this.nomeDoForum = nomeDoForum;
    }

    public void exibir(){
        System.out.print(" [Tópico id(" + this.getId() + "): Dev: " + this.getDev().getNome());
        System.out.println(" > " + this.getTexto().toUpperCase() + "]");
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
        if (!(o instanceof Topico topico)) return false;
        return Objects.equals(nomeDoForum, topico.nomeDoForum);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nomeDoForum);
    }

 }
