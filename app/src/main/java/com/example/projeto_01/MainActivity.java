package com.example.projeto_01;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void calculadoraIMC(View view){
        view.setBackgroundColor(Color.argb(250,250,30,30));
        EditText editTextPeso = findViewById(R.id.editTextPeso);
        EditText editTextAltura = findViewById(R.id.editTextAltura);

        double peso = Double.parseDouble(String.valueOf(editTextPeso.getText()));
        double altura = Double.parseDouble(String.valueOf(editTextAltura.getText()));
        double calculoIMC = imc(peso,altura);

        int color = 1;

        String resultado= "";
        TextView msg = findViewById(R.id.TextViewMsg);
        if (calculoIMC <= 18.5)
        {
            resultado= "você está abaixo do peso";
            color = Color.argb(250,200,200,0);
        }
        else if (calculoIMC > 18.5 && calculoIMC <= 24.9)
        {
            resultado="você está com peso normal";
            color = Color.argb(250,0,200,15);
        }
        else if (calculoIMC >= 25 && calculoIMC <= 29.9)
        {
            resultado="você está com sobrepeso";
            color = Color.argb(250,200,85,0);
        }
        else if (calculoIMC >= 30 && calculoIMC <= 34.9)
        {
            resultado="você está com obsidade Grau I";
            color = Color.argb(250,250,30,30);
        }
        else if (calculoIMC >= 35 && calculoIMC <= 39.9)
        {
            resultado="você está com obsidade Grau II";
            color = Color.argb(250,204,0,0);
        }
        else if (calculoIMC >= 40)
        {
            resultado="você está com obsidade Grau III";
            color = Color.argb(250,153,0,0);
        }
        msg.setTextColor(color);


        msg.setText(String.format("Seu IMC é %.2f\n\n %s", calculoIMC, resultado));
    }
    public double imc(double peso, double altura){
        double imc = peso / (altura * altura);
        return imc;
    }

}