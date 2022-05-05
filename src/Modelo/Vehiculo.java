package Modelo;

public class Vehiculo {
    //ESTADO
    protected String matricula;
    protected String modelo;
    protected String propietario;
    protected char dniPropietario;

    //COMPORTAMIENTO
    //Constructor
    public Vehiculo(String nMatricula, String nModelo, String nPropietario, char nDniPropietario){
        this.matricula = nMatricula;
        this.modelo = nModelo;
        this.propietario = nPropietario;
        this.dniPropietario = nDniPropietario;
    }

    //otros métodos
    //getter y setter
    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getPropietario() {
        return propietario;
    }

    public void setPropietario(String propietario) {
        this.propietario = propietario;
    }

    public char getDniPropietario() {
        return dniPropietario;
    }

    public void setDniPropietario(char dniPropietario) {
        this.dniPropietario = dniPropietario;
    }

    @Override
    public String toString() {
        return "Vehiculo{" +
                "matricula='" + matricula + '\'' +
                ", modelo='" + modelo + '\'' +
                ", propietario='" + propietario + '\'' +
                ", dniPropietario=" + dniPropietario +
                '}';
    }
}