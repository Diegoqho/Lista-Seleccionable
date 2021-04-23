package com.example.listaseleccionable;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    String titulos[] = {"Batman", "Superman", "Cyborg", "Flash", "Capitán América", "Iron Man", "Hulk", "Thor"};
    String descripciones[] = {"Humano, Justice League", "Kriptoniano, Justice League", "Semihumano, Justice League", "Superhumano, Justice League",
            "Superhumano, Avengers", "Humano, Avengers", "Superhumano, Avengers", "Asgardiano, Avengers", };
    String detalles[] = {
            "Nombre real: Bruce Wayne\nEstatura: 1.88m\nPeso: 95kg\nEspecialidad: Habilidades como detective, intelecto nivel genio, brillante" +
                    "estratega y acróbata experto, dominio de artes marciales y técnicas de sigilo e intimidación.",
            "Nombre real: Kal - El\nEstatura: 1.92m\nPeso: 102kg\nEspecialidad: fuerza sobrehumana, velocidad, resistencia, agilidad, reflejos," +
                    "durabilidad, sentidos y longevidad, poderes oculares, aliento sobrehumano, invulnerabilidad, factor de curación rápida y vuelo.",
            "Nombre real: Victor Stone\nEstatura: 1.97m\nPeso: 175kg\nEspecialidad: intelecto nivel genio, experto en combate cuerpo a cuerpo," +
                    "fuerza sobrehumana, inmersión en el ciberespacio, tecnopatía, sensores y armamento avanzado y vuelo.",
            "Nombre real: Bartholomew Henry Allen\nEstatura: 1.87m\nPeso: 81kg\nEspecialidad: inmensa velocidad, agilidad, resistencia, y curación" +
                    " sobrehumanas, electrokinesis, intangilidad al vibrar a nivel molecular y viaje en el tiempo y dimensión.",
            "Nombre real: Steven Grant Rogers\nEstatura: 1.88m\nPeso: 109kg\nEspecialidad: sentidos, agilidad, velocidad y fuerza sobrehumanos, " +
                    "gran habilidad en armas de fuego, intinto de liderazgo, gran resistencia, inmune a gases y enfermedades, curación y" +
                    "regeneración acelerada, artista marcial y genio táctico.",
            "Nombre real: Anthony Edward Stark\nEstatura: 1.85m\nPeso: 102kg\nEspecialidad: intelecto nivel genio, experto científico e ingeniero, " +
                    "con el traje obtiene fuerza sobrehumana y durabilidad, vuelo supersónico, repulsor de energía y misiles de proyección, " +
                    "regenerativo soporte vital y equipamiento de armas de alta tecnología.",
            "Nombre real: Robert Bruce Banner\nEstatura: 1.78m o 3m\nPeso: 76kg o 540kg\nEspecialidad: intelecto nivel genio, o como Hulk super " +
                    "fuerza y velocidad, super resistencia, invulnerabilidad, longevidad, regeneración capacidad de respirar en el agua y espacio.",
            "Nombre real: Thor Odinson\nEstatura: 1.9m\nPeso: 98kg\nEspecialidad: fuerza y velocidad sobrehumanas, durabilidad y longevidad, a " +
                    "través del Mjolnir transporte dimensional, manipulación eléctrica, vuelo y manipulación del clima."
    };
    int avatar[] = {R.drawable.a, R.drawable.b, R.drawable.c, R.drawable.d, R.drawable.e, R.drawable.f, R.drawable.g, R.drawable.h};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.lista);
        CustomAdapter customAdapter = new CustomAdapter();
        listView.setAdapter(customAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getApplicationContext(), DatosLista.class);
                intent.putExtra("name", titulos[position]);
                intent.putExtra("imagen", avatar[position]);
                intent.putExtra("detalle", detalles[position]);
                startActivity(intent);
            }
        });
    }

    private class CustomAdapter extends BaseAdapter {
        @Override
        public int getCount() {
            return avatar.length;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View view = getLayoutInflater().inflate(R.layout.filas, null);

            TextView nombre = view.findViewById(R.id.titulo);
            ImageView imagen = view.findViewById(R.id.avatar);

            nombre.setText(titulos[position]);
            imagen.setImageResource(avatar[position]);

            return view;
        }
    }
}