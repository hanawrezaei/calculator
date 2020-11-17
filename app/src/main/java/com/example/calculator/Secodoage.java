package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Secodoage extends AppCompatActivity {
    Button btn3,btn4,btn5,btn6,btn7,btn8;
     TextView txtVie;
     EditText editText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secodoage);
        intSe();
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                StringBuilder result=Converter.infixToPreFix(editText.getText().toString());
                System.out.println(result.toString());
                txtVie.setText(result.toString());
            }


        });

        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String result=Converter.PrefixToInfix(editText.getText().toString());
                System.out.println(result);
                txtVie.setText(result);
            }


        });

        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String result=Converter.PostfixToInfix(editText.getText().toString());
                System.out.println(result);
                txtVie.setText(result);
            }


        });

        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String result=Converter.infixToPostFix(editText.getText().toString());
                System.out.println(result);
                txtVie.setText(result);
            }


        });

        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String result=Converter.PostfixToPrifix(editText.getText().toString());
                System.out.println(result);
                txtVie.setText(result);
            }


        });


        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String result=Converter.PrefixToPostfix(editText.getText().toString());
                System.out.println(result);
                txtVie.setText(result);
            }


        });






    }

   private void intSe() {
       btn3 = findViewById(R.id.button3);
       btn4 = findViewById(R.id.button4);
       btn5 = findViewById(R.id.button5);
       btn6 = findViewById(R.id.button6);
       btn7 = findViewById(R.id.button7);
       btn8 = findViewById(R.id.button8);
       txtVie=findViewById(R.id.textView);
       editText=findViewById(R.id.editTextNumber2);

   }
   }