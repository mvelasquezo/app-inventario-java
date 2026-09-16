public class Main {
    public static void main( String[] args ) {
        new controller.InventarioController( new view.InventarioView(), new service.Inventario() );
    }
}
