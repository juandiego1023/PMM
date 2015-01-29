package com.example.mati.enviospaquetes;

/**
 * Created by mati on 29/01/15.
 */
public class Destinos {

    protected String zona;
    protected String lugar;
    protected int precio;

    public Destinos(String z, String l, int p){
        zona=z;
        lugar=l;
        precio=p;
    }

    public String getZona(){
        return zona;
    }

    public String getLugar(){
        return lugar;
    }

    public int getPrecio(){
        return precio;
    }
}
