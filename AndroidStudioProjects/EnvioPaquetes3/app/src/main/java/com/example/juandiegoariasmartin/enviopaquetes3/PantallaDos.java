package com.example.juandiegoariasmartin.enviopaquetes3;

import android.app.Activity;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by juandiegoariasmartin on 29/1/15.
 */
public class PantallaDos extends Activity {
    private ImageView miImagen;
    private Button botonGrabar;
    private String zonaDestinoRecibidoGrabar,precioDestinoRecibidoGrabar,imagenDestinoRecibido;
    private TextView zonaDestinoRecibido,continenteDestinoRecibido,precioDestinoRecibido,pesoDestinoRecibido,tarifaTipoDestinoRecibido,boxCajaDestinoRecibido,boxDedicatoriaDestinoRecibido;
    private ResultadosSQLiteHelper cliBDh = new ResultadosSQLiteHelper(this, "DBResultados", null, 1);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pantalla_dos);

        botonGrabar= (Button)findViewById(R.id.buttonGrabar);
        zonaDestinoRecibido= (TextView)findViewById(R.id.tvZonaDestinoRecibido);
        continenteDestinoRecibido= (TextView)findViewById(R.id.tvcontinenteDestinoRecibido);
        precioDestinoRecibido= (TextView)findViewById(R.id.tvprecioDestinoRecibido);
        pesoDestinoRecibido= (TextView)findViewById(R.id.tvpesoDestinoRecibido);
        tarifaTipoDestinoRecibido=(TextView)findViewById(R.id.tvtarifaTipoDestinoRecibido);
        boxCajaDestinoRecibido=(TextView)findViewById(R.id.tvBoxCajaDestinoRecibido);
        boxDedicatoriaDestinoRecibido=(TextView)findViewById(R.id.tvBoxDedicatoriaDestinoRecibido);
        miImagen= (ImageView)findViewById(R.id.miImagen);

        Bundle miBundleRecoger = getIntent().getExtras();
        zonaDestinoRecibido.setText(miBundleRecoger.getString("zonaDestino"));
        continenteDestinoRecibido.setText(miBundleRecoger.getString("continenteDestino"));
        precioDestinoRecibido.setText(miBundleRecoger.getString("precioDestino"));
        pesoDestinoRecibido.setText(miBundleRecoger.getString("pesoDestino"));
        tarifaTipoDestinoRecibido.setText(miBundleRecoger.getString("tarifaTipoDestino"));
        boxCajaDestinoRecibido.setText(miBundleRecoger.getString("boxCajaDestino"));
        boxDedicatoriaDestinoRecibido.setText(miBundleRecoger.getString("boxDedicatoriaDestino"));
        imagenDestinoRecibido = getIntent().getStringExtra("imagenDestino");

        int conv_int_imgView_imagen = PantallaDos.this.getResources().getIdentifier(imagenDestinoRecibido, null, PantallaDos.this.getPackageName());
        miImagen.setImageResource(conv_int_imgView_imagen);

        zonaDestinoRecibidoGrabar=miBundleRecoger.getString("zonaDestino");
        precioDestinoRecibidoGrabar=miBundleRecoger.getString("precioDestino");


        botonGrabar.setOnClickListener( new View.OnClickListener(){
            public void onClick(View v){

                //Abrimos la base de datos en modo escritura

                //Obtenemos referencia a la base de datos para poder modificarla.
                SQLiteDatabase bd = cliBDh.getWritableDatabase();

                //En caso de abrir de forma correcta la base de datos
                if (bd!=null) {


                    String sql = "INSERT INTO Resultados (zonaDestino,precioDestino) VALUES ('"+ zonaDestinoRecibidoGrabar + "','"+ precioDestinoRecibidoGrabar +"') ";

                    bd.execSQL(sql);


                }
                //Cerramos la base de datos
                bd.close();

            }

        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_envio_paquetes3, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.grabar) {
            SQLiteDatabase bd = cliBDh.getWritableDatabase();

            //En caso de abrir de forma correcta la base de datos
            if (bd!=null) {


                String sql = "INSERT INTO Resultados (zonaDestino,precioDestino) VALUES ('"+ zonaDestinoRecibidoGrabar + "','"+ precioDestinoRecibidoGrabar +"') ";

                bd.execSQL(sql);


            }
            //Cerramos la base de datos
            bd.close();

            showToast("Se ha insertado un registro en la base de datos");

            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    public void showToast(String text) {
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show();
    }
}
