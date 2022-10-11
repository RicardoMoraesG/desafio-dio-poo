import model.Bootcamp;
import model.Curso;
import model.Dev;
import model.Mentoria;
import model.forum.Forum;
import model.forum.Resposta;
import model.forum.Topico;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Curso cursoJava = new Curso();
        cursoJava.setTitulo("curso java");
        cursoJava.setDescricao("descrição curso java");
        cursoJava.setCargaHoraria(2);

        Curso cursoJS = new Curso();
        cursoJS.setTitulo("curso js");
        cursoJS.setDescricao("descrição curso js");
        cursoJS.setCargaHoraria(3);

        Curso cursoSpringBoot = new Curso();
        cursoSpringBoot.setTitulo("curso springBoot");
        cursoSpringBoot.setDescricao("descrição curso springBoot");
        cursoSpringBoot.setCargaHoraria(4);

        Mentoria mentoriaJava = new Mentoria();
        mentoriaJava.setTitulo("Mentoria de Java");
        mentoriaJava.setDescricao("Mentoria de Java");
        mentoriaJava.setData(LocalDate.now());

        Bootcamp bootcampJavaDeveloper = new Bootcamp();
        bootcampJavaDeveloper.setNome("Bootcamp Java Developer");
        bootcampJavaDeveloper.setDescricao("Descrição Bootcamp Java Developer");
        bootcampJavaDeveloper.getConteudos().add(cursoJava);
        bootcampJavaDeveloper.getConteudos().add(cursoJS);
        bootcampJavaDeveloper.getConteudos().add(mentoriaJava);

        Dev devJoao = new Dev();
        devJoao.setNome("João Devoto");
        devJoao.inscreverBootcamp(bootcampJavaDeveloper);
        System.out.println("Conteúdos Inscritos " + devJoao.getConteudosInscritos());
        devJoao.progredir();
        System.out.println("Conteúdos Concluídos " + devJoao.getConteudosConcluidos());
        System.out.println("Conteúdos Inscritos " + devJoao.getConteudosInscritos());
        System.out.println("XP: " + devJoao.calcularTotalXp());

        Dev devMaria = new Dev();
        devMaria.setNome("Maria Da Silva Santos");
        devMaria.inscreverBootcamp(bootcampJavaDeveloper);
        System.out.println("Conteúdos Inscritos " + devMaria.getConteudosInscritos());
        devMaria.progredir();
        System.out.println("Conteúdos Concluídos " + devMaria.getConteudosConcluidos());
        devMaria.progredir();
        System.out.println("Conteúdos Inscritos " + devMaria.getConteudosInscritos());
        System.out.println("XP: " + devMaria.calcularTotalXp());

        //Cada conteúdo pode possuir um fórum para as dúvidas dos participantes.
        //Fórum do curso 1:
        Forum forumCursoJava = new Forum(cursoJava);
        forumCursoJava.criarTopico(devMaria,"teste de id", forumCursoJava.getNomeDoForum());
        forumCursoJava.criarTopico(devMaria, "Como usar POO em Java?", forumCursoJava.getNomeDoForum());
        forumCursoJava.criarTopico(devJoao, "Collections", forumCursoJava.getNomeDoForum());
        //Resposta resposta = new Resposta(forumCursoJava);

        //Exibe o Fórum do Curso Java:
        System.out.println("**************Mostrar a lista de Tópicos:****************");
        forumCursoJava.listarTopicos();
        System.out.println("**************");

        //responder um Topico:
        int idPergunta = 2;
        for(Topico topico : forumCursoJava.getTopicos()){
            if(topico.getId() == idPergunta){
                topico.responder(new Resposta(devJoao, "Respondi o tópico 2...", idPergunta));
            }
        }
        //Mostrar a lista depois de uma resposta.
        System.out.println("**************Mostrar a lista depois uma resposta.****************");
        forumCursoJava.listarTopicos();
        System.out.println("**************");





    }

}


