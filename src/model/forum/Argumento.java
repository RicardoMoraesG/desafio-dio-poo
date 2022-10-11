package model.forum;

import model.Dev;

import java.util.ArrayList;
import java.util.Objects;

public abstract class Argumento {
    private static int sequence = 1;
    int id;
    Dev dev;
    String texto;
    ArrayList<Argumento> respostas;

    public Argumento(Dev dev, String texto) {
        this.dev = dev;
        this.texto = texto;
        this.id = sequence++;
        this.respostas = new ArrayList<>();
    }

    /**
     *
     * @return String composta pelo nome do usuário
     * que criou o argumento + a data em que foi gerado.
     */

    public int getId() {
        return id;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public void setRespostas(ArrayList<Argumento> respostas) {
        this.respostas = respostas;
    }

    public Dev getDev() {
        return dev;
    }

    public void setDev(Dev dev) {
        this.dev = dev;
    }

    public ArrayList<Argumento> getRespostas() {
        return respostas;
    }


    public void responder(Resposta resposta) {

        respostas.add(resposta);
    }
    public void listar(){

    }



    @Override
    public String toString() {
        return "Argumento{" +
                "id='" + id + '\'' +
                ", dev=" + dev +
                ", texto='" + texto + '\'' +
                ", respostas=" + respostas +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Argumento)) return false;
        Argumento argumento = (Argumento) o;
        return Objects.equals(getId(), argumento.getId()) && Objects.equals(getDev(), argumento.getDev()) && Objects.equals(getTexto(), argumento.getTexto()) && Objects.equals(getRespostas(), argumento.getRespostas());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getDev(), getTexto(), getRespostas());
    }
}
