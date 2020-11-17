package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class aboutus extends AppCompatActivity {

    TextView sahar,hana,zahra;
///ce eng pak kon dg ceneveshti hale mbebin shod ce eng bayd fgt ce bemune eng pak she hale
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aboutus);
        initUi();

    }



    void initUi()
    {
        sahar=findViewById(R.id.textView3);
        zahra=findViewById(R.id.textView5);
        hana=findViewById(R.id.textView7);
    }
}