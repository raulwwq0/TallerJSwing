package com.politecnicomalaga.taller.Modelo;

public class Coche extends Vehiculo{

    public static final float precio = 25f;
    public Coche(String matricula,String modelo ,String propietario ,String DniPropietario){
        super(matricula,modelo,propietario,DniPropietario);
        tipo = "Coche";
    }
}