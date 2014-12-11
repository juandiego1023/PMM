package com.example.juandiegoariasmartin.calculadora10;

/**
 * Created by juandiegoariasmartin on 9/11/14.
 */
public class Numero {
    private int num;

    public Numero(){
        num=10;
    }

    public Numero(int n){
        num=n;
    }

    public int getNumero(){
        return num;
    }

    public void setNumero(int n){
        num=n;
    }

    public static int sumando(int n1, int n2){
        return (n1+n2);
    }

    public static int restando(int n1, int n2){
        return (n1-n2);
    }

}
