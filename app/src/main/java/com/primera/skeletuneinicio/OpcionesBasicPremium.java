package com.primera.skeletuneinicio;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class OpcionesBasicPremium extends AppCompatActivity implements View.OnClickListener {

    Button botonbsc, botonprm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_opciones_basic_premium);

        botonprm = findViewById(R.id.btnPremium);
        botonprm.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if (id == R.id.btnPremium) {
            Intent intent = new Intent(this, PlanPremium.class);
            startActivity(intent);
        }
    }
}