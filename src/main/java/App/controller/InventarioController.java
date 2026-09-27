package App.controller;

import App.service.Inventario;
import App.service.Producto;

import App.util.MyUtil;
import App.view.InventarioView;

import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@lombok.ToString
public class InventarioController {

    private Inventario inventarioService;
    private InventarioView inventarioView;

    public InventarioController(
            InventarioView inventarioView,
            Inventario inventarioService ) {

        this.inventarioView = inventarioView;
        this.inventarioService = inventarioService;

        this.inventarioView.uiJbCargar.addActionListener(
                new Cargar( inventarioView, inventarioService )
        );

        this.inventarioView.uiJbLimpiar.addActionListener(
                new Limpiar( inventarioView, inventarioService )
        );

        this.inventarioView.uiJbAgregar.addActionListener(
                new Agregar( inventarioView, inventarioService )
        );
    }
}

class Agregar implements ActionListener {
    private Inventario inventarioService;
    private InventarioView inventarioView;

    public Agregar(
            InventarioView inventarioView,
            Inventario inventarioService ) {

        this.inventarioService = inventarioService;
        this.inventarioView = inventarioView;
    }

    public void actionPerformed( ActionEvent e ) {
        String sku = inventarioView.uiJtSku.getText();
        String nombre = inventarioView.uiJtNombre.getText();
        String scantidad = inventarioView.uiJtCantidad.getText();

        if( !MyUtil.validar( sku ) || !MyUtil.validar( nombre )
                || !MyUtil.validar( scantidad ) )
            return;

        int cantidad = MyUtil.toInt( scantidad, 0 );

        Producto p = new Producto( sku, nombre, cantidad );

        inventarioService.addProducto( p );

        inventarioView.model.addRow( p.toRowArray() ); //addRow( new Object[] { sku, nombre } )

        inventarioView.uiJtGrilla.setModel( inventarioView.model );

        inventarioView.limpiarCampos( "" );
    }
}

class Cargar implements ActionListener {
    private Inventario inventarioService;
    private InventarioView inventarioView;

    public Cargar(
            InventarioView inventarioView,
            Inventario inventarioService ) {

        this.inventarioService = inventarioService;
        this.inventarioView = inventarioView;
    }

    public void actionPerformed( ActionEvent e ) {
        cargar();
    }

    public void cargar() {
        inventarioService.init();

        for( Producto p: inventarioService.getLista() )
            inventarioView.model.addRow( new Object[] { p.getSku(), p.getNombre(), p.getCantidad() } );

        inventarioView.uiJtGrilla.setModel( inventarioView.model );
    }
}

class Limpiar implements ActionListener {
    private Inventario inventarioService;
    private InventarioView inventarioView;

    public Limpiar(
            InventarioView inventarioView,
            Inventario inventarioService ) {

        this.inventarioService = inventarioService;
        this.inventarioView = inventarioView;
    }

    public void actionPerformed( ActionEvent e ) {
        limpiar();
    }

    public void limpiar() {
        inventarioService.removerTodosLosProductos();

        DefaultTableModel dm = (DefaultTableModel) inventarioView.uiJtGrilla.getModel();
        dm.getDataVector().removeAllElements();
        dm.fireTableDataChanged();
    }
}



