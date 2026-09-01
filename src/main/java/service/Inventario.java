package service;

import lombok.Getter;
import lombok.ToString;

import java.util.List;
import java.util.LinkedList;

@ToString
public class Inventario {
    @Getter
    private List<Producto> lista; //referenciación

    public Inventario() {
        lista = new LinkedList<>();// instanciación
    }

    public void init() {
        addProducto( new Producto( "1001", "producto 1001" ) );
        addProducto( new Producto( "1002", "producto 1002" ) );
        addProducto( new Producto( "1003", "producto 1031" ) );
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
