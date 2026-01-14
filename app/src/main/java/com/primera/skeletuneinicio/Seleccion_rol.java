package com.primera.skeletuneinicio;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Seleccion_rol extends AppCompatActivity implements View.OnClickListener {

    Button botonProf, botonEstu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_seleccion_rol);

        botonProf = findViewById(R.id.botonimgProg);
        botonEstu = findViewById(R.id.botonimgEstu);

        botonEstu.setOnClickListener(this);
        botonProf.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if(id == R.id.botonimgProg){
            Intent intent = new Intent(this, certifiProf.class);
            startActivity(intent);
        }
        if(id == R.id.botonimgEstu){
            Intent intent = new Intent(this, OpcionesBasicPremium.class);
            startActivity(intent);

        }
    }
}