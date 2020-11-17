package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class welcome extends AppCompatActivity {
    Button btnCal, btnCon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcomepage);
        initUi();

    }

   public void btnCalculate(View v) {
       Intent GoActivity = new Intent(welcome.this, MainActivity.class);
       startActivity(GoActivity);
   }

   public void btnConvert(View v){
       Intent GoActivity = new Intent(welcome.this, Secodoage.class);
       startActivity(GoActivity);

   }

    public void btnEquation(View v){
        Intent GoActivity = new Intent(welcome.this, Equation.class);
        startActivity(GoActivity);

    }


    public void btnAboutus(View v){
        Intent GoActivity = new Intent(welcome.this,aboutus.class);
        startActivity(GoActivity);

    }




     private void initUi(){
    btnCal=findViewById(R.id.btnCAl);
    btnCon=findViewById(R.id.btnCOn);
     }
}