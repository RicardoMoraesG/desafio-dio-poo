package model.forum;

import model.Conteudo;
import model.Dev;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Forum {
    Map<String,Argumento> listaDetopicos;
    Conteudo conteudo;
    String nomeDoForum;
    public Forum(Conteudo conteudo) {
        this.conteudo = conteudo;
        this.nomeDoForum = conteudo.getTitulo();
        this.listaDetopicos = new HashMap<>();
    }

   public void abrirTopico(String idDoTopico) {
        for(Map.Entry<String, Argumento> entrada: this.getTopicos().entrySet()){
            if(entrada.getKey().equals(idDoTopico)){
                Argumento topico =  entrada.getValue();
                System.out.print("\nVocê está em ");
                topico.exibir();
            }
        }
   }


    public void listarTopicos(){
        System.out.println();
        System.out.println("Bem vindo(a)! Você está no fórum " + this.getNomeDoForum().toUpperCase());
        System.out.println("LISTA DE TÓPICOS");
        for(Map.Entry<String, Argumento> valor : this.getTopicos().entrySet()){
            Argumento topico = valor.getValue();
            topico.exibir();
            if(topico.existeResposta())
                topico.listarRespostas();
        }
    }
    public void responderTopico(Dev dev, String id, String resposta){
       if (id.contains(".")) {
       //O "id" dos topicos não contém "." então
       //não vai responder o tópico, mas fazer uma réplica a uma resposta.
           //A primeira parte desse "id" aponta a pergunta.
            String idPergunta = id.substring(0,id.lastIndexOf("."));
           for(Map.Entry<String, Argumento> topico: this.getTopicos().entrySet()){
               if(topico.getKey().equals(idPergunta)){ //Pega o objeto pergunta para passar como argumento.
                   Map<String, Argumento> listaDeRespostasDoTopico = topico.getValue().listarRespostas();
                   for(Map.Entry<String,Argumento> subTopico : listaDeRespostasDoTopico.entrySet()){
                       //achar o subtopico
                       if(subTopico.getKey().equals(id)) {
                           //responder o subtopico.
                           subTopico.getValue().responder(new Resposta(dev, resposta, subTopico.getValue()));
                       }
                   }
               }
           }
       }   else {
                //Responder um tópico:
                for(Map.Entry<String, Argumento> entrada: this.getTopicos().entrySet()){
                      if(entrada.getKey().equals(id)){
                         entrada.getValue().responder(new Resposta(dev, resposta, entrada.getValue()));
                      }
                }
       }
    }

    /**
     * Adiciona um novo tópico no Fórum.
     * @param dev - a pessoa que cria a pergunta.
     */
    public void criarTopico(Dev dev, String texto,String nomeDoForum) {
        Topico topico = new Topico(dev,texto,nomeDoForum);
        listaDetopicos.put(topico.getId(), topico);
    }

    @Override
    public String toString() {
        return "Forum{" +
                "topicos=" + listaDetopicos +
                ", conteudo=" + conteudo +
                ", titulo='" + nomeDoForum + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Forum forum)) return false;
        return Objects.equals(getTopicos(), forum.getTopicos()) && Objects.equals(getConteudo(), forum.getConteudo()) && Objects.equals(getNomeDoForum(), forum.getNomeDoForum());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getTopicos(), getConteudo(), getNomeDoForum());
    }

    public Conteudo getConteudo() {
        return conteudo;
    }
    public String getNomeDoForum() {
        return nomeDoForum;
    }
    public Map<String, Argumento> getTopicos() {
        return listaDetopicos;
    }
}
