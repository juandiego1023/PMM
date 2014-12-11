package com.example.juandiegoariasmartin.spinnerclase;

import android.widget.ImageView;

/**
 * Created by juandiegoariasmartin on 11/11/14.
 */
public class Personas {
        private  String apellido;
        private  String nombre;
        private  int edad;
        private  int foto;

        public Personas(String a, String n, int e, int f){
            apellido=a;
            nombre=n;
            edad=e;
            foto=f;
        }

        public String getApellido(){

            return apellido;
        }

        public String getNombre()
        {
            return nombre;
        }

        public int getEdad(){

            return edad;
        }

        public int getFoto(){

            return foto;
        }

        public String toString(){
            String cad="";
            cad+=nombre + '\n' + apellido + '\n' + edad+ '\n' + foto;
            return cad;
        }


}

