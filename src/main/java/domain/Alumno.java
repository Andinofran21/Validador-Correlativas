package domain;

import lombok.Getter;

import java.util.HashSet;
import java.util.Set;

public class Alumno {
    private String nombre;
    private String apellido;
    @Getter
    private Set<Materia> materiasAprobadas;

    public Alumno(String nombre, String apellido) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.materiasAprobadas = new HashSet<>();
    }

    public void agregarMateriaAprobada(Materia materia) {
        this.materiasAprobadas.add(materia);
    }

    public Boolean puedeCursar(Materia materia) {
        return this.materiasAprobadas.containsAll(materia.getCorrelativas());
        //return m.getCorrelativas().containsAll(this.getMateriasAprobadas());
    }
}
