import model.Bootcamp;
import model.Curso;
import model.Dev;
import model.Mentoria;
import model.forum.Forum;

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
        devJoao.setNome("Zé Systemson");
        devJoao.inscreverBootcamp(bootcampJavaDeveloper);
        System.out.println("Conteúdos Inscritos " + devJoao.getConteudosInscritos());
        devJoao.progredir();
        System.out.println("Conteúdos Concluídos " + devJoao.getConteudosConcluidos());
        System.out.println("Conteúdos Inscritos " + devJoao.getConteudosInscritos());
        System.out.println("XP: " + devJoao.calcularTotalXp());

        Dev devMaria = new Dev();
        devMaria.setNome("Ana Googlives");
        devMaria.inscreverBootcamp(bootcampJavaDeveloper);
        System.out.println("Conteúdos Inscritos " + devMaria.getConteudosInscritos());
        devMaria.progredir();
        System.out.println("Conteúdos Concluídos " + devMaria.getConteudosConcluidos());
        devMaria.progredir();
        System.out.println("Conteúdos Inscritos " + devMaria.getConteudosInscritos());
        System.out.println("XP: " + devMaria.calcularTotalXp());

        //Cada conteúdo pode possuir um fórum para as dúvidas dos participantes.
        //Fiz um package com as classes para o fórum.
        //Fórum do curso 1:
        Forum forumCursoJava = new Forum(cursoJava);
        forumCursoJava.listarTopicos();
        forumCursoJava.criarTopico(devMaria,"Métodos printf, print e println?", forumCursoJava.getNomeDoForum());
        forumCursoJava.criarTopico(devMaria, "Paradigma de Programação Orientada a Objetos em Java?", forumCursoJava.getNomeDoForum());
        forumCursoJava.criarTopico(devJoao, "Trabalhando com Collections", forumCursoJava.getNomeDoForum());
        forumCursoJava.criarTopico(devMaria, "Dominando IDE's Java", forumCursoJava.getNomeDoForum());
        forumCursoJava.criarTopico(devJoao, "Exercícios", forumCursoJava.getNomeDoForum());
        //Exibe o Fórum do Curso Java:
        forumCursoJava.listarTopicos();
        //responder um Topico:
        forumCursoJava.responderTopico(devMaria,"1", "O método System.out.println() gera uma string de texto, cria uma nova linha abaixo da atual e então posiciona o cursor nesta linha.");
        forumCursoJava.responderTopico(devJoao,"1","O método System.out.print() gera uma string de texto, porém diferentemente do método println, não cria uma nova linha abaixo da atual, deixando o cursor na mesma linha onde a string foi impressa.");
        forumCursoJava.responderTopico(devJoao,"2","Retorne objetos.");
        forumCursoJava.responderTopico(devJoao,"2","através de Arrays.");
        forumCursoJava.responderTopico(devJoao,"4","Dominando comandos do Eclipse.");
        forumCursoJava.responderTopico(devJoao,"4","IntelliJ.");
        forumCursoJava.responderTopico(devJoao,"5","Exercicio 1.");
        forumCursoJava.responderTopico(devJoao,"5","Exercicio 2.");

        //Mostrar a lista depois de uma resposta.
        forumCursoJava.listarTopicos();
        //Abrir um Tópico
        System.out.println("Abrir um Tópico");
        forumCursoJava.abrirTopico("1");

        //Réplicas.
        forumCursoJava.responderTopico(devJoao,"1.1","Uso muito o println.");
        forumCursoJava.responderTopico(devJoao,"4.5","Não sou ligado nessas paradas de astronomia.");
        //Mostra a lista depois das réplicas.
        forumCursoJava.listarTopicos();

    }

}


