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
    protected JPanel panelFormulario;

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
        panelMenu = new JPanel();
        panelFormulario = new JPanel();

        // Creamos los componentes
        botonFormulario = new JButton("Formulario");
        botonCalculos = new JButton("Calculos");
        botonResumen = new JButton("Resumen");

        // Ahora añadimos los paneles en la frame (ventana).
        this.add(panelBase);
        panelBase.add(panelMenu, BorderLayout.NORTH);
        panelBase.add(panelFormulario, BorderLayout.CENTER);

        // Añadimos los componentes a los paneles
        panelMenu.add(botonFormulario);
        panelMenu.add(botonCalculos);
        panelMenu.add(botonResumen);


        // Coloreamos los paneles para diferenciarlos
        panelBase.setBackground(new java.awt.Color(0, 0, 0));
        panelMenu.setBackground(new java.awt.Color(36, 243, 21));
        panelFormulario.setBackground(new java.awt.Color(3, 252, 252));

        // Asignamos ciertas propiedades a los componentes y paneles


        // Añadimos los listeners
        botonFormulario.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
            }
        });

        botonCalculos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
            }
        });

        botonResumen.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
            }
        });


    }

    // Métodos Extra ###################################################################################################

}
