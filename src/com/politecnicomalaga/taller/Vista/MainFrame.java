package com.politecnicomalaga.taller.Vista;

import com.politecnicomalaga.taller.Controlador.ControladorTaller;
import com.politecnicomalaga.taller.Modelo.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

import javax.swing.*;
import javax.swing.border.Border;

import static javax.swing.JOptionPane.showMessageDialog;

public class MainFrame extends JFrame {

    // Atributos #######################################################################################################

    //Pixeles a usar en los Layouts como "hueco" entre componentes
    private static final byte GAP_SEPARACION = 10;

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
    protected JScrollPane scrollPanelFormularioAlta;

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
    protected JScrollPane scrollCobroLista;

    // Cosas del Panel para trabajos ya cobrados -----------------------------------------------------------------------
    protected JPanel panelTrabajosCobrados;
    protected JLabel labelTrabajosYaCobrados;
    protected JLabel labelTrabajosCobrados;
    protected JList  listaCobrados;
    protected JScrollPane scrollCobradosLista;



    // Constructor #####################################################################################################
    public MainFrame(String title) {

        //Para que se muestre el título
        super(title);

        // Guardamos la ventana en una variable para usarla
        Component ventanaDelPrograma = getContentPane();

        // BORDES ######################################################################################################

        // Usando un borde vacío podremos simular una zona de separación entre componentes (padding)
        Border padding = BorderFactory.createEmptyBorder(GAP_SEPARACION, GAP_SEPARACION, GAP_SEPARACION, GAP_SEPARACION);

        // CREACION DEL FRAME ##########################################################################################

        this.setExtendedState(java.awt.Frame.MAXIMIZED_BOTH);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // CONTROLADOR DEL TALLER ######################################################################################

        ControladorTaller controladorTaller = new ControladorTaller();





        // CREACION DE PANELES Y LAYOUTS ###############################################################################

        // Panel Base (Usa un layout de tipo BorderLayout) -------------------------------------------------------------

        panelBase = new JPanel(new BorderLayout());

        // Panel Menu (Usa un layout de tipo FlowLayout) ---------------------------------------------------------------

        panelMenu = new JPanel(new FlowLayout(FlowLayout.CENTER, GAP_SEPARACION, GAP_SEPARACION));

        // Panel Contenido (Usa un layout de tipo GridBagLayout) -------------------------------------------------------

        panelContenido = new JPanel();

        /*
            Usando GridBagLayout podemos poner los paneles centrados de una forma más cómoda.

            Lo instanciamos aparte porque tendremos que usarlo más adelante en el listener que controla el tamaño
            de la ventana.
         */

        GridBagLayout gbl = new GridBagLayout();
        panelContenido.setLayout(gbl);

        // Panel Formulario (Usa un layout de tipo BoxLayout) ----------------------------------------------------------

        panelFormularioAlta = new JPanel();
        panelFormularioAlta.setLayout(new BoxLayout(panelFormularioAlta, BoxLayout.Y_AXIS));
        scrollPanelFormularioAlta = new JScrollPane(panelFormularioAlta);  // <- Ponemos un scroll al panel formulario para mejorar el responsive

        // Panel Cobros (Usa un layout de tipo BoxLayout) --------------------------------------------------------------

        panelCobroTrabajos = new JPanel();
        panelCobroTrabajos.setLayout(new BoxLayout(panelCobroTrabajos,BoxLayout.Y_AXIS));

        // Panel Trabajos Cobrados (Usa un layout de tipo BoxLayout) ---------------------------------------------------

        panelTrabajosCobrados = new JPanel();
        panelTrabajosCobrados.setLayout(new BoxLayout(panelTrabajosCobrados,BoxLayout.Y_AXIS));


        // CREACION DE LOS COMPONENTES #################################################################################


        // Componentes del panelMenu -----------------------------------------------------------------------------------

        botonMenuFormulario = new JButton("Alta Trabajo");
        botonMenuCobro = new JButton("Cobro Trabajo de Taller");
        botonMenuYaCobrados = new JButton("Trabajos ya cobrados");

        // Componentes del panelFormularioAlta -------------------------------------------------------------------------

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
        taDiagnostico = new JTextArea(13, 0);
        scrollDiagnostico = new JScrollPane(taDiagnostico); // <- Con este scroll evitamos el bug de que se muevan las etiquetas al escribir en el textarea
        labelSolucion = new JLabel("Solución:");
        taSolucion = new JTextArea(13, 0);
        scrollSolucion = new JScrollPane(taSolucion);
        labelHorasPrevistas = new JLabel("Horas previstas:");
        tfHorasPrevistas = new JTextField();
        botonAlta = new JButton("Dar de Alta");

        // Componentes del panelCobroTrabajos --------------------------------------------------------------------------

        botonCobroTrabajo = new JButton("Cobrar");
        tCobroTrabajos = new JLabel("Cobro de trabajos");
        tSeleccione = new JLabel("Seleccione vehículo y trabajo realizado:");
        tTotal = new JLabel("Total trabajos por cobrar : 0");
        listaCobros = new JList(controladorTaller.getTrabajosACobrar().toArray());
        scrollCobroLista = new JScrollPane(listaCobros);

        // Componentes del panelTrabajosCobrados -----------------------------------------------------------------------

        labelTrabajosYaCobrados = new JLabel("Trabajos ya cobrados");
        labelTrabajosCobrados = new JLabel("Total trabajos realizados : " + controladorTaller.getTrabajosRealizados().size()); //añadimos el contador
        listaCobrados = new JList(controladorTaller.getTrabajosRealizados().toArray());
        scrollCobradosLista = new JScrollPane(listaCobrados);

        

        // AÑADIR PANELES ##############################################################################################

        // Añadimos el panel base a la ventana (la ventana es el this)

        this.add(panelBase);

        // Añadimos los paneles del menu y contenido al panel base y los colocamos en su sitio

        panelBase.add(panelMenu, BorderLayout.NORTH);  // <- Añadimos el panel al norte (la parte de arriba)
        panelBase.add(panelContenido, BorderLayout.CENTER);  // <- Añadimos el panel al centro (en este caso es la parte de abajo)

        // La configuración de los paneles (GridBagConstraints) las asignaremos en el listener que controla el tamaño de la ventana.

        panelContenido.add(scrollPanelFormularioAlta);
        panelContenido.add(panelCobroTrabajos);
        panelContenido.add(panelTrabajosCobrados);





        // AÑADIR COMPONENTES ##########################################################################################

        // Añadimos los componentes a los panelMenu --------------------------------------------------------------------

        panelMenu.add(botonMenuFormulario);
        panelMenu.add(botonMenuCobro);
        panelMenu.add(botonMenuYaCobrados);

        // Añadimos los componentes a los panelFormularioAlta ----------------------------------------------------------

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

        //Añadimos los componentes al panelCobroTrabajos ---------------------------------------------------------------

        panelCobroTrabajos.add(tCobroTrabajos);
        panelCobroTrabajos.add(Box.createRigidArea(new Dimension(0, 20)));
        panelCobroTrabajos.add(tSeleccione);
        panelCobroTrabajos.add(Box.createRigidArea(new Dimension(0, 20)));
        panelCobroTrabajos.add(tTotal);
        panelCobroTrabajos.add(scrollCobroLista);
        panelCobroTrabajos.add(botonCobroTrabajo);

        //Añadimos los componentes al panelTrabajosCobrados ------------------------------------------------------------

        panelTrabajosCobrados.add(labelTrabajosYaCobrados);
        panelTrabajosCobrados.add(Box.createRigidArea(new Dimension(0, 20)));
        panelTrabajosCobrados.add(labelTrabajosCobrados);
        panelTrabajosCobrados.add(scrollCobradosLista);





        // CONFIGURACIONES DE LOS COMPONENTES ##########################################################################

        // Coloreamos los paneles para diferenciarlos

        panelBase.setBackground(new java.awt.Color(0, 0, 0));
        panelMenu.setBackground(new java.awt.Color(140, 220, 147));
        panelContenido.setBackground(new java.awt.Color(140, 197, 220));
        panelFormularioAlta.setBackground(new java.awt.Color(255, 140, 140));
        panelCobroTrabajos.setBackground(new java.awt.Color(160, 140, 220));
        panelTrabajosCobrados.setBackground(new java.awt.Color(255, 226, 140));

        // Ponemos visible el panelFormularioAlta y ocultamos el resto, para que este sea el que se muestre por defecto

        panelFormularioAlta.setVisible(true);
        scrollPanelFormularioAlta.setVisible(true);  // <- ¡OJO! También tenemos que controlar la visibilidad del scroll

        panelCobroTrabajos.setVisible(false);
        panelTrabajosCobrados.setVisible(false);

        // Con esto le metemos un padding a los paneles para que los componentes no queden muy pegados al borde

        panelFormularioAlta.setBorder(padding);
        panelCobroTrabajos.setBorder(padding);
        panelTrabajosCobrados.setBorder(padding);

        // Para que los componentes no se coloquen donde no deberían tenemos que forzar que TODOS los componentes tengan una posición fija

        labelTituloFormulario.setAlignmentX(Component.LEFT_ALIGNMENT);
        labelTipo.setAlignmentX(Component.LEFT_ALIGNMENT);
        comboTipo.setAlignmentX(Component.LEFT_ALIGNMENT);
        labelMatricula.setAlignmentX(Component.LEFT_ALIGNMENT);
        tfMatricula.setAlignmentX(Component.LEFT_ALIGNMENT);
        labelDni.setAlignmentX(Component.LEFT_ALIGNMENT);
        tfDni.setAlignmentX(Component.LEFT_ALIGNMENT);
        labelPropietario.setAlignmentX(Component.LEFT_ALIGNMENT);
        tfPropietario.setAlignmentX(Component.LEFT_ALIGNMENT);
        labelModelo.setAlignmentX(Component.LEFT_ALIGNMENT);
        tfModelo.setAlignmentX(Component.LEFT_ALIGNMENT);
        labelDiagnostico.setAlignmentX(Component.LEFT_ALIGNMENT);
        scrollDiagnostico.setAlignmentX(Component.LEFT_ALIGNMENT);
        labelSolucion.setAlignmentX(Component.LEFT_ALIGNMENT);
        scrollSolucion.setAlignmentX(Component.LEFT_ALIGNMENT);
        labelHorasPrevistas.setAlignmentX(Component.LEFT_ALIGNMENT);
        tfHorasPrevistas.setAlignmentX(Component.LEFT_ALIGNMENT);
        botonAlta.setAlignmentX(Component.LEFT_ALIGNMENT);

        //Para los componentes del panel de cobro también los tenemos que poner a la izquierda

        botonCobroTrabajo.setAlignmentX(Component.LEFT_ALIGNMENT);
        tCobroTrabajos.setAlignmentX(Component.LEFT_ALIGNMENT);
        tSeleccione.setAlignmentX(Component.LEFT_ALIGNMENT);
        tTotal.setAlignmentX(Component.LEFT_ALIGNMENT);
        listaCobros.setAlignmentX(Component.LEFT_ALIGNMENT);
        scrollCobroLista.setAlignmentX(Component.LEFT_ALIGNMENT);

        //Para los componentes del panel de cobrados, tenemos que poner los labels a la izquierda

        labelTrabajosCobrados.setAlignmentX(Component.LEFT_ALIGNMENT);
        labelTrabajosYaCobrados.setAlignmentX(Component.LEFT_ALIGNMENT);
        scrollCobradosLista.setAlignmentX(Component.LEFT_ALIGNMENT);





        // LISTENERS ###################################################################################################

        // Listener para el botón del menu que te lleva a panelFormularioAlta ------------------------------------------

        botonMenuFormulario.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panelFormularioAlta.setVisible(true);
                scrollPanelFormularioAlta.setVisible(true);

                panelCobroTrabajos.setVisible(false);
                panelTrabajosCobrados.setVisible(false);
            }
        });

        // Listener para el botón del menu que te lleva a panelCobroTrabajos -------------------------------------------

        botonMenuCobro.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panelFormularioAlta.setVisible(false);
                scrollPanelFormularioAlta.setVisible(false);

                panelCobroTrabajos.setVisible(true);
                panelTrabajosCobrados.setVisible(false);
            }
        });

        // Listener para el boton del menu que te lleva al panelYaCobrados ---------------------------------------------

        botonMenuYaCobrados.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panelFormularioAlta.setVisible(false);
                scrollPanelFormularioAlta.setVisible(false);

                panelCobroTrabajos.setVisible(false);
                panelTrabajosCobrados.setVisible(true);
            }
        });

        // Listener para el boton de alta del panelFormularioAlta ------------------------------------------------------

        botonAlta.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int codigoDeError = this.controlDeErrores();
                int indiceTipoVehiculo = comboTipo.getSelectedIndex();
                Vehiculo vehiculo = null;
                TrabajoTaller trabajoTaller;

                // Comprobamos si no tenemos errores
                if(codigoDeError == 0){

                    // Dependiendo del vehículo que seleccionemos, creamos un objeto de ese tipo

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

                    // Creamos el trabajo
                    trabajoTaller = new TrabajoTaller(vehiculo, taDiagnostico.getText(), taSolucion.getText(), Integer.parseInt(tfHorasPrevistas.getText()));

                    // Añadimos el trabajo a la lista
                    controladorTaller.addTrabajo(trabajoTaller);

                    // Usamos setListData para que se actualice la lista
                    listaCobros.setListData(controladorTaller.getTrabajosACobrar().toArray());

                    // Mostramos un mensaje de que ha salido bien
                    showMessageDialog(ventanaDelPrograma, "Trabajo añadido");

                    //Cambiamos la label de trabajos a cobrar
                    tTotal.setText("Total trabajos por cobrar: "+ controladorTaller.getTrabajosACobrar().size());

                } else {
                    // Dependiendo del error, mostramos un mensaje de error
                    switch (codigoDeError) {
                        case 1:
                            showMessageDialog(ventanaDelPrograma, "Por favor rellene todos los campos");
                            break;
                        case 2:
                            showMessageDialog(ventanaDelPrograma, "Especifique las horas en formato numérico");
                            break;
                        case 3:
                            showMessageDialog(ventanaDelPrograma, "Inserte un DNI válido");
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

        // Listener para el botón de cobrar del panelCobroTrabajos -----------------------------------------------------

        botonCobroTrabajo.addActionListener(new ActionListener() {
        @Override
            public void actionPerformed(ActionEvent e) {

                int codigoDeError = controlDeErrores();

                // Cogemos el indice del trabajo que vamos a cobrar

                int indiceTrabajo = listaCobros.getSelectedIndex();

                // Si no hay errores, lo cobramos (por ahora es eliminarlo de la lista de cobros y añadirlo a la lista de cobrados)

                if (codigoDeError == 0) {
                    controladorTaller.cobrarTrabajo(indiceTrabajo);
                } else {

                    // Dependiendo del error, mostramos un mensaje de error

                    switch (codigoDeError) {
                        case 1:
                            showMessageDialog(ventanaDelPrograma, "Por favor seleccione un trabajo");
                            break;
                    }
                }


                // Actualizamos la lista y el contador de trabajos a cobrar, ya que hemos quitado uno

                listaCobros.setListData(controladorTaller.getTrabajosACobrar().toArray());
                tTotal.setText("Total trabajos por cobrar: "+ controladorTaller.getTrabajosACobrar().size());

                // Actualizamos la lista y el contador de trabajos ya cobrados, ya que hemos añadido uno

                listaCobrados.setListData(controladorTaller.getTrabajosRealizados().toArray());
                labelTrabajosCobrados.setText("Total trabajos realizados :" + controladorTaller.getTrabajosRealizados().size());
            }

            private int controlDeErrores() {
                // Comprobamos que hay un trabajo seleccionado, ya que si no saltaría un error
                if (listaCobros.getSelectedIndex() == -1) {
                    return 1;
                }

                return 0;
            }
        });

        /* -------------------------------------------------------------------------------------------------------------

            Este último listener se encargará de "escuchar" cuando la ventana cambia de tamaño, para así poder ajustar
            el tamaño de los insets (los márgenes que tienen los paneles de dentro de panelContenido) y hacerlo más
            responsive.
         */

        ventanaDelPrograma.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {

                // Vamos a necesitar los datos actualizados de la ventana, para ello lo cogemos de lo que escucha el listener
                Component datosVentana = (Component) e.getSource();

                // Sacamos el ancho y alto de la ventana
                int anchoVentana = datosVentana.getWidth();
                int altoVentana = datosVentana.getHeight();

                // Es necesario pasar ciertas configuraciones a GridBagLayout para que funcione

                GridBagConstraints gbcPanelFormulario = new GridBagConstraints();
                GridBagConstraints gbcPanelCobros = new GridBagConstraints();
                GridBagConstraints gbcPanelYaCobrados = new GridBagConstraints();

                // Ahora tenemos que modificar las configuraciones variables para adaptar los paneles

                // CONFIGURACIONES DEL PANEL FORMULARIO ----------------------------------------------------------------

                // Con fill extendemos el panel, y es necesario usar weight distinto de 0 porque si no no se ajusta

                gbcPanelFormulario.fill = GridBagConstraints.BOTH;   // <- BOTH = Horizontal y vertical
                gbcPanelFormulario.weightx = 1;
                gbcPanelFormulario.weighty = 1;

                // Con insets ponemos un margen externo a los paneles

                /*
                    Para el panel formulario usaremos el 5% del ancho de la ventana para cada uno de los margenenes
                    laterales y el 5% del alto de la ventana para los margenes superior e inferior.

                    Estos porcentajes son los que más se acercan a como estaban antes a pantalla completa.

                    Margenes laterales -> (anchoVentana * 5) / 100 -> 5% de ancho de la ventana
                    Margenes superior e inferior -> (altoVentana * 5) / 100 -> 5% de alto de la ventana
                */

                gbcPanelFormulario.insets = new Insets((altoVentana * 5) / 100, (anchoVentana * 5) / 100, (altoVentana * 5) / 100, (anchoVentana * 5) / 100);

                // CONFIGURACIONES DEL PANEL COBROS --------------------------------------------------------------------

                // Con fill extendemos el panel, y es necesario usar weight distinto de 0 porque si no no se ajusta

                gbcPanelCobros.fill = GridBagConstraints.BOTH;   // <- BOTH = Horizontal y vertical
                gbcPanelCobros.weightx = 1;
                gbcPanelCobros.weighty = 1;

                // Con insets ponemos un margen externo a los paneles

                /*
                    Para el panel formulario usaremos el 21% del ancho de la ventana para cada uno de los margenenes
                    laterales y el 20% del alto de la ventana para los margenes superior e inferior.

                    Estos porcentajes son los que más se acercan a como estaban antes a pantalla completa.

                    Margenes laterales -> (anchoVentana * 21) / 100 -> 21% de ancho de la ventana
                    Margenes superior e inferior -> (altoVentana * 20) / 100 -> 20% de alto de la ventana
                */
                gbcPanelCobros.insets = new Insets((altoVentana * 20) / 100, (anchoVentana * 21) / 100, (altoVentana * 20) / 100,(anchoVentana * 21) / 100);


                // CONFIGURACIONES DEL PANEL YA COBRADOS ---------------------------------------------------------------

                gbcPanelYaCobrados.fill = GridBagConstraints.BOTH;
                gbcPanelYaCobrados.weightx = 1;
                gbcPanelYaCobrados.weighty = 1;

                //Usaremos los mismo margenes que en el PanelCobros
                gbcPanelYaCobrados.insets = new Insets((altoVentana * 20) / 100, (anchoVentana * 21) / 100, (altoVentana * 20) / 100,(anchoVentana * 21) / 100);


                // Asignamos las configuraciones al panel correspondiente
                gbl.setConstraints(scrollPanelFormularioAlta, gbcPanelFormulario);
                gbl.setConstraints(panelCobroTrabajos, gbcPanelCobros);
                gbl.setConstraints(panelTrabajosCobrados, gbcPanelYaCobrados);

                // Refrescamos el panelContenido para que se vean los cambios
                panelContenido.repaint();
                panelContenido.revalidate();
            }
        });

    }

    // Métodos Extra ###################################################################################################

}
