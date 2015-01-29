package com.example.mati.enviospaquetes;

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


    private TextView precioRecibido, destinoRecibido;
    private int precioRecibidoInt,numeroDosRecibidoInt,resultadoRecibidoInt;
   // private String tipoOperandoRecibido;
   // private ResultadosSQLiteHelper cliBDh = new ResultadosSQLiteHelper(this, "DBResultados", null, 1);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pantalla_dos);

            destinoRecibido= (TextView)findViewById(R.id.tvDestinoRecibido);
            precioRecibido= (TextView)findViewById(R.id.tvCosteFinal);






            Bundle miBundleRecoger = getIntent().getExtras();
            destinoRecibido.setText(miBundleRecoger.getString("destino"));
            precioRecibido.setText(miBundleRecoger.getString("precio"));







    }

    public void showToast(String text) {
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show();
    }
}

