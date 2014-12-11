package com.example.mati.spinnerfigurasgeoobjetos;



/**
 * Created by mati on 4/12/14.
 */
public class Circulo extends Figura
{
    protected double radio;

    public Circulo() {
        super("círculo");
        radio = 10.0;
    }

    public Circulo(double radio) {
        super("circulo");
        this.radio = radio;
    }

    public double getRadio() {
        return this.radio;
    }

    public void setRadio(double radio) {
        this.radio = radio;
    }

    public double area() {
        return Math.PI * radio * radio;
    }

    public String toString(){
        return "Círculo de radio " + radio;
    }
}
