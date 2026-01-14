package com.primera.skeletuneinicio;

import android.content.Intent;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class IniciodeSesion extends AppCompatActivity implements View.OnClickListener {

    Button btnsiguiente;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_iniciode_sesion);

        btnsiguiente = findViewById(R.id.botonenviarcorreo);
        btnsiguiente.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        String cadenita = ((Button)v).getText().toString();
        if(cadenita.equals("Continuar")){
            Intent intentito = new Intent(this, CrearUsuario.class);

            startActivity(intentito);
        }
    }
}