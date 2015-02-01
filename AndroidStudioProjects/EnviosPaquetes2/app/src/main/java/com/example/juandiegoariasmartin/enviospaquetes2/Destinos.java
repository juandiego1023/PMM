package com.example.juandiegoariasmartin.enviospaquetes2;

/**
 * Created by juandiegoariasmartin on 29/1/15.
 */
public class Destinos {
    private String zona;
    private String continente;
    private float precio;

    public Destinos(String z,String c,float p) {
        zona = z;
        continente = c;
        precio = p;

    }

    public String getZona(){
        return zona;
    }

    public String getContinente(){
        return continente;
    }

    public float getPrecio(){
        return precio;
    }

}
