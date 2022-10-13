package model.forum;

import model.Dev;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public abstract class Argumento {
    private static int SEQUENCIA = 1;
    private static int SEQUENCIA_DE_RESPOSTA = 1;
    String id;
    Dev dev;
    String texto;
    Map<String, Argumento> respostas;

    public Argumento(Dev dev, String texto) {
        this.dev = dev;
        this.texto = texto;
        this.id = Integer.toString(SEQUENCIA++);
        this.respostas = new HashMap<>();
    }
    public String getId() {
        return id;
    }

    public String getTexto() {
        return texto;
    }
    public Dev getDev() {
        return dev;
    }
    public Map<String,Argumento> getRespostas() {
        return respostas;
    }

    public void responder(Resposta resposta) {
        Argumento pergunta = resposta.getPergunta();
        String idResposta = Integer.toString(SEQUENCIA_DE_RESPOSTA++);
        resposta.setId(pergunta.getId().concat(".").concat(idResposta));
        respostas.put(resposta.getId(), resposta);
    }
    public boolean existeResposta(){
        return !(this.getRespostas().isEmpty());
    }
    public Map<String,Argumento> listarRespostas(){
        Map<String, Argumento> listaDeRespostas = new HashMap<>();
        for(Map.Entry<String, Argumento> entrada : this.getRespostas().entrySet()){
            Argumento resposta = entrada.getValue();
            String nome = resposta.getDev().getNome() ;
            String id = entrada.getKey();
            String texto = entrada.getValue().getTexto();
            System.out.printf("\tResposta: Dev: " + nome +" [id(");
            System.out.println(id + "): " + texto + "]");
            //Se existirem 'sub-respostas'.
            if(resposta.existeResposta()){
                System.out.print("\t");
                resposta.listarRespostas();
            }
            listaDeRespostas.put(id, resposta);
        }
        return listaDeRespostas;
    }
    public void exibir(){

    }
    public void setId(String id) {
        this.id = id;
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
        if (!(o instanceof Argumento argumento)) return false;
        return Objects.equals(getId(), argumento.getId()) && Objects.equals(getDev(), argumento.getDev()) && Objects.equals(getTexto(), argumento.getTexto()) && Objects.equals(getRespostas(), argumento.getRespostas());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getDev(), getTexto(), getRespostas());
    }
}
