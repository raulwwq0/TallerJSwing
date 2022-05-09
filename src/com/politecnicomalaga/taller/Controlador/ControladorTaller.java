package com.politecnicomalaga.taller.Controlador;


import com.politecnicomalaga.taller.Modelo.TrabajoTaller;
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

    public void addTrabajo(TrabajoTaller trabajo){
        trabajosACobrar.add(trabajo);
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
}
