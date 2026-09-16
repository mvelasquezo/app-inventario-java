import service.Inventario;
import view.InventarioView;

public class Main {
    public static void main( String[] args ) {
        new controller.InventarioController( new InventarioView(), new Inventario() );
    }
}
