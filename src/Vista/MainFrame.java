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
    protected JPanel panelFormularioAlta;
    protected JPanel panelCobroTrabajos;
    protected JPanel panelTrabajosCobrados;

    // Labels ----------------------------------------------------------------------------------------------------------

    // TextFields ------------------------------------------------------------------------------------------------------

    // ComboBox --------------------------------------------------------------------------------------------------------

    // TextArea --------------------------------------------------------------------------------------------------------

    // Botones ---------------------------------------------------------------------------------------------------------
    protected JButton botonMenuFormulario;
    protected JButton botonMenuCobro;
    protected JButton botonMenuYaCobrados;


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

        panelFormularioAlta = new JPanel();
        panelCobroTrabajos = new JPanel();
        panelTrabajosCobrados = new JPanel();

        // Creamos los componentes
        botonMenuFormulario = new JButton("Alta Trabajo");
        botonMenuCobro = new JButton("Cobro Trabajo de Taller");
        botonMenuYaCobrados = new JButton("Trabajos ya cobrados");

        // Ahora añadimos los paneles en la frame (ventana).
        this.add(panelBase);
        panelBase.add(panelMenu, BorderLayout.NORTH);
        panelBase.add(panelContenido, BorderLayout.CENTER);

        panelContenido.add(panelFormularioAlta);
        panelContenido.add(panelCobroTrabajos);
        panelContenido.add(panelTrabajosCobrados);

        // Añadimos los componentes a los paneles
        panelMenu.add(botonMenuFormulario);
        panelMenu.add(botonMenuCobro);
        panelMenu.add(botonMenuYaCobrados);


        // Coloreamos los paneles para diferenciarlos
        panelBase.setBackground(new java.awt.Color(0, 0, 0));
        panelMenu.setBackground(new java.awt.Color(36, 243, 21));
        panelContenido.setBackground(new java.awt.Color(3, 252, 252));
        panelFormularioAlta.setBackground(new java.awt.Color(252, 0, 0));
        panelCobroTrabajos.setBackground(new java.awt.Color(181, 0, 252));
        panelTrabajosCobrados.setBackground(new java.awt.Color(255, 169, 37));

        // Asignamos ciertas propiedades a los componentes y paneles
        panelFormularioAlta.setVisible(true);
        panelCobroTrabajos.setVisible(false);
        panelTrabajosCobrados.setVisible(false);

        // Añadimos los listeners
        botonMenuFormulario.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panelFormularioAlta.setVisible(true);
                panelCobroTrabajos.setVisible(false);
                panelTrabajosCobrados.setVisible(false);
            }
        });

        botonMenuCobro.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panelFormularioAlta.setVisible(false);
                panelCobroTrabajos.setVisible(true);
                panelTrabajosCobrados.setVisible(false);
            }
        });

        botonMenuYaCobrados.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panelFormularioAlta.setVisible(false);
                panelCobroTrabajos.setVisible(false);
                panelTrabajosCobrados.setVisible(true);
            }
        });


    }

    // Métodos Extra ###################################################################################################

}
