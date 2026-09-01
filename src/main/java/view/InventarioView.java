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
    public JButton uiJbAgregar;
    public JButton uiJbLimpiar;

    public DefaultTableModel model;

    public InventarioView() throws HeadlessException {

        initData();
        initUI();

        setVisible( true );
    }

    protected void initData() {
        model = new DefaultTableModel( new String[]{ "SKU", "Nombre" }, 0 );
    }

    protected void initUI() {

        setTitle( "Inventario MVC" );

        setSize( 500, 500 );
        setLocationRelativeTo( null );

        setDefaultCloseOperation( EXIT_ON_CLOSE );

        getContentPane().add( uiJpMain );

    }
}
