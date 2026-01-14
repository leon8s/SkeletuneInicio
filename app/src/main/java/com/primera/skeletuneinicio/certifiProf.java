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

public class certifiProf extends AppCompatActivity implements View.OnClickListener {

    Button botonGuardaryEnviar;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_certifi_prof);

        botonGuardaryEnviar = findViewById(R.id.botonGuardaryEnviar);
        botonGuardaryEnviar.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if(id == R.id.botonGuardaryEnviar){
            Intent intent = new Intent(this, OpcionesBasicPremium.class);
            startActivity(intent);
        }
    }
}