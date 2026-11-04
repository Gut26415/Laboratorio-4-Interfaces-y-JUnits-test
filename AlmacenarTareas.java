import java.util.List;

public interface AlmacenarTareas {
    public void guardar(Tarea tarea);
    public Tarea buscarPorId(int id);
    public List<Tarea> obtenerTodas();
    public boolean eliminar(int id);
}
