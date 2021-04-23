package com.example.listaseleccionable;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DatosLista extends AppCompatActivity {

    TextView titulos;
    TextView detalles;
    ImageView avatares;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datos_lista);

        titulos = findViewById(R.id.listdata);
        avatares = findViewById(R.id.imageView);
        detalles = findViewById(R.id.detalle);

        Intent intent = getIntent();
        String nombreRecibido = intent.getStringExtra("name");
        String descripcion = intent.getStringExtra("detalle");
        int imagenRecibida = intent.getIntExtra("image", 0);
        titulos.setText(nombreRecibido);
        avatares.setImageResource(imagenRecibida);
        detalles.setText(descripcion);
    }
}