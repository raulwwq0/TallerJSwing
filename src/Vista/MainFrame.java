package Vista;

import Controlador.ControladorTaller;
import Modelo.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.Border;

public class MainFrame extends JFrame {

    // Atributos #######################################################################################################

    //Pixeles a usar en los Layouts como "hueco" entre componentes
    private static final byte GAP = 10;

    // Cosas del Panel Base --------------------------------------------------------------------------------------------
    protected JPanel panelBase;

    // Cosas del Panel Menu --------------------------------------------------------------------------------------------
    protected JPanel panelMenu;
    protected JButton botonMenuFormulario;
    protected JButton botonMenuCobro;
    protected JButton botonMenuYaCobrados;

    // Cosas del Panel Contenido ---------------------------------------------------------------------------------------
    protected JPanel panelContenido;

    // Cosas del Panel Formulario de Alta ------------------------------------------------------------------------------
    protected JPanel panelFormularioAlta;

    protected JLabel labelTipo;
    protected JComboBox comboTipo;
    protected JLabel labelTituloFormulario;
    protected JLabel labelMatricula;
    protected JTextField tfMatricula;
    protected JLabel labelDni;
    protected JTextField tfDni;
    protected JLabel labelPropietario;
    protected JTextField tfPropietario;
    protected JLabel labelModelo;
    protected JTextField tfModelo;
    protected JLabel labelDiagnostico;
    protected JTextArea taDiagnostico;
    protected JScrollPane scrollDiagnostico;
    protected JLabel labelSolucion;
    protected JTextArea taSolucion;
    protected JScrollPane scrollSolucion;
    protected JLabel labelHorasPrevistas;
    protected JTextField tfHorasPrevistas;
    protected JButton botonAlta;

    // Cosas del Panel para cobrar trabajos ----------------------------------------------------------------------------
    protected JPanel panelCobroTrabajos;
    protected JButton botonCobroTrabajo;
    protected JLabel tCobroTrabajos;
    protected JLabel tSeleccione;
    protected JLabel tTotal;
    protected JList listaCobros;

    // Cosas del Panel para trabajos ya cobrados -----------------------------------------------------------------------
    protected JPanel panelTrabajosCobrados;
    protected JLabel  tTrabajosYaCobrados;
    protected JLabel  tTotalCobrados;
    protected JList   listaCobrados;



