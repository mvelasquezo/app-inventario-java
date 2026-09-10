package view;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class InventarioView extends JFrame {

    private JPanel uiJpMain;
    private JPanel uiJpInsertar;
    private JPanel uiJpCargar;
    private JPanel uiJpDatos;
    private JScrollPane uiJspGrilla;
    private JPanel uiJpCargarBotones;

    public JButton uiJbCargar;
    public JTable uiJtGrilla;

    public JTextField uiJtSku;
    public JTextField uiJtNombre;
    public JTextField uiJtCantidad;

    public JButton uiJbAgregar;
    public JButton uiJbLimpiar;

    public DefaultTableModel model;

    public InventarioView() throws HeadlessException {

        initData();
        initUI();

        setVisible( true );
    }

    protected void initData() {
        model = new DefaultTableModel( new String[]{ "SKU", "Nombre", "Cantidad" }, 0 );
    }

    protected void initUI() {

        setTitle( "Inventario MVC" );

        setSize( 500, 500 );
        setLocationRelativeTo( null );

        setDefaultCloseOperation( EXIT_ON_CLOSE );

        new TextPrompt( "SKU", uiJtSku ).changeAlpha( 0.75f );
        new TextPrompt( "Nombre", uiJtNombre ).changeAlpha( 0.75f );
        new TextPrompt( "Cantidad", uiJtCantidad ).changeAlpha( 0.75f );

        getContentPane().add( uiJpMain );
    }

    public void limpiarCampos( String str ) {
        uiJtCantidad.setText( str );
        uiJtNombre.setText( str );
        uiJtSku.setText( str );
    }
}
