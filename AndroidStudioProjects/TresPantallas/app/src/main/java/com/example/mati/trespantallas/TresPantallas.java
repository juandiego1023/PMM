package com.example.mati.trespantallas;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class TresPantallas extends Activity {
    protected static final int REQUEST_CODE=0;
    public Button botonPant2;
    public Button botonPant3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tres_pantallas);

        botonPant2= (Button)findViewById(R.id.buttonPant2);
        botonPant3= (Button)findViewById(R.id.buttonPant3);

        botonPant2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                Intent miIntent = new Intent(TresPantallas.this, PantallaDos.class);

                startActivityForResult(miIntent, REQUEST_CODE);
            }
        });

        botonPant3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                Intent miIntent = new Intent(TresPantallas.this, PantallaTres.class);

                startActivityForResult(miIntent, REQUEST_CODE);
            }
        });
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        //super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE) {
            // cogemos el valor devuelto por la otra actividad
            String result = data.getStringExtra("result");
            // enseñamos al usuario el resultado
            Toast.makeText(this, "Activity devolvió: " + result, Toast.LENGTH_LONG).show();

        }

    }


}