    // Constructor #####################################################################################################
    public MainFrame(String title) {

        super(title);  //Para que se muestre el título


        //Bordes para los paneles
        Border blackline = BorderFactory.createLineBorder(Color.black);
        Border margenes = BorderFactory.createEmptyBorder(GAP, GAP, GAP, GAP);

        // Crear el frame.
        this.setExtendedState(java.awt.Frame.MAXIMIZED_BOTH);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Instaciamos un controladorTaller
        ControladorTaller controladorTaller = new ControladorTaller();

        // Creamos los paneles y le ponemos un layout
        panelBase = new JPanel(new BorderLayout());

        panelMenu = new JPanel(new FlowLayout(FlowLayout.CENTER, GAP, GAP));
        panelContenido = new JPanel();

        // Usando GridBagLayout podemos poner los paneles centrados de una forma más cómoda
        panelContenido.setLayout(new GridBagLayout());

        // Es necesario pasar ciertas configuraciones a GridBagLayout para que funcione, esto se hace al añadir los paneles
        GridBagConstraints gbc = new GridBagConstraints();


        panelFormularioAlta = new JPanel();
        panelFormularioAlta.setLayout(new BoxLayout(panelFormularioAlta, BoxLayout.Y_AXIS));

        panelCobroTrabajos = new JPanel(new FlowLayout(FlowLayout.CENTER,GAP,GAP));
        panelCobroTrabajos.setLayout(new BoxLayout(panelCobroTrabajos,BoxLayout.Y_AXIS));
        panelTrabajosCobrados = new JPanel();


        // Creamos los componentes
        botonMenuFormulario = new JButton("Alta Trabajo");
        botonMenuCobro = new JButton("Cobro Trabajo de Taller");
        botonMenuYaCobrados = new JButton("Trabajos ya cobrados");

        labelTituloFormulario = new JLabel("ALTA DE NUEVOS VEHICULOS");
        labelTipo = new JLabel("Tipo de Vehiculo:");
        comboTipo = new JComboBox(controladorTaller.getTiposVehiculo());
        labelMatricula = new JLabel("Matrícula:");
        tfMatricula = new JTextField();
        labelDni = new JLabel("DNI Propietario:");
        tfDni = new JTextField();
        labelPropietario = new JLabel("Propietario:");
        tfPropietario = new JTextField();
        labelModelo = new JLabel("Modelo:");
        tfModelo = new JTextField();
        labelDiagnostico = new JLabel("Diagnóstico:");
        taDiagnostico = new JTextArea(20, 20);
        scrollDiagnostico = new JScrollPane(taDiagnostico); // <- Con este scroll evitamos el bug de que se muevan las etiquetas al escribir en el textarea
        labelSolucion = new JLabel("Solución:");
        taSolucion = new JTextArea(20, 20);
        scrollSolucion = new JScrollPane(taSolucion);
        labelHorasPrevistas = new JLabel("Horas previstas:");
        tfHorasPrevistas = new JTextField();
        botonAlta = new JButton("Dar de Alta");

        //Cobro trabajo de taller
        botonCobroTrabajo = new JButton("Cobrar");
        tCobroTrabajos = new JLabel("Cobro de trabajos");
        tSeleccione = new JLabel("Seleccione vehículo y trabajo realizado:");
        tTotal = new JLabel("Total trabajos realizados : 0");
        listaCobros = new JList(controladorTaller.getTrabajosACobrar().toArray());

        //Trabajos ya cobrados
        tTrabajosYaCobrados = new JLabel("Trabajos ya cobrados");
        tTotalCobrados = new JLabel("Total trabajos realizados : 0");
        listaCobrados = new JList();

        // Ahora añadimos los paneles en la frame (ventana).
        this.add(panelBase);
        panelBase.add(panelMenu, BorderLayout.NORTH);
        panelBase.add(panelContenido, BorderLayout.CENTER);


        // Ahora con gridbaglayout tenemos que modificar las constantes para adaptar los paneles antes de añadirlos
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.insets = new Insets(100, 100, 100, 100);

        panelContenido.add(panelFormularioAlta, gbc);
        panelContenido.add(panelCobroTrabajos, gbc);
        panelContenido.add(panelTrabajosCobrados, gbc);

        // Añadimos los componentes a los paneles
        panelMenu.add(botonMenuFormulario);
        panelMenu.add(botonMenuCobro);
        panelMenu.add(botonMenuYaCobrados);

        panelFormularioAlta.add(labelTituloFormulario);
        panelFormularioAlta.add(Box.createRigidArea(new Dimension(0, 30))); // <- Para que se vea mejor, es un separador
        panelFormularioAlta.add(labelTipo);
        panelFormularioAlta.add(comboTipo);
        panelFormularioAlta.add(labelMatricula);
        panelFormularioAlta.add(tfMatricula);
        panelFormularioAlta.add(labelDni);
        panelFormularioAlta.add(tfDni);
        panelFormularioAlta.add(labelPropietario);
        panelFormularioAlta.add(tfPropietario);
        panelFormularioAlta.add(labelModelo);
        panelFormularioAlta.add(tfModelo);
        panelFormularioAlta.add(labelDiagnostico);
        panelFormularioAlta.add(scrollDiagnostico);
        panelFormularioAlta.add(labelSolucion);
        panelFormularioAlta.add(scrollSolucion);
        panelFormularioAlta.add(labelHorasPrevistas);
        panelFormularioAlta.add(tfHorasPrevistas);
        panelFormularioAlta.add(Box.createRigidArea(new Dimension(0, 30)));
        panelFormularioAlta.add(botonAlta);

        //Añadimos los componentes al panel de cobro trabajo taller
        panelCobroTrabajos.add(tCobroTrabajos);
        panelCobroTrabajos.add(listaCobros);
        panelCobroTrabajos.add(tSeleccione);
        panelCobroTrabajos.add(tTotal);
        panelCobroTrabajos.add(botonCobroTrabajo);

        //Añadimos los componentes al panel de trabajos ya cobrados
        panelTrabajosCobrados.add(tTrabajosYaCobrados);
        panelTrabajosCobrados.add(tTotalCobrados);
        panelTrabajosCobrados.add(listaCobrados);

        // Coloreamos los paneles para diferenciarlos
        panelBase.setBackground(new java.awt.Color(0, 0, 0));
        panelMenu.setBackground(new java.awt.Color(140, 220, 147));
        panelContenido.setBackground(new java.awt.Color(140, 197, 220));
        panelFormularioAlta.setBackground(new java.awt.Color(255, 140, 140));
        panelCobroTrabajos.setBackground(new java.awt.Color(160, 140, 220));
        panelTrabajosCobrados.setBackground(new java.awt.Color(255, 226, 140));

        // Asignamos ciertas propiedades a los componentes y paneles
        panelFormularioAlta.setVisible(true);
        panelCobroTrabajos.setVisible(false);
        panelTrabajosCobrados.setVisible(false);

        panelFormularioAlta.setBorder(margenes);

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

        botonAlta.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int codigoDeError = this.controlDeErrores();
                int indiceTipoVehiculo = comboTipo.getSelectedIndex();
                Vehiculo vehiculo = null;
                TrabajoTaller trabajoTaller;

                if(codigoDeError == 0){
                    switch (indiceTipoVehiculo) {
                        case 0:
                            vehiculo = new Coche(tfMatricula.getText(), tfModelo.getText(), tfPropietario.getText(), tfDni.getText());
                            break;
                        case 1:
                            vehiculo = new Moto(tfMatricula.getText(), tfModelo.getText(), tfPropietario.getText(), tfDni.getText());
                            break;
                        case 2:
                            vehiculo = new Furgon(tfMatricula.getText(), tfModelo.getText(), tfPropietario.getText(), tfDni.getText());
                            break;
                        case 3:
                            vehiculo = new Camion(tfMatricula.getText(), tfModelo.getText(), tfPropietario.getText(), tfDni.getText());

                            break;
                    }
                    System.out.println(comboTipo.getSelectedIndex());
                    trabajoTaller = new TrabajoTaller(vehiculo, taDiagnostico.getText(), taSolucion.getText(), Integer.parseInt(tfHorasPrevistas.getText()));
                    controladorTaller.addTrabajo(trabajoTaller);
                    listaCobros.setListData(controladorTaller.getTrabajosACobrar().toArray());
                    System.out.println("Trabajo añadido");

                } else {
                    switch (codigoDeError) {
                        case 1:
                            System.out.println("Campos vacios");
                            break;
                        case 2:
                            System.out.println("Horas no en numero");
                            break;
                        case 3:
                            System.out.println("DNI no valido");
                            break;
                    }
                }

            }

            private int controlDeErrores() {
                // Comprobamos que los campos no estén vacíos
                if (tfMatricula.getText().isEmpty() ||
                        tfDni.getText().isEmpty() ||
                        tfPropietario.getText().isEmpty() ||
                        tfModelo.getText().isEmpty() ||
                        taDiagnostico.getText().isEmpty() ||
                        taSolucion.getText().isEmpty() ||
                        tfHorasPrevistas.getText().isEmpty()) {

                    return 1;
                } else {
                    // Comprobamos que el campo horas previstas sea un número
                    try {
                        Integer.parseInt(tfHorasPrevistas.getText());
                    } catch (NumberFormatException e) {
                        return 2;
                    }

                    // Comprobamos el formato del DNI
                    if (!tfDni.getText().matches("^\\d{8}[A-Z]$")) {
                        return 3;
                    }
                }

                return 0;
            }
        });

        //botonCobroTrabajo.addActionListener(new ActionListener() {
        //@Override
        //public void actionPerformed(ActionEvent e) {
        // panelFormularioAlta.setVisible(false);
        // panelCobroTrabajos.setVisible(false);
        //  panelTrabajosCobrados.setVisible(true);
        //}
        //});


    }

    // Métodos Extra ###################################################################################################

}
