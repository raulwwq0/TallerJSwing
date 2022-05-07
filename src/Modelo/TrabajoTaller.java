package Modelo;

import java.util.Date;

public class TrabajoTaller {
    //ESTADO
    protected Vehiculo miVehiculo;
    protected Date fechaEntrada;
    protected String diagnostico;
    protected String resolucion; //lo que el mecánico ha dicho que hay que hacer
    protected float hTrabPrevistas; //horas trabajadas previstas
    protected float hTrabRealizadas; //horas trabajadas realizadas

    //COMPORTAMIENTO
    //Constructor
    public TrabajoTaller(Vehiculo miVehiculo, String diagnostico, String resolucion, float hTrabPrevistas){
        this.diagnostico = diagnostico;
        this.resolucion = resolucion;
        this.hTrabPrevistas = hTrabPrevistas;
        hTrabRealizadas = 0; //ponemos 0 porque cuando se crea no hay ninguna hora realizada
        this.miVehiculo = miVehiculo;
        fechaEntrada = new Date(); //usa el horario actual
    }

    //Sobrecarga de constructor
    public TrabajoTaller(Vehiculo miVehiculo, String diagnostico, String resolucion, float hTrabPrevistas, Date fechaEntrada){
        this.diagnostico = diagnostico;
        this.resolucion = resolucion;
        this.hTrabPrevistas = hTrabPrevistas;
        hTrabRealizadas = 0; //ponemos 0 porque cuando se crea no hay ninguna hora realizada
        this.miVehiculo = miVehiculo;
        this.fechaEntrada = fechaEntrada;
    }

    public Vehiculo getMiVehiculo() {
        return miVehiculo;
    }

    public void setMiVehiculo(Vehiculo miVehiculo) {
        this.miVehiculo = miVehiculo;
    }

    public Date getFechaEntrada() {
        return fechaEntrada;
    }

    public void setFechaEntrada(Date fechaEntrada) {
        this.fechaEntrada = fechaEntrada;
    }

    public String getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }

    public String getResolucion() {
        return resolucion;
    }

    public void setResolucion(String resolucion) {
        this.resolucion = resolucion;
    }

    public float gethTrabPrevistas() {
        return hTrabPrevistas;
    }

    public void sethTrabPrevistas(float hTrabPrevistas) {
        this.hTrabPrevistas = hTrabPrevistas;
    }

    public float gethTrabRealizadas() {
        return hTrabRealizadas;
    }

    public void sethTrabRealizadas(float hTrabRealizadas) {
        this.hTrabRealizadas = hTrabRealizadas;
    }

    @Override
    public String toString() {
        return "<html>" +
                "TrabajoTaller{" +
                "<br> &emsp; miVehiculo=" + miVehiculo +
                "<br> &emsp; fechaEntrada=" + fechaEntrada +
                "<br> &emsp; diagnostico='" + diagnostico + '\'' +
                "<br> &emsp; resolucion='" + resolucion + '\'' +
                "<br> &emsp; hTrabPrevistas=" + hTrabPrevistas +
                "<br> &emsp; hTrabRealizadas=" + hTrabRealizadas +
                "<br> }" +
                "</html>";
    }
}
