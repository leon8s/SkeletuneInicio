package com.primera.skeletuneinicio;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Sesion_Iniciada extends AppCompatActivity implements View.OnClickListener {

    Button btnenviarcorreoycontraseña;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_sesion_iniciada);

        btnenviarcorreoycontraseña = findViewById(R.id.botonenviarcorreoycontraseña);
        btnenviarcorreoycontraseña.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        int cadenita = v.getId();
        if(cadenita == R.id.botonenviarcorreoycontraseña){
            Toast.makeText(this, "Selecciona un rol", Toast.LENGTH_SHORT).show();
            Intent intentito = new Intent(this, Seleccion_rol.class);

            startActivity(intentito);
        }
    }
}