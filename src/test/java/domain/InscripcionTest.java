package domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class InscripcionTest {
    // MATERIAS
    private Materia ads = new Materia("Analisis de Sistemas");
    private Materia pdep = new Materia("Paradigmas de Programacion");
    private Materia ingles = new Materia("Ingles");
    private Materia arqui = new Materia("Arquitectura de Computadores");
    private Materia dds = new Materia("Diseño de Sistemas");
    private Materia am1 = new Materia("Analisis Matematico 1");
    private Materia am2 = new Materia("Analisis Matematico 2");

    // ALUMNOS
    private Alumno franco = new Alumno("Franco", "Andino");
    private Alumno matias = new Alumno("Matias", "Aponte");

    // INSCRIPCIONES
    private Inscripcion inscripcionFranco = new Inscripcion(franco);
    private Inscripcion inscripcionMati = new Inscripcion(matias);

    @BeforeEach
    public void setUp() {
        // Correlativas de DDS
        dds.agregarCorrelativa(ads);
        dds.agregarCorrelativa(pdep);
        dds.agregarCorrelativa(ingles);

        // Materias aprobadas de los alumnos
        franco.agregarMateriaAprobada(ads);
        franco.agregarMateriaAprobada(pdep);
        franco.agregarMateriaAprobada(ingles);
        franco.agregarMateriaAprobada(am1);

        matias.agregarMateriaAprobada(ads);
        matias.agregarMateriaAprobada(am1);

    }

    @Test
    @DisplayName("Franco puede anotarse a DDS porque cumple con las correlativas")
    public void inscripcionAprobadaDds() {
        inscripcionFranco.agregarMateriaACursar(dds);

        Assertions.assertTrue(inscripcionFranco.aprobada());
    }
    @Test
    @DisplayName("Matias no puede anotarse a DDS porque no cumple con todas las correlativas (pdep e ingles)")
    public void inscripcionFallidaDds() {
        inscripcionMati.agregarMateriaACursar(dds);

        Assertions.assertFalse(inscripcionMati.aprobada());
    }

    @Test
    @DisplayName("Franco puede anotarse a mas de una materia ya que aprobo las correlativas de todas ellas")
    public void inscripcionAprobadaMasDeUnaMateria() {
        inscripcionFranco.agregarMateriaACursar(dds);
        inscripcionFranco.agregarMateriaACursar(am2);

        Assertions.assertTrue(inscripcionFranco.aprobada());
    }

    @Test
    @DisplayName("Si mati aprueba pdep e ingles puede cursas DDS")
    public void inscripcionAprobadaCumpliendoCorrelativas() {
        matias.agregarMateriaAprobada(pdep);
        matias.agregarMateriaAprobada(ingles);
        inscripcionMati.agregarMateriaACursar(dds);

        Assertions.assertTrue(inscripcionMati.aprobada());
    }

    @Test
    @DisplayName("Mati no puede anotarse a mas de una materia porque no cumple las correlativas todas ellas")
    public void inscripcionRechazadaMasDeUnaMateria() {;
        inscripcionMati.agregarMateriaACursar(dds);
        inscripcionMati.agregarMateriaACursar(am2);

        Assertions.assertTrue(inscripcionFranco.aprobada());
    }

    @Test
    @DisplayName("Si se agrega una nueva correlativa Franco ya no va a poder cursar dds")
    public void inscripcionFallidaDdsConNuevaCorrelativa() {
        dds.agregarCorrelativa(arqui);
        inscripcionFranco.agregarMateriaACursar(dds);

        Assertions.assertFalse(inscripcionFranco.aprobada());
    }
}