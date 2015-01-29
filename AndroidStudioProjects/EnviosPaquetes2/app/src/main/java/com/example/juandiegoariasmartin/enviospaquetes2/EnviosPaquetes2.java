package com.example.juandiegoariasmartin.enviospaquetes2;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;


public class EnviosPaquetes2 extends Activity {
    private Spinner miSpinner;
    private String zonaDestino,continenteDestino,pesoDestino;
    private float precioUrgente,precioDestino;
    private Button calcular;
    private EditText eTpeso;
    private RadioButton rbUrgente;
    private int pesoCoste;


    public Destinos[] destinos =
            new Destinos[]{
                    new Destinos("Seleccione","una opcion",0),
                    new Destinos("Zona A","Asia",10),
                    new Destinos("Zona B","America",20),
                    new Destinos("Zona C","Europa",30)
            };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_envios_paquetes2);

        miSpinner = (Spinner) findViewById(R.id.spinner);
        calcular= (Button)findViewById(R.id.buttonCalcular);
        eTpeso= (EditText)findViewById(R.id.etPeso);

        rbUrgente=(RadioButton)findViewById(R.id.rBurgente);

        AdaptadorFigura miAdaptador = new AdaptadorFigura(this);
        miSpinner.setAdapter(miAdaptador);

        miSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            public void onItemSelected(AdapterView arg0, View arg1,final int position, long id) {

                zonaDestino=destinos[position].getZona();
                showToast("Tipo de destino elegido: "+zonaDestino);

                zonaDestino=destinos[position].getZona();
                continenteDestino=destinos[position].getContinente();
                precioDestino=destinos[position].getPrecio();

                switch(position){
                    case 0:
                        break;
                    case 1:
                        break;
                    case 2:
                        break;

                }




                calcular.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) {
                        if (rbUrgente.isChecked()==true) {
                            precioUrgente=(precioDestino*30/100);

                        }
                        pesoDestino=eTpeso.getText().toString();
                        showToast("Peso destino: "+pesoDestino);

                        pesoCoste=Integer.parseInt(pesoDestino);
                        showToast("El peso coste antes de los if es de: "+pesoCoste);
                        if(pesoCoste<=5){
                            showToast("Entro en if de 5");
                            pesoCoste=pesoCoste*1;
                        }else if((pesoCoste>=6)||(pesoCoste<=10) ){
                            showToast("Entro en if entre 6 y 10");
                            pesoCoste=pesoCoste*2;
                        }else if(pesoCoste>=10){
                            showToast("Entro en if de 10");
                            pesoCoste=pesoCoste*3;
                        }

                        precioDestino=precioDestino+precioUrgente+pesoCoste;

                        pasoPantalla(zonaDestino,continenteDestino,precioDestino,pesoDestino);

                    }
                });







            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }

        });

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_envios_paquetes2, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    public void pasoPantalla(String zonaDestino,String continenteDestino,float precioDestino, String pesoDestino){

        Intent miIntent = new Intent(EnviosPaquetes2.this, PantallaDos.class);
        Bundle miBundle = new Bundle();

        miBundle.putString("zonaDestino", zonaDestino);
        miBundle.putString("continenteDestino", continenteDestino);
        miBundle.putString("precioDestino", String.valueOf(precioDestino));
        miBundle.putString("pesoDestino", pesoDestino);


        miIntent.putExtras(miBundle);

        startActivity(miIntent);
    }

    class AdaptadorFigura extends ArrayAdapter<Destinos> {
        public Activity miActividad;

        public AdaptadorFigura(Activity laActividad){
            super(laActividad, R.layout.spinner_contenido, destinos);
            this.miActividad=laActividad;
        }

        public View getDropDownView(int position, View convertView, ViewGroup parent){
            View vistaDesplegada=getView(position, convertView, parent);
            return vistaDesplegada;
        }

        public View getView(int position, View convertView, ViewGroup parent){
            View item=convertView;
            ViewHolder holder;

            if(item==null) {

                LayoutInflater inflater = miActividad.getLayoutInflater();
                item = inflater.inflate(R.layout.spinner_contenido, null);

                holder = new ViewHolder();

                holder.zona = (TextView) item.findViewById(R.id.campoZona);
                holder.continente = (TextView) item.findViewById(R.id.campoContinente);
                holder.precio = (TextView) item.findViewById(R.id.campoPrecio);



                item.setTag(holder);
            }else{
                holder=(ViewHolder)item.getTag();
            }

            holder.zona.setText(destinos[position].getZona());
            holder.continente.setText(destinos[position].getContinente());
            holder.precio.setText(String.valueOf(destinos[position].getPrecio()));

            return item;
        }
    }

    public void showToast(String text) {
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show();
    }

}
