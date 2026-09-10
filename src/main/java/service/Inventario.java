package service;

import lombok.Getter;
import java.util.List;
import java.util.LinkedList;

@lombok.ToString
public class Inventario {
    @Getter
    private List<Producto> lista; //referenciación

    public Inventario() {
        lista = new LinkedList<>();// instanciación
    }

    public void init() {
        addProducto( new Producto( "1001", "pupítres", 48 ) );
        addProducto( new Producto( "1002", "cañonera", 1 ) );
        addProducto( new Producto( "1003", "ventana", 3 ) );
    }

    public boolean addProducto( Producto p ) throws RuntimeException {
        if( null == p )
            throw new RuntimeException( "No se aceptan productos vacíos" );

        return lista.add( p );
    }

    public boolean removerTodosLosProductos() {
        return lista.removeAll( lista );
    }
}
