package com.ems.imcatividade01;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    EditText objPeso, objAltura;
    Button btCalcular;
    Float peso;
    Double altura;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        objPeso = findViewById(R.id.editPeso);
        objAltura = findViewById(R.id.editAltura);

        btCalcular = findViewById(R.id.btCalcular);
        btCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                peso = Float.parseFloat(objPeso.getText().toString());
                altura = Double.parseDouble(objAltura.getText().toString());

                Intent it = new Intent(getApplicationContext(), SegundaActivity.class);
                Bundle dados = new Bundle();
                dados.putFloat("peso", peso);
                dados.putDouble("altura", altura);
                it.putExtras(dados);
                startActivity(it);
            }
        });
    }
}