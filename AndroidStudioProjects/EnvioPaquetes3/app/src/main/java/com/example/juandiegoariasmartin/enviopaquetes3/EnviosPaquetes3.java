package com.example.juandiegoariasmartin.enviopaquetes3;


import android.app.Activity;
import android.content.Intent;
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
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;


public class EnviosPaquetes3 extends Activity {
    private Spinner miSpinner;
    private String zonaDestino,continenteDestino,pesoDestino,tarifaTipoDestino,boxCajaDestino,boxDedicatoriaDestino,imagenDestino;
    private float precioUrgente,precioDestino;
    private Button calcular;
    private EditText eTpeso;
    private RadioButton rbUrgente,rbNormal;
    private CheckBox chkBoxCaja,chkBoxTarjeta;
    private int pesoCoste;

    public static boolean isFirst=true;

    public Destinos[] destinos =
            new Destinos[]{
                    new Destinos("Zona A","Asia-Oceania",10,R.drawable.asia_oceania),
                    new Destinos("Zona B","America-Africa",20,R.drawable.america_africa),
                    new Destinos("Zona C","Europa",30,R.drawable.europa)
            };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_envio_paquetes3);

        miSpinner = (Spinner) findViewById(R.id.spinner);
        calcular= (Button)findViewById(R.id.buttonCalcular);

        eTpeso= (EditText)findViewById(R.id.etPeso);

        rbUrgente=(RadioButton)findViewById(R.id.rBurgente);
        rbNormal=(RadioButton)findViewById(R.id.rBnormal);

        chkBoxCaja=(CheckBox)findViewById(R.id.checkBoxCaja);
        chkBoxTarjeta=(CheckBox)findViewById(R.id.checkBoxTarjeta);

        AdaptadorFigura miAdaptador = new AdaptadorFigura(this);
        miSpinner.setAdapter(miAdaptador);

        chkBoxCaja.setOnCheckedChangeListener(new CheckBox.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView,boolean isChecked) {
                if (isChecked) {
                    boxCajaDestino="Caja regalo";
                    showToast("boxCajaDestino: "+boxCajaDestino);
                }
                else {
                    boxCajaDestino="";
                }
            }
        });

        chkBoxTarjeta.setOnCheckedChangeListener(new CheckBox.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView,boolean isChecked) {
                if (isChecked) {
                    boxDedicatoriaDestino="Con dedicatoria";
                    showToast("boxDedicatoriaDestino: "+boxDedicatoriaDestino);
                }
                else {
                    boxDedicatoriaDestino="";
                }
            }
        });

        miSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            public void onItemSelected(AdapterView arg0, View arg1,final int position, long id) {

                zonaDestino=destinos[position].getZona();
                showToast("Tipo de destino elegido: "+zonaDestino);

                zonaDestino=destinos[position].getZona();
                continenteDestino=destinos[position].getContinente();
                precioDestino=destinos[position].getPrecio();
                imagenDestino=String.valueOf(destinos[position].getFoto());

                showToast("Tipo de imagen elegido: "+imagenDestino);

            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }

        });

        //boton calcular

        calcular.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (rbUrgente.isChecked()==true) {
                    precioUrgente=(precioDestino*30/100);
                    tarifaTipoDestino="urgente";
                }
                if (rbNormal.isChecked()==true){
                    tarifaTipoDestino="normal";
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

                pasoPantalla(zonaDestino,continenteDestino,precioDestino,pesoDestino,tarifaTipoDestino,boxCajaDestino,boxDedicatoriaDestino,imagenDestino);

            }
        });



    }



    public void pasoPantalla(String zonaDestino,String continenteDestino,float precioDestino, String pesoDestino, String tarifaTipoDestino, String boxCajaDestino, String boxDedicatoriaDestino, String imagenDestino){
        if(isFirst){
            isFirst=false;
        }else {
            Intent miIntent = new Intent(EnviosPaquetes3.this, PantallaDos.class);
            Bundle miBundle = new Bundle();

            miBundle.putString("zonaDestino", zonaDestino);
            miBundle.putString("continenteDestino", continenteDestino);
            miBundle.putString("precioDestino", String.valueOf(precioDestino));
            miBundle.putString("pesoDestino", pesoDestino);
            miBundle.putString("tarifaTipoDestino", tarifaTipoDestino);
            miBundle.putString("boxCajaDestino", boxCajaDestino);
            miBundle.putString("boxDedicatoriaDestino", boxDedicatoriaDestino);
            miBundle.putString("imagenDestino",imagenDestino);

            showToast("Tipo de imagen elegido paso pantalla: "+imagenDestino);

            miIntent.putExtras(miBundle);

            startActivity(miIntent);
        }
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
                holder.foto = (ImageView) item.findViewById(R.id.campoFoto);

                item.setTag(holder);
            }else{
                holder=(ViewHolder)item.getTag();
            }

            holder.zona.setText(destinos[position].getZona());
            holder.continente.setText(destinos[position].getContinente());
            holder.precio.setText(String.valueOf(destinos[position].getPrecio()));
            holder.foto.setImageResource(destinos[position].getFoto());


            return item;
        }
    }

    public void showToast(String text) {
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show();
    }

}
