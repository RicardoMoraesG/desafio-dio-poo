package model;

public class Curso extends Conteudo {
     private int cargaHoraria;

    public Curso() {
    }

    @Override
    public String toString() {
        return "Curso{" +
                this.getTitulo() +
                " cargaHoraria=" + cargaHoraria +
                '}';
    }

    @Override
    public double calcularXp() {
        return XP_PADRAO * cargaHoraria;
    }

    public int getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(int cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

}
