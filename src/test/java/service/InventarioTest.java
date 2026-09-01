package service;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
public class InventarioTest {
    private Inventario inventario;
    @Before
    public void before() throws Exception {
        inventario = new Inventario();
    }

    @Test( expected = RuntimeException.class )
    public void testProductoVacioComoParametro() {
        inventario.addProducto( null );
    }

    @Test()
    public void testAgregandoProductosAInventario() {
        inventario.addProducto( new Producto( "sku1001" ) );
        inventario.addProducto( new Producto( "sku1002" ) );
        inventario.addProducto( new Producto( "sku1003" ) );

        String esperado = "inventario(lista=[producto(sku=sku1001), producto(sku=sku1002), producto(sku=sku1003)])";
        String obtenido = inventario.toString().toLowerCase();

        assertEquals( esperado, obtenido );
    }


}