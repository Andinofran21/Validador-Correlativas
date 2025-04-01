package domain;

import lombok.Getter;

import java.util.HashSet;
import java.util.Set;

public class Materia {
    private String nombre;
    @Getter
    private Set<Materia> correlativas;

    public Materia(String nombre) {
        this.nombre = nombre;
        this.correlativas = new HashSet<>();
    }

    public void agregarCorrelativa(Materia ads) {
        this.correlativas.add(ads);
    }
}
