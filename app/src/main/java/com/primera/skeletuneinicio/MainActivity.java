package com.primera.skeletuneinicio;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    ImageView ivscalee;
    Button btninicio;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        ivscalee = findViewById(R.id.imgnota);
        btninicio = findViewById(R.id.btnavanzar);
        btninicio.setOnClickListener(this);

        Animation animationscale = AnimationUtils.loadAnimation(
                this, R.anim.escaladito);
        ivscalee.startAnimation(animationscale);

    }

    @Override
    public void onClick(View v) {
        String cadenita = ((Button)v).getText().toString();
        if(cadenita.equals("Presione para avanzar")){
            Intent intentito = new Intent(this, IniciodeSesion.class);

            startActivity(intentito);
        }

    }
}