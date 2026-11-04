import java.util.ArrayList;
import java.util.List;

public class AlmacenamientoMemoria implements AlmacenarTareas {
    private List<Tarea> listaDeTareas = new ArrayList<>();

    @Override
    public void guardar(Tarea tarea) {
        listaDeTareas.add(tarea);
    }

    @Override
    public Tarea buscarPorId(int id) {
        for (Tarea t : listaDeTareas) {
            if (t.getId() == id) {
                return t;
            }
        }
        return null;
    }

    @Override
    public List<Tarea> obtenerTodas() {
        return new ArrayList<>(listaDeTareas);
    }

    @Override
    public boolean eliminar(int id){
        for (Tarea t : listaDeTareas) {
            if (t.getId() == id) {
                listaDeTareas.remove(t);
                return true;
            }
        }
        return false;
    }
}
