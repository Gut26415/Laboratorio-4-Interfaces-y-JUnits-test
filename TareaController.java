public class TareaController {
    private AlmacenarTareas almacenamiento;
    private int contadorTareas;
    public TareaController(AlmacenarTareas almacenamiento) {
        this.almacenamiento = almacenamiento;
        this.contadorTareas = 0;
    }

    public Tarea agregarTarea(String titulo, String descripcion) {
        Tarea nueva = new Tarea(contadorTareas++, titulo, descripcion);
        almacenamiento.guardar(nueva);
        return nueva;
    }

    public void completarTarea(int id) {
        Tarea t = almacenamiento.buscarPorId(id);
        
        if (t == null) {
            throw new IllegalArgumentException("No hay una tarea con el ID: " + id);
        }
        if (t.getCompletada()) {
            throw new IllegalStateException("La tarea ya estaba completada.");
        }
        
        t.setCompletada(true);
    }

    public void eliminarTarea(int id) {
        boolean eliminada = almacenamiento.eliminar(id);

        if (!eliminada) {
            throw new IllegalArgumentException("No hay una tarea con el ID: " + id);
        }
    }
}

