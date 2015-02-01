package com.example.juandiegoariasmartin.enviopaquetes3;

/**
 * Created by juandiegoariasmartin on 29/1/15.
 */
public class Destinos {
    private String zona;
    private String continente;
    private float precio;
    private  int foto;

    public Destinos(String z, String c, float p, int f) {
        zona = z;
        continente = c;
        precio = p;
        foto=f;

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

    public int getFoto(){
        return foto;
    }

}
