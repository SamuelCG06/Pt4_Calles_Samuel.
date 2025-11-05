package com.example.pt4_calles_samuel;

import android.os.Bundle;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.content.Intent;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Button btnAlarma = findViewById(R.id.btnCrearAlarma);
        Button btTrucada = findViewById(R.id.btnTrucada);

        btnAlarma.setOnClickListener( v -> {
            Intent intent = new Intent(this, activityAlarma.class);
            startActivity(intent);
        });

        btTrucada.setOnClickListener(v -> {
            Intent intent = new Intent(this, activityTrucada.class);
            startActivity(intent);
        });

    }
}

