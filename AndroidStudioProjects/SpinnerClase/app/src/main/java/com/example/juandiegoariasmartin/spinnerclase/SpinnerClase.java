package com.example.juandiegoariasmartin.spinnerclase;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.view.LayoutInflater;


public class SpinnerClase extends Activity {

    public Spinner miSpinner;
    public static boolean isFirst=true;

    public Personas[] personas =
            new Personas[]{
                    new Personas("Arias","Pedro",4,R.drawable.papa),
                    new Personas("Arcas","Victor",32,R.drawable.victor),
                    new Personas("Martinez","Mirta",23,R.drawable.ic_launcher),
                    new Personas("Gaston","Pablo",25,R.drawable.pablo72)
            };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinner_clase);

        miSpinner = (Spinner) findViewById(R.id.spinner);
        AdaptadorPersona miAdaptador = new AdaptadorPersona(this);
        miSpinner.setAdapter(miAdaptador);

        miSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            public void onItemSelected(AdapterView arg0, View arg1, int position, long id) {
                //String personaClick;
                //personaClick = "Persona clicked:" + personas[position].toString();

                String apellidoClick=personas[position].getApellido();
                String nombreClick=personas[position].getNombre();
                String edadClick=String.valueOf(personas[position].getEdad());
                String fotoClick=String.valueOf(personas[position].getFoto());

                showToast(fotoClick);

                pasoPantalla(apellidoClick,nombreClick,edadClick,fotoClick);

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    public void showToast(String text) {
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show();
    }

    public void pasoPantalla(String apellidoClick, String nombreClick, String edadClick, String fotoClick){

            if(isFirst){
                isFirst=false;
            }else{
                Intent miIntent = new Intent(SpinnerClase.this, PantallaDos.class);
                Bundle miBundle=new Bundle();
                miBundle.putString("seleccionApe",apellidoClick);
                miBundle.putString("seleccionNom",nombreClick);
                miBundle.putString("seleccionEdad",edadClick);
                miBundle.putString("seleccionFoto",fotoClick);
                miIntent.putExtras(miBundle);

                startActivity(miIntent);
            }
    }


    class AdaptadorPersona extends ArrayAdapter<Personas>{
        public Activity miActividad;

        public AdaptadorPersona(Activity laActividad){
            super(laActividad, R.layout.desmilista, personas);
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
                item = inflater.inflate(R.layout.desmilista, null);

                holder = new ViewHolder();

                holder.nombre = (TextView) item.findViewById(R.id.campoNombre);
                holder.apellido = (TextView) item.findViewById(R.id.campoApellido);
                holder.foto = (ImageView) item.findViewById(R.id.campoFoto);

                item.setTag(holder);
            }else{
                holder=(ViewHolder)item.getTag();
            }

            holder.nombre.setText(personas[position].getNombre());
            holder.apellido.setText(personas[position].getApellido());
            holder.foto.setImageResource(personas[position].getFoto());



            return item;
        }
    }

}
