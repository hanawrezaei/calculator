package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Equation extends AppCompatActivity {
    TextView txtres;
    EditText function;
    EditText numbers;
    Button btncalculate;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_equation);
        initUi();
        btncalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               String result= EquationsCalculator.Calculate(function.getText().toString(),numbers.getText().toString());
                txtres.setText(result);
            }


        });




    }



   void  initUi()

    {
        txtres=findViewById(R.id.textView4);
        function=findViewById(R.id.editTextNumber);
        numbers=findViewById(R.id.editTextNumber3);
        btncalculate=findViewById(R.id.button9);
        //alan miam
        ///chishod
        //raftam nhar biyaram
        //bashe rahat boror yekm esterahat kon
        //bzar tamom knim berim
    }
}