import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TareaControllerTest {
    private TareaController controlador;

    @BeforeEach
    void setUp() {
        AlmacenarTareas almacenamiento = new AlmacenamientoMemoria();
        controlador = new TareaController(almacenamiento);
    }


    @Test
    void testAgregarVariosElementosYRevisarIds() {
        Tarea t = controlador.agregarTarea("atender estudiantes","Ximena");
        Tarea t2 = controlador.agregarTarea("atender estudiantes","Luis Diego");
        Tarea t3 = controlador.agregarTarea("atender estudiantes","william");
        assertEquals(0, t.getId());
        assertEquals(1, t2.getId());
        assertEquals(2, t3.getId());
    }

    @Test
    void validarCambioDeEstado() {
        Tarea t3 = controlador.agregarTarea("atender estudiantes", "jotanan");
        controlador.completarTarea(t3.getId());
        assertTrue(t3.getCompletada());
    }

    @Test
    void testCompletarTareaInexistenteLanzaExcepcion() {
        try {
            controlador.completarTarea(99);
            fail("Debió lanzar IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            assertEquals("No hay una tarea con el ID: 99", e.getMessage());
        }
    }

    @Test
    void testCompletarTareaYaCompletadaLanzaExcepcion() {
        Tarea t = controlador.agregarTarea("atender estudiantes", "jotanan");
        controlador.completarTarea(t.getId());
        try {
            controlador.completarTarea(t.getId());
            fail("Debió lanzar IllegalStateException");
        } catch (IllegalStateException e) {
            assertEquals("La tarea ya estaba completada.", e.getMessage());
        }
    }

    @Test
    void testEliminarTareaExistente() {
        Tarea t = controlador.agregarTarea("atender estudiantes", "william");
        controlador.eliminarTarea(t.getId());
        try {
            controlador.completarTarea(t.getId());
            fail("Debió lanzar IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            assertEquals("No hay una tarea con el ID: " + t.getId(), e.getMessage());
        }
    }

    @Test
    void testEliminarTareaInexistenteLanzaExcepcion() {
        try {
            controlador.eliminarTarea(99);
            fail("Debió lanzar IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            assertEquals("No hay una tarea con el ID: 99", e.getMessage());
        }
    }
}
