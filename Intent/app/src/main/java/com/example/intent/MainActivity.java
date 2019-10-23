package com.example.intent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private EditText edtext;
    private Button btn;
    private TextView tv1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        btn = (Button) findViewById(R.id.enviar);
        btn.setOnClickListener(this);

        edtext = (EditText) findViewById(R.id.inputnom);

        tv1 = (TextView) findViewById(R.id.resultado);



    }

    public void enviar(){
        Intent intent = new Intent(this, Main22Activity.class);
        intent.putExtra("nom", edtext.getText().toString());
        startActivityForResult(intent,1234);

        onActivityResult(1234, RESULT_OK, intent);
    }

    protected void onActivityResult (int requestCode, int resultCode, Intent data){
        if(requestCode == 1234 && resultCode == RESULT_OK ){
            tv1.setText(tv1.getText().toString() + data.getExtras().getString("resultat"));
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.enviar: enviar(); break;
        }
    }
}
