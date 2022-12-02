package com.example.minicalculadora;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Multiplicar extends MainActivity {

    public int resTemp = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.multiplicar);
        screenView = (TextView) findViewById(R.id.resultado);
        clear = (Button) findViewById(R.id.clear);
        suma = (Button) findViewById(R.id.suma);
        resta = (Button) findViewById(R.id.resta);
        igual = (Button) findViewById(R.id.igual);
        Bundle operadores = getIntent().getExtras();
        int resInt = operadores.getInt("primerOperando");
    }

    public void operaciones(View view){

        switch (view.getId()) {
            case R.id.clear:
                resTemp = 0;
                screenView.setText("");
                break;
            case R.id.suma:
                resTemp = suma(screenView.getText().toString());
                break;
            case R.id.resta:
                resTemp = resta(screenView.getText().toString());
                break;
            case R.id.igual:
                screenView.setText(resTemp);
                break;
        }
    }

    public void changeActivity(View view){
        Intent intentChangeAct = new Intent(this, MainActivity.class);
        startActivity(intentChangeAct);
        finishAfterTransition();
    }
    public void cerrarApp(View view){
        finishAndRemoveTask();
    }
}
