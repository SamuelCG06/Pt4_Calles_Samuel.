package com.example.pt4_calles_samuel;

import android.content.Intent;
import android.os.Bundle;
import android.provider.AlarmClock;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class activityAlarma extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_alarma);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        EditText txtMissatge = findViewById(R.id.txtMissatge);
        EditText txtHora = findViewById(R.id.txtHora);
        EditText txtMinuts = findViewById(R.id.txtMinuts);
        Button btnCrear = findViewById(R.id.btnCrearAlarma);
        Button btnEnrere = findViewById(R.id.btnEnrere);

        btnCrear.setOnClickListener(v -> {
            String missatge = txtMissatge.getText().toString();
            String horaStr = txtHora.getText().toString();
            String minutsStr = txtMinuts.getText().toString();

            if (horaStr.isEmpty() || minutsStr.isEmpty()) {
                Toast.makeText(this, "Has d'omplir les hores i minuts!", Toast.LENGTH_SHORT).show();
                return;
            }

            try {
                int hora = Integer.parseInt(horaStr);
                int minuts = Integer.parseInt(minutsStr);

                if (hora < 0 || hora > 23 || minuts < 0 || minuts > 59) {
                    Toast.makeText(this, "Introdueix una hora vàlida", Toast.LENGTH_SHORT).show();
                    return;
                }

                Intent intent = new Intent(AlarmClock.ACTION_SET_ALARM)
                        .putExtra(AlarmClock.EXTRA_MESSAGE, missatge)
                        .putExtra(AlarmClock.EXTRA_HOUR, hora)
                        .putExtra(AlarmClock.EXTRA_MINUTES, minuts);

                    startActivity(intent);

            } catch (NumberFormatException e) {
                Toast.makeText(this, "Introdueix nombres vàlids per l'hora i els minuts", Toast.LENGTH_SHORT).show();
            }
        });

        btnEnrere.setOnClickListener(v -> finish());
    }
}
