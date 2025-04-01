package domain;

import java.util.HashSet;
import java.util.Set;

public class Inscripcion {
    private Alumno alumno;
    private Set<Materia> materiasACursar;

    public Inscripcion(Alumno alumno) {
        this.alumno = alumno;
        this.materiasACursar = new HashSet<>();
    }

    public Boolean aprobada() {
        return materiasACursar.stream()
                .allMatch(m -> alumno.puedeCursar(m));
    }

    public void agregarMateriaACursar(Materia materia) {
        materiasACursar.add(materia);
    }
}
