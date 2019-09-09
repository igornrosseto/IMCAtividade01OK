package com.ems.imcatividade01;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

// Foram adicionados activities 2 e 3 ao manifest //

public class MainActivity extends AppCompatActivity {
    EditText objPeso, objAltura;
    Button btCalcular;
    Float peso;                  // ALTERADO
    Double altura;               // ALTERADO
    TextView erro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        erro = findViewById(R.id.msgErro) ;
        objPeso = findViewById(R.id.editPeso);
        objAltura = findViewById(R.id.editAltura);

        btCalcular = findViewById(R.id.btCalcular);
        btCalcular.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {

                // Adicionada mensagem de erro caso não sejam digitados os valores //

                if (objPeso.getText().toString().isEmpty() | objAltura.getText().toString().isEmpty()){
                    erro.setText("necessario preencher os dois campos para prosseguir.");
                }
                else {

                    peso = Float.parseFloat(objPeso.getText().toString());          // ALTERADO
                    altura = Double.parseDouble(objAltura.getText().toString());    // ALTERADO

                    Intent it = new Intent(getApplicationContext(), SegundaActivity.class);
                    Bundle dados = new Bundle();
                    dados.putFloat("peso", peso);         // ADICIONADO
                    dados.putDouble("altura", altura);    // ADICIONADO
                    it.putExtras(dados);
                    startActivity(it);
                }
            }
        });
    }
}