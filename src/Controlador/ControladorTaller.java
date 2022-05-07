package Controlador;


import Modelo.TrabajoTaller;
import java.util.ArrayList;


public class ControladorTaller {
    //ESTADO //////////////////////////////////////////////////////////////////////////////////

    // Lista de los tipos de vehiculos para el taller
    protected String[] tiposVehiculo = {"Coche", "Moto", "Furgón", "Camión"};

    //Lista de Trabajos a cobrar
    protected ArrayList<TrabajoTaller> trabajosACobrar;

    //Contador de trabajos cobrados
    protected int contadorCobros;

    //Variable String para erroes
    protected String mensajeError;

    //CONTRUCTOR //////////////////////////////////////////////////////////////////////////////////

    public ControladorTaller(){
        this.trabajosACobrar = new ArrayList<TrabajoTaller>();
        contadorCobros = 0;
        mensajeError = "";
    }

    //METODOS //////////////////////////////////////////////////////////////////////////////////


    public void cobrarTrabajo(int indice){
        trabajosACobrar.remove(indice);
        contadorCobros ++;
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
}
