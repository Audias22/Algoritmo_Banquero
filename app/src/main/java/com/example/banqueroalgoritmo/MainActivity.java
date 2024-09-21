package com.example.banqueroalgoritmo;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText etRecursoA, etRecursoB, etRecursoC;
    private EditText etSolicitarP1A, etSolicitarP1B, etSolicitarP1C;
    private EditText etSolicitarP2A, etSolicitarP2B, etSolicitarP2C;
    private TextView tvAsignadoP1, tvAsignadoP2, tvResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Inicialización de elementos
        etRecursoA = findViewById(R.id.etRecursoA);
        etRecursoB = findViewById(R.id.etRecursoB);
        etRecursoC = findViewById(R.id.etRecursoC);

        etSolicitarP1A = findViewById(R.id.etSolicitarP1A);
        etSolicitarP1B = findViewById(R.id.etSolicitarP1B);
        etSolicitarP1C = findViewById(R.id.etSolicitarP1C);

        etSolicitarP2A = findViewById(R.id.etSolicitarP2A);
        etSolicitarP2B = findViewById(R.id.etSolicitarP2B);
        etSolicitarP2C = findViewById(R.id.etSolicitarP2C);

        tvAsignadoP1 = findViewById(R.id.tvAsignadoP1);
        tvAsignadoP2 = findViewById(R.id.tvAsignadoP2);
        tvResultado = findViewById(R.id.tvResultado);

        Button btnSolicitarP1 = findViewById(R.id.btnSolicitarP1);
        Button btnSolicitarP2 = findViewById(R.id.btnSolicitarP2);

        btnSolicitarP1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                solicitarRecursos("P1");
            }
        });

        btnSolicitarP2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                solicitarRecursos("P2");
            }
        });
    }

    private void solicitarRecursos(String proceso) {
        // Obtener los valores ingresados
        int recursoA = Integer.parseInt(etRecursoA.getText().toString());
        int recursoB = Integer.parseInt(etRecursoB.getText().toString());
        int recursoC = Integer.parseInt(etRecursoC.getText().toString());

        int solicitarA = Integer.parseInt(proceso.equals("P1") ? etSolicitarP1A.getText().toString() : etSolicitarP2A.getText().toString());
        int solicitarB = Integer.parseInt(proceso.equals("P1") ? etSolicitarP1B.getText().toString() : etSolicitarP2B.getText().toString());
        int solicitarC = Integer.parseInt(proceso.equals("P1") ? etSolicitarP1C.getText().toString() : etSolicitarP2C.getText().toString());

        // Verificar si los recursos solicitados están disponibles
        if (solicitarA <= recursoA && solicitarB <= recursoB && solicitarC <= recursoC) {
            if (proceso.equals("P1")) {
                tvAsignadoP1.setText(String.format("Asignado: A=%d, B=%d, C=%d", solicitarA, solicitarB, solicitarC));
            } else {
                tvAsignadoP2.setText(String.format("Asignado: A=%d, B=%d, C=%d", solicitarA, solicitarB, solicitarC));
            }
            tvResultado.setText("Estado del sistema: Seguro");
            tvResultado.setTextColor(ContextCompat.getColor(this, R.color.green));
        } else {
            tvResultado.setText("Estado del sistema: No Seguro");
            tvResultado.setTextColor(ContextCompat.getColor(this, R.color.red));
        }
    }
}
