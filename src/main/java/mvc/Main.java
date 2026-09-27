package mvc;

import App.controller.InventarioController;
import App.service.Inventario;
import App.view.InventarioView;

public class Main {
    public static void main( String[] args ) {
        new InventarioController( new InventarioView(), new Inventario() );
    }
}
