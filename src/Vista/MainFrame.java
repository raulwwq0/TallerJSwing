package Vista;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.Border;

public class MainFrame extends JFrame {

    // Atributos #######################################################################################################

    //Pixeles a usar en los Layouts como "hueco" entre componentes
    private static final byte GAP = 10;

    //Enlace al controlador
    // Por ahora nada...

    // Paneles ---------------------------------------------------------------------------------------------------------
    protected JPanel panelBase;
    protected JPanel panelMenu;
    protected JPanel panelContenido;
    protected JPanel panelFormulario;
    protected JPanel panelPrecios;
    protected JPanel panelResumen;

    // Labels ----------------------------------------------------------------------------------------------------------

    // TextFields ------------------------------------------------------------------------------------------------------

    // ComboBox --------------------------------------------------------------------------------------------------------

    // TextArea --------------------------------------------------------------------------------------------------------

    // Botones ---------------------------------------------------------------------------------------------------------
    protected JButton botonFormulario;
    protected JButton botonCalculos;
    protected JButton botonResumen;


    // Constructor #####################################################################################################
    public MainFrame(String title) {
        super(title);  //Para que se muestre el título

        //Bordes para los paneles
        Border blackline;
        blackline = BorderFactory.createLineBorder(Color.black);


        // Crear el frame.
        this.setExtendedState(java.awt.Frame.MAXIMIZED_BOTH);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Creamos los paneles y le ponemos un layout
        panelBase = new JPanel(new BorderLayout());

        panelMenu = new JPanel(new FlowLayout(FlowLayout.CENTER, GAP, GAP));
        panelContenido = new JPanel(new FlowLayout(FlowLayout.CENTER, GAP, GAP));

        panelFormulario = new JPanel();
        panelPrecios = new JPanel();
        panelResumen = new JPanel();

        // Creamos los componentes
        botonFormulario = new JButton("Formulario");
        botonCalculos = new JButton("Precios");
        botonResumen = new JButton("Resumen");

        // Ahora añadimos los paneles en la frame (ventana).
        this.add(panelBase);
        panelBase.add(panelMenu, BorderLayout.NORTH);
        panelBase.add(panelContenido, BorderLayout.CENTER);

        panelContenido.add(panelFormulario);
        panelContenido.add(panelPrecios);
        panelContenido.add(panelResumen);

        // Añadimos los componentes a los paneles
        panelMenu.add(botonFormulario);
        panelMenu.add(botonCalculos);
        panelMenu.add(botonResumen);


        // Coloreamos los paneles para diferenciarlos
        panelBase.setBackground(new java.awt.Color(0, 0, 0));
        panelMenu.setBackground(new java.awt.Color(36, 243, 21));
        panelContenido.setBackground(new java.awt.Color(3, 252, 252));
        panelFormulario.setBackground(new java.awt.Color(252, 0, 0));
        panelPrecios.setBackground(new java.awt.Color(181, 0, 252));
        panelResumen.setBackground(new java.awt.Color(255, 169, 37));

        // Asignamos ciertas propiedades a los componentes y paneles
        panelFormulario.setVisible(true);
        panelPrecios.setVisible(false);
        panelResumen.setVisible(false);

        // Añadimos los listeners
        botonFormulario.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panelFormulario.setVisible(true);
                panelPrecios.setVisible(false);
                panelResumen.setVisible(false);
            }
        });

        botonCalculos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panelFormulario.setVisible(false);
                panelPrecios.setVisible(true);
                panelResumen.setVisible(false);
            }
        });

        botonResumen.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panelFormulario.setVisible(false);
                panelPrecios.setVisible(false);
                panelResumen.setVisible(true);
            }
        });


    }

    // Métodos Extra ###################################################################################################

}
