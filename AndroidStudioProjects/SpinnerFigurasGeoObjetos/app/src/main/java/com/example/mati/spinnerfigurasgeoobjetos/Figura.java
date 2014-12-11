package com.example.mati.spinnerfigurasgeoobjetos;



/**
 * Created by mati on 4/12/14.
 */
public class Figura
{

    protected String tipo;

    public Figura() {
        tipo = "indefinido";
    }

    public Figura(String tipo) {

        this.tipo = tipo;
    }

    public String getTipo() {
        return tipo;
    }





    public String toString(){
        return "Figura de tipo: " + tipo ;
    }


}
