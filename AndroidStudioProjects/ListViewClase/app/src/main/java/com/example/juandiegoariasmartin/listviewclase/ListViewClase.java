package com.example.juandiegoariasmartin.listviewclase;

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
import android.widget.ListView;
import android.widget.TextView;


public class ListViewClase extends Activity {

    private TextView textView;
    private ListView listView;

    private Dias[] datos =
            new Dias[]{
                    new Dias("1","Lunes"),
                    new Dias("2","Martes"),
                    new Dias("3","Miercoles"),
                    new Dias("4","Jueves"),
                    new Dias("5","Viernes")
            };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view_clase);

        AdaptadorTitulares adaptador = new AdaptadorTitulares(this);

        textView = (TextView)findViewById(R.id.textView);
        listView = (ListView)findViewById(R.id.listView);

        listView.setAdapter(adaptador);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> a, View v, int position, long id) {
                String opcionSeleccionada =
                        ((Dias)a.getAdapter().getItem(position)).getNombre();

                textView.setText("Opcion seleccionada: " + opcionSeleccionada);

                Intent miIntent = new Intent(ListViewClase.this, PantallaDos.class);

                Bundle miBundle=new Bundle();
                String envioDiaSeleccionado="" + opcionSeleccionada;
                miBundle.putString("TEXTO", envioDiaSeleccionado);
                miIntent.putExtras(miBundle);
                startActivity(miIntent);



            }
        });


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_list_view_clase, menu);
        return true;
    }

    class AdaptadorTitulares extends ArrayAdapter<Dias> {

        Activity context;

        AdaptadorTitulares(Activity context) {
            super(context, R.layout.activity_list_items_dias, datos);
            this.context = context;
        }

        public View getView(int position, View convertView, ViewGroup parent) {
            LayoutInflater inflater = context.getLayoutInflater();
            View item = inflater.inflate(R.layout.activity_list_items_dias, null);

            TextView tvId = (TextView)item.findViewById(R.id.tvId);
            tvId.setText(datos[position].getId());

            TextView tvNombre = (TextView)item.findViewById(R.id.tvNombre);
            tvNombre.setText(datos[position].getNombre());

            return(item);
        }
    }
}
