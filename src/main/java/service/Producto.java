package service;

@lombok.ToString
@lombok.Getter
public class Producto {
    private String sku;
    private String nombre;

    public Producto( String sku, String nombre ) {
        setSku( sku );
        setNombre( nombre );
    }

    public Producto( String sku ) {
        this( sku, "" );
    }

    public Producto() {
        this( "sku000", "" );
    }

    public Producto setSku( String sku ) {
        this.sku = util.MyUtil.trim( sku );
        return this;
    }

    public Producto setNombre( String nombre ) {
        this.nombre = util.MyUtil.trim( nombre );
        return this;
    }

    public Object[] toRowArray() {
        return new Object[] { this.sku, this.nombre };
    }
}
