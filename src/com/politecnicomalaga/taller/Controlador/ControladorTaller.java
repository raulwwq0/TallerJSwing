package com.politecnicomalaga.taller.Controlador;


import com.politecnicomalaga.taller.Modelo.*;

import java.util.ArrayList;


public class ControladorTaller {
    //ESTADO //////////////////////////////////////////////////////////////////////////////////

    // Lista de los tipos de vehiculos para el taller
    protected String[] tiposVehiculo = {"Coche", "Moto", "Furgón", "Camión"};

    // Lista que guarda los trabajos realizados
    protected ArrayList<TrabajoTaller> trabajosRealizados;

    //Lista de Trabajos a cobrar
    protected ArrayList<TrabajoTaller> trabajosACobrar;

    //Variable String para erroes
    protected String mensajeError;

    //El truco
    public static ControladorTaller singleton;

    //CONTRUCTOR //////////////////////////////////////////////////////////////////////////////////

    public ControladorTaller(){
        this.trabajosACobrar = new ArrayList<TrabajoTaller>();
        this.trabajosRealizados = new ArrayList<TrabajoTaller>();
        mensajeError = "";
    }

    //METODOS //////////////////////////////////////////////////////////////////////////////////


    public void cobrarTrabajo(int indice){
        //añadimos a la lista el cobro realizado y se elimina de la lista de cobros pendientes
        trabajosRealizados.add(trabajosACobrar.remove(indice)); //remove también devuelve el objeto que borra
    }

    // llamamos al arrayList para coger el contador
    public ArrayList<TrabajoTaller> getTrabajosRealizados() {
        return trabajosRealizados;
    }

    //Getter de la lista
    public ArrayList<TrabajoTaller> getTrabajosACobrar() {
        return trabajosACobrar;
    }

    public String[] getTiposVehiculo() {
        return tiposVehiculo;
    }

    //El trucamen
    public static ControladorTaller getSingleton(){
        if(singleton == null){
            singleton = new ControladorTaller();
        }
        return singleton;
    }

    public void addTrabajo(TrabajoTaller trabajo){
        trabajosACobrar.add(trabajo);
    }

    public void darAlta(int indiceComboBox, String matricula, String modelo, String propietario, String dni, String diagnostico, String solucion, int horas){
        Vehiculo vehiculo = null;
        TrabajoTaller trabajoTaller;

        //dependiendo del vehiculo que seleccionemos, creamos un objeto de ese tipo
        switch (indiceComboBox){
            case 0: vehiculo = new Coche(matricula, modelo, propietario, dni); break;
            case 1: vehiculo = new Moto(matricula, modelo, propietario, dni); break;
            case 2: vehiculo = new Furgon(matricula, modelo, propietario, dni); break;
            case 3: vehiculo = new Camion(matricula, modelo, propietario, dni); break;
        }

        // Dependiendo del vehiculo que seleccionemos, creamos un objeto de ese tipo; Creamos el trabajo
        trabajoTaller = new TrabajoTaller(vehiculo, diagnostico, solucion, horas);

        // Añadimos el trabajo a la lista
        addTrabajo(trabajoTaller);
    }
}
