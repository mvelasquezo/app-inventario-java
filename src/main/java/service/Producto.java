package service;

@lombok.ToString
@lombok.Getter
public class Producto {
    private String sku;
    private String nombre;
    private int cantidad;

    public Producto( String sku, String nombre, int cantidad ) {
        setSku( sku );
        setNombre( nombre );
        setCantidad( cantidad );
    }

    public Producto( String sku ) {
        this( sku, "", 0 );
    }

    public Producto() {
        this( "sku000", "", 0 );
    }

    public Producto setSku( String sku ) {
        this.sku = util.MyUtil.trim( sku );
        return this;
    }

    public Producto setNombre( String nombre ) {
        this.nombre = util.MyUtil.trim( nombre );
        return this;
    }

    public Producto setCantidad( int cantidad ) {
        this.cantidad = cantidad > 0 ? cantidad : 1;
        return this;
    }

    public Object[] toRowArray() {
        return new Object[] { this.sku, this.nombre, this.cantidad };
    }
}
