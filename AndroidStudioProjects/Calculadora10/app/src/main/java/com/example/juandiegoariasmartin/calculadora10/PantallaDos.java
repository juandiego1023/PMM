package com.example.juandiegoariasmartin.calculadora10;

import android.app.Activity;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by juandiegoariasmartin on 9/11/14.
 */
public class PantallaDos extends Activity {
    private Button botonVolver;
    private Button botonGrabar;
    private TextView tvResRecTitulo;
    private TextView resultadoRecibido;
    private int resultadoRecibidoInt;
    private ResultadosSQLiteHelper cliBDh = new ResultadosSQLiteHelper(this, "DBResultados", null, 1);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla_dos);

            botonVolver= (Button)findViewById(R.id.buttonVolver);
            botonGrabar= (Button)findViewById(R.id.buttonGrabar);
            tvResRecTitulo= (TextView)findViewById(R.id.tvResRecTitulo);
            resultadoRecibido= (TextView)findViewById(R.id.tvResultadoRecibido);

            botonVolver.setOnClickListener( new View.OnClickListener(){
                public void onClick(View v){
                    Intent vueltaIntent= new Intent();
                    setResult(RESULT_OK, vueltaIntent);
                    finish();
                }
            });

            Bundle  miBundleRecoger = getIntent().getExtras();
            resultadoRecibido.setText(miBundleRecoger.getString("TEXTO"));

           resultadoRecibidoInt=Integer.parseInt(miBundleRecoger.getString("TEXTO"));

            boolean siEsPositivoResultado=resultadoRecibidoInt>0;
            if(siEsPositivoResultado){
                tvResRecTitulo.setTextColor(Color.BLUE);
                resultadoRecibido.setTextColor(Color.BLUE);

            }else {
                tvResRecTitulo.setTextColor(Color.RED);
                resultadoRecibido.setTextColor(Color.RED);
            }

            botonGrabar.setOnClickListener( new View.OnClickListener(){
                public void onClick(View v){

                    //Abrimos la base de datos en modo escritura

                    //Obtenemos referencia a la base de datos para poder modificarla.
                    SQLiteDatabase bd = cliBDh.getWritableDatabase();

                    //En caso de abrir de forma correcta la base de datos
                    if (bd!=null) {
                            int total =resultadoRecibidoInt;
                            //Introducimos los datos en la tabla resultados
                            bd.execSQL("INSERT INTO Resultados (total) " +
                                    "VALUES ("+total+")");
                    }
                    //Cerramos la base de datos
                    bd.close();

                }

        });


    }
}

