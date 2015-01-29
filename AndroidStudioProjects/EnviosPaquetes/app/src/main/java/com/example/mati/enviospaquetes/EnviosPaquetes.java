package com.example.mati.enviospaquetes;

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
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;


public class EnviosPaquetes extends Activity {

    public Spinner miSpinner;

    private Button calcular;
    private RadioButton rbNormal,rbUrgente;
    private CheckBox chkBoxCaja,chkBoxTarjeta;
    public String tipoDestino;
    private EditText peso;

    public Destinos[] destinos =
            new Destinos[]{
                    new Destinos("Zona A","Asia",30),
                    new Destinos("Zona B","America",20),
                    new Destinos("Zona C","Europa",10)
            };



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_envios_paquetes);

        miSpinner = (Spinner) findViewById(R.id.spinner);
        miSpinner.setBackgroundColor(Color.argb(127, 255, 255, 0));

        rbNormal=(RadioButton)findViewById(R.id.rbNormal);
        rbUrgente=(RadioButton)findViewById(R.id.rbUrgente);
        chkBoxCaja=(CheckBox)findViewById(R.id.checkBoxCaja);
        chkBoxTarjeta=(CheckBox)findViewById(R.id.checkBoxTarjeta);

        peso= (EditText)findViewById(R.id.eTpeso);

        calcular= (Button)findViewById(R.id.buttonCalculos);
        //calcular.setBackgroundColor(Color.argb(71,71,225,0));

        AdaptadorFigura miAdaptador = new AdaptadorFigura(this);
        miSpinner.setAdapter(miAdaptador);


        miSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            public void onItemSelected(AdapterView arg0, View arg1, final int position, long id) {

                tipoDestino=destinos[position].getZona();
                showToast("Tipo de destino" + tipoDestino);

                switch(position){
                    case 0:

                        break;
                    case 1:
                        calcular.setOnClickListener(new View.OnClickListener() {
                            public void onClick(View v) {
                                //int precioClase=30;
                                int precioClase=destinos[position].getPrecio();
                                showToast("Precio clase" + precioClase);

                                String stPeso=peso.getText().toString();
                                int intPeso=Integer.parseInt(stPeso);

                                if(intPeso<=5){
                                    int pesoCinco=intPeso*1;
                                    precioClase=precioClase+pesoCinco;
                                }

                                if((intPeso>=6) || (intPeso<=10) ){
                                    int pesoDiez=intPeso*2;
                                    precioClase=precioClase+pesoDiez;
                                }


                                if(intPeso>=10){
                                    int pesoVeinte=intPeso*3;
                                    precioClase=precioClase+pesoVeinte;
                                }


                                if (rbUrgente.isChecked()==true) {
                                    precioClase=(precioClase*30/100)+precioClase;
                                }

                                String StringPrecioClase=String.valueOf(precioClase);
                                pasoPantalla(tipoDestino,StringPrecioClase);


                            }
                        });
                        break;


                    case 2:

                        break;






                }

            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }

        });





    }
    public void pasoPantalla(String tipoDestino, String StringPrecioClase){

        Intent miIntent = new Intent(EnviosPaquetes.this, PantallaDos.class);
        Bundle miBundle = new Bundle();

        miBundle.putString("destino", tipoDestino);
        miBundle.putString("precio", StringPrecioClase);


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
                //holder.lugar = (TextView) item.findViewById(R.id.campoLugar);
                //holder.precio = (TextView) item.findViewById(R.id.campoPrecio);


                item.setTag(holder);
            }else{
                holder=(ViewHolder)item.getTag();
            }

            holder.zona.setText(destinos[position].getZona());
            //holder.lugar.setText(destinos[position].getLugar());
            //holder.precio.setText(destinos[position].getPrecio());


            return item;
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.envios_paquetes, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void showToast(String text) {
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show();
    }

}
