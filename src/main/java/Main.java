import service.Inventario;
import view.InventarioView;

public class Main {
    public static void main(String[] args) {
        Inventario servicio = new Inventario();
        InventarioView view = new InventarioView();

        new controller.InventarioController( view, servicio );
    }
}
