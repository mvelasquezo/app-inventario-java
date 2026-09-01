package controller;

import service.Inventario;
import service.Producto;

import view.InventarioView;

import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
            inventarioView.model.addRow( new Object[] { p.getSku(), p.getNombre() } );

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

        if( !util.MyUtil.validar( sku ) || !util.MyUtil.validar( nombre ) )
            return;

        Producto p = new Producto( sku, nombre );

        inventarioService.addProducto( p );

        inventarioView.model.addRow( p.toRowArray() ); //addRow( new Object[] { sku, nombre } )

        inventarioView.uiJtGrilla.setModel( inventarioView.model );
    }
}

