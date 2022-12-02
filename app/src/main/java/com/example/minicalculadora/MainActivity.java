package com.example.minicalculadora;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView screenView;
    Button clear;
    Button suma;
    Button resta;
    Button igual;
    public String resText = "0";
    public int resTemp = 0;
    Button one;
    Button two;
    Button three;
    Button four;
    Button five;
    Button six;
    Button seven;
    Button eight;
    Button nine;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        screenView = (TextView) findViewById(R.id.resultado);
        clear = (Button) findViewById(R.id.clear);
        suma = (Button) findViewById(R.id.suma);
        resta = (Button) findViewById(R.id.resta);
        igual = (Button) findViewById(R.id.igual);

    }

    public void onClick(View boton){
        switch (boton.getId()){
            case R.id.b0:
                resText = resText.concat("0");
                screenView.setText(resText);
                break;

            case R.id.b1:
                resText = resText.concat("1");
                screenView.setText(resText);
                break;
            case R.id.b2:
                resText = resText.concat("2");
                screenView.setText(resText);
                break;
            case R.id.b3:
                resText = resText.concat("3");
                screenView.setText(resText);
                break;
            case R.id.b4:
                resText = resText + "4";
                screenView.setText(resText);
                break;
            case R.id.b5:
                resText = resText + "5";
                screenView.setText(resText);
                break;
            case R.id.b6:
                resText = resText + "6";
                screenView.setText(resText);
                break;
            case R.id.b7:
                resText = resText + "7";
                screenView.setText(resText);
                break;
            case R.id.b8:
                resText = resText + "8";
                screenView.setText(resText);
                break;
            case R.id.b9:
                resText = resText + "9";
                screenView.setText(resText);
                break;
        }
    }


    public void operaciones(View view){
        boolean suma = false;
        boolean resta = false;
        switch (view.getId()) {
            case R.id.clear:
                resTemp = 0;
                resText = "0";
                screenView.setText(resText);
                break;
            case R.id.suma:
                try{
                    int num = Integer.parseInt(String.valueOf(screenView.getText()));
                    resTemp = resTemp + num;
                    suma = true;
                    resta = false;
                    resText = "0";
                    screenView.setText(resText);
                }catch (Exception e){
                    screenView.setText("falla la conversion");
                }
                screenView.setText(resText);
                break;
            case R.id.resta:
                try{
                    int num = Integer.parseInt(screenView.getText().toString());
                    resTemp = resTemp - num;
                    suma = false;
                    resta = true;
                    resText = "0";
                    screenView.setText(resText);
                }catch (Exception e){
                    screenView.setText("falla la conversion");
                }
                screenView.setText(resText);
                break;
            case R.id.igual:
                if (suma){
                    int num = Integer.parseInt(String.valueOf(screenView.getText()));
                    resTemp = resTemp + num;
                    String resTextFinal = Integer.toString(resTemp);
                    screenView.setText(resTextFinal);
                }
                if (resta){
                    int num = Integer.parseInt(String.valueOf(screenView.getText()));
                    resTemp = resTemp - num;
                    String resTextFinal = Integer.toString(resTemp);
                    screenView.setText(resTextFinal);
                }
                break;
        }
    }

    public int suma(String numPantalla){
        int num1 = Integer.parseInt(numPantalla);
        int totalSuma = 0;

        return resTemp + 0;
    }

    public int resta(String numPantalla){
        int num1 = Integer.parseInt(numPantalla);
        return resTemp - num1;
    }

    public void addNumber(View view){
        //TODO hacer que sume los números

    }

    public void changeActivity(View view){
        Intent intentChangeAct = new Intent(this, Multiplicar.class);
        intentChangeAct.putExtra("primerOperando",resText);
        startActivity(intentChangeAct);
        finishAfterTransition();
    }

    public void cerrarApp(View view){
        finishAndRemoveTask();
    }
}