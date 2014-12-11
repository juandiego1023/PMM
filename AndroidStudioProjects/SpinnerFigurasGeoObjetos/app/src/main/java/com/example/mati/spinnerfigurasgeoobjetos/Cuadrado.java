package com.example.mati.spinnerfigurasgeoobjetos;



/**
 * Created by mati on 4/12/14.
 */
public class Cuadrado extends Rectangulo
{
    public Cuadrado()
    {   super();
        tipo = "cuadrado";
    }

    public Cuadrado(double lado) {

        super(lado,lado);
        tipo = "cuadrado";
    }

    public double getLado() {
        return base;
    }

    public void setLado(double lado) {
        base = altura = lado;
    }

    public void setBase(double base) {
        this.base = this.altura = base;
    }

    public void setAltura(double altura) {
        this.base = this.altura = altura;
    }

    public String toString(){
        return "Cuadrado de lado " + getLado();
    }
}
