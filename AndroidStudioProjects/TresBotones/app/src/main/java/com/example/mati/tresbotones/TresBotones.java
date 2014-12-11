package com.example.mati.tresbotones;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class TresBotones extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tres_botones);

        final EditText nombre= (EditText)findViewById(R.id.editTextNombre);
        final Button botonNormal= (Button)findViewById(R.id.buttonNormal);

        botonNormal.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                botonNormal.setText("Pulsado");
                Toast.makeText(getBaseContext(), "Has pulsado Normal!", Toast.LENGTH_SHORT).show();
                Intent miIntent = new Intent(TresBotones.this, Normal.class);

                Bundle miBundle=new Bundle();
                String envioNombre="" + nombre.getText();
                miBundle.putString("", envioNombre);
                miIntent.putExtras(miBundle);

                Toast.makeText(getBaseContext(), nombre.getText(), Toast.LENGTH_SHORT).show();
                startActivity(miIntent);
            }

        });
    }

    public void xml_click(View v) {
        Toast.makeText(getBaseContext(), "Has pulsado Xml!", Toast.LENGTH_SHORT).show();
        Intent miIntent = new Intent(TresBotones.this, Xml.class);
        startActivity(miIntent);
    }

}



