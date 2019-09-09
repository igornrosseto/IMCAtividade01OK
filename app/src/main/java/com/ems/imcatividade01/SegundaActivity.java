package com.ems.imcatividade01;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SegundaActivity extends AppCompatActivity {
    Button btStatus, btVoltar;
    TextView resultadoImc;

    @SuppressLint("DefaultLocale")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segunda);

        Intent it = getIntent();
        Bundle dados = it.getExtras();

        final IMC imc = new IMC();
        assert dados != null;
        imc.setPeso(dados.getFloat("peso"));        // ADICIONADO
        imc.setAltura(dados.getDouble("altura"));   // ADICIONADO
        imc.calcularIMC();

        resultadoImc = findViewById(R.id.textIMC);
        resultadoImc.setText(String.format("%.2f", imc.getImc()));

        btStatus = findViewById(R.id.btMostraStatus);
        btStatus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(getApplicationContext(), TerceiraActivity.class);
                Bundle dados = new Bundle();
                dados.putSerializable("objIMC", imc);
                it.putExtras(dados);
                startActivity(it);
            }
        });

        btVoltar = findViewById(R.id.btVoltarPrincipal);
        btVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}