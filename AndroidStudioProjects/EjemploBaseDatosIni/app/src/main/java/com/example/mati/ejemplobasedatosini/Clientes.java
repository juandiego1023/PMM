package com.example.mati.ejemplobasedatosini;

/**
 * Created by mati on 8/01/15.
 */
public class Clientes {
    private  int codigo;
    private  String nombre;
    private  String telefono;

    public Clientes(int c, String n, String t){
        codigo=c;
        nombre=n;
        telefono=t;
    }

    public int getCodigo(){
        return codigo;
    }

    public String getNombre()
    {
        return nombre;
    }

    public String getTelefono(){

        return telefono;
    }


}
