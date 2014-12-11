package com.example.juandiegoariasmartin.spinnerclase;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by mati on 13/11/14.
 */
public class PantallaDos extends Activity{
    @Override
    protected void onCreate(Bundle savedInstanceState){

        super.onCreate(savedInstanceState);
        setContentView(R.layout.pantalla_dos);

        final Button botonVolver= (Button)findViewById(R.id.buttonVolver);
        final TextView miApellido= (TextView)findViewById(R.id.miApellido);
        final TextView miNombre= (TextView)findViewById(R.id.miNombre);
        final TextView miEdad= (TextView)findViewById(R.id.miEdad);
        final ImageView miFoto= (ImageView)findViewById(R.id.miFoto);

        botonVolver.setOnClickListener( new View.OnClickListener(){
            public void onClick(View v){
                Intent vueltaIntent= new Intent();
                setResult(RESULT_OK, vueltaIntent);
                finish();

            }

        });

        Bundle  miBundleRecoger = getIntent().getExtras();

        String recuperamos_variable_apellido = getIntent().getStringExtra("seleccionApe");
        String recuperamos_variable_nombre = getIntent().getStringExtra("seleccionNom");
        String recuperamos_variable_edad = getIntent().getStringExtra("seleccionEdad");
        String recuperamos_variable_foto = getIntent().getStringExtra("seleccionFoto");

        int conv_int_imgView_foto = PantallaDos.this.getResources().getIdentifier(recuperamos_variable_foto, null, PantallaDos.this.getPackageName());

        miApellido.setText(recuperamos_variable_apellido);
        miNombre.setText(recuperamos_variable_nombre);
        miEdad.setText(recuperamos_variable_edad);
        miFoto.setImageResource(conv_int_imgView_foto);


    }

}
