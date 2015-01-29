package com.example.mati.calculadoraspinnerclase;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by juandiegoariasmartin on 9/11/14.
 */
public class PantallaDos extends Activity {
    private Button botonVolver,botonGrabar,botonConsultar;

    private TextView tvResRecTitulo,txtResultado;
    private TextView numeroUnoRecibido,numeroDosRecibido,resultadoRecibido;
    private int numeroUnoRecibidoInt,numeroDosRecibidoInt,resultadoRecibidoInt;
    private String tipoOperandoRecibido;
    private ResultadosSQLiteHelper cliBDh = new ResultadosSQLiteHelper(this, "DBResultados", null, 1);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla_dos);

            botonVolver= (Button)findViewById(R.id.buttonVolver);
            botonGrabar= (Button)findViewById(R.id.buttonGrabar);
            botonConsultar= (Button)findViewById(R.id.buttonConsultar);
            tvResRecTitulo= (TextView)findViewById(R.id.tvResRecTitulo);
            numeroUnoRecibido= (TextView)findViewById(R.id.tvNumeroUnoRecibido);
            numeroDosRecibido= (TextView)findViewById(R.id.tvNumeroDosRecibido);
            resultadoRecibido= (TextView)findViewById(R.id.tvResultadoRecibido);
            txtResultado = (TextView)findViewById(R.id.txtResultado);


            botonVolver.setOnClickListener( new View.OnClickListener(){
                public void onClick(View v){
                    Intent vueltaIntent= new Intent();
                    setResult(RESULT_OK, vueltaIntent);
                    finish();
                }
            });

            Bundle miBundleRecoger = getIntent().getExtras();
            numeroUnoRecibido.setText(miBundleRecoger.getString("numeroUno"));
            numeroDosRecibido.setText(miBundleRecoger.getString("numeroDos"));
            resultadoRecibido.setText(miBundleRecoger.getString("resultado"));

            numeroUnoRecibidoInt= Integer.parseInt(miBundleRecoger.getString("numeroUno"));
            numeroDosRecibidoInt= Integer.parseInt(miBundleRecoger.getString("numeroDos"));

            resultadoRecibidoInt= Integer.parseInt(miBundleRecoger.getString("resultado"));

            tipoOperandoRecibido = getIntent().getStringExtra("tipoOperando");


            botonGrabar.setOnClickListener( new View.OnClickListener(){
                public void onClick(View v){
                    showToast("tipo operando click "+tipoOperandoRecibido+" grabado");
                    //Abrimos la base de datos en modo escritura

                    //Obtenemos referencia a la base de datos para poder modificarla.
                    SQLiteDatabase bd = cliBDh.getWritableDatabase();

                    //En caso de abrir de forma correcta la base de datos
                    if (bd!=null) {
                            int num1=numeroUnoRecibidoInt;
                            int num2=numeroDosRecibidoInt;
                            int total =resultadoRecibidoInt;

                        String sql = "INSERT INTO Resultados (num1,num2,total,tipoOperandoRecibido) VALUES (" + num1 + "," + num2 + "," + total + ",'"+ tipoOperandoRecibido + "') ";

                        bd.execSQL(sql);


                    }
                    //Cerramos la base de datos
                    bd.close();

                }

        });
        botonConsultar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                SQLiteDatabase bd = cliBDh.getWritableDatabase();

                Cursor c = bd.rawQuery("SELECT num1, num2,total,tipoOperandoRecibido FROM Resultados", null);

                //Recorremos los resultados para mostrarlos en pantalla
                txtResultado.setText("");
                if (c.moveToFirst()) {
                    //Recorremos el cursor hasta que no haya m�s registros
                    do {
                        String num1 = c.getString(0);
                        String num2 = c.getString(1);
                        String total = c.getString(2);
                        String tipoOperandoRecibido = c.getString(3);

                        txtResultado.append(" " + num1 + " - '" + tipoOperandoRecibido + "' - " + num2 + " = " + total + "\n");


                    } while(c.moveToNext());
                }
            }
        });


    }

    public void showToast(String text) {
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show();
    }
}

