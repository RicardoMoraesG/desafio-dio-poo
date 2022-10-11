package model.forum;

import model.Conteudo;
import model.Dev;

import java.util.ArrayList;
import java.util.Objects;

public class Forum {
    ArrayList<Topico> topicos;
    Conteudo conteudo;
    String nomeDoForum;
    public Forum(Conteudo conteudo) {
        this.conteudo = conteudo;
        this.nomeDoForum = conteudo.getTitulo();
        this.topicos = new ArrayList<>();
    }
    public void listarTopicos(){
        for(Argumento argumento : this.getTopicos()){
            System.out.print("Dev: " + argumento.getDev().getNome());
            System.out.println(" [Tópico: " + argumento.getId() + " " + argumento.getTexto() + "]");
            if(argumento.getRespostas() != null){
                argumento.listar();
            }
        }
    }
    /**
     * Adiciona um novo tópico no Fórum.
     * @param dev - a pessoa que cria a pergunta.
     * @param nomeDoForum
     */
    public void criarTopico(Dev dev, String texto,String nomeDoForum) {
        Topico topico = new Topico(dev,texto,nomeDoForum);
        topicos.add(topico);
    }

    @Override
    public String toString() {
        return "Forum{" +
                "topicos=" + topicos +
                ", conteudo=" + conteudo +
                ", titulo='" + nomeDoForum + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Forum)) return false;
        Forum forum = (Forum) o;
        return Objects.equals(getTopicos(), forum.getTopicos()) && Objects.equals(getConteudo(), forum.getConteudo()) && Objects.equals(getNomeDoForum(), forum.getNomeDoForum());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getTopicos(), getConteudo(), getNomeDoForum());
    }

    public Conteudo getConteudo() {
        return conteudo;
    }

    public void setConteudo(Conteudo conteudo) {
        this.conteudo = conteudo;
    }

    public String getNomeDoForum() {
        return nomeDoForum;
    }

    public void setNomeDoForum(String nomeDoForum) {
        this.nomeDoForum = nomeDoForum;
    }

    public ArrayList<Topico> getTopicos() {
        return topicos;
    }

    public void setTopicos(ArrayList<Topico> topicos) {
        this.topicos = topicos;
    }

}
