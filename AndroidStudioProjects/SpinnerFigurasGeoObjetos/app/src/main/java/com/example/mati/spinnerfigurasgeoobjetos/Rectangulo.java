package com.example.mati.spinnerfigurasgeoobjetos;



/**
 * Created by mati on 4/12/14.
 */
public class Rectangulo extends Figura
{
    protected double base;
    protected double altura;

    public Rectangulo() {
        super("rectángulo");
        base = 10.0;
        altura = 10.0;
    }

    public Rectangulo( double base, double altura) {
        super("rectángulo");
        this.base = base;
        this.altura = altura;
    }

    public double getBase() {
        return base;
    }

    public double getAltura() {
        return altura;
    }

    public void setBase(double base) {
        this.base = base;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public double area(){
        return base * altura;
    }

    public String toString() {
        return "Rectángulo de base " + base + " y altura " + altura;
    }

}
