import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Curso curso1 = new Curso();
        curso1.setTitulo("curso java");
        curso1.setDescricao("descrição curso java");
        curso1.setCargaHoraria(2);

        Curso curso2 = new Curso();
        curso2.setTitulo("curso js");
        curso2.setDescricao("descrição curso js");
        curso2.setCargaHoraria(3);

        Curso curso3 = new Curso();
        curso3.setTitulo("curso springBoot");
        curso3.setDescricao("descrição curso springBoot");
        curso3.setCargaHoraria(4);


        Mentoria mentoria = new Mentoria();
        mentoria.setTitulo("Mentoria de Java");
        mentoria.setDescricao("Mentoria de Java");
        mentoria.setData(LocalDate.now());

/*
        System.out.println(curso1);
        System.out.println(curso2);
        System.out.println(curso3);
*/
        Bootcamp bootcamp = new Bootcamp();
        bootcamp.setNome("Bootcamp Java Developer");
        bootcamp.setDescricao("Descrição Bootcamp Java Developer");
        bootcamp.getConteudos().add(curso1);
        bootcamp.getConteudos().add(curso2);
        bootcamp.getConteudos().add(mentoria);

        Dev devJoao = new Dev();
        devJoao.setNome("João");
        devJoao.inscreverBootcamp(bootcamp);
        System.out.println("Conteúdos Inscritos " + devJoao.getConteudosInscritos());
        devJoao.progredir();
        System.out.println("Conteúdos Concluídos " + devJoao.getConteudosConcluidos());
        System.out.println("Conteúdos Inscritos " + devJoao.getConteudosInscritos());
        System.out.println("XP: " + devJoao.calcularTotalXp());
        Dev devCamila = new Dev();
        devCamila.setNome("Camila");
        devCamila.inscreverBootcamp(bootcamp);
        System.out.println("Conteúdos Inscritos " + devCamila.getConteudosInscritos());
        devCamila.progredir();
        System.out.println("Conteúdos Concluídos " + devCamila.getConteudosConcluidos());
        devCamila.progredir();
        System.out.println("Conteúdos Inscritos " + devCamila.getConteudosInscritos());

        System.out.println("XP: " + devCamila.calcularTotalXp());



    }
}