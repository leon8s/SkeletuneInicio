package com.primera.skeletuneinicio;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Crear_Contrasena extends AppCompatActivity implements View.OnClickListener {

    Button enviarcontraseña;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_crear_contrasena);

        enviarcontraseña = findViewById(R.id.botonenviarcontrasena);
        enviarcontraseña.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        String cadenita = ((Button)v).getText().toString();
        if(cadenita.equals("Continuar")){
            Intent intentito = new Intent(this, Sesion_Iniciada.class);

            startActivity(intentito);
        }
    }
}