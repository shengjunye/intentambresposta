package com.example.intent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Main22Activity extends AppCompatActivity implements View.OnClickListener{

    private TextView tv1;
    private Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main22);

        Bundle extras = getIntent().getExtras();
        String n = extras.getString("nom");

        tv1 = (TextView) findViewById(R.id.ReciboText);

        tv1.setText("Hola " + n + "¿Aceptas las condiciones?");

        btn = (Button) findViewById(R.id.aceptar);
        btn.setOnClickListener(this);

        btn = (Button) findViewById(R.id.enviar);
        btn.setOnClickListener(this);
    }

    public void aceptar(){
        Intent resultat = new Intent();
        resultat.putExtra("resultat","Acceptat");
        setResult(RESULT_OK,resultat);
        finish();

    }


    public void cancelar(){
        Intent resultat = new Intent();
        resultat.putExtra("resultat","Rechazado");
        setResult(RESULT_CANCELED,resultat);
        finish();

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.aceptar: aceptar(); break;
            case R.id.enviar: cancelar(); break;
        }
    }
}
