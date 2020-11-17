package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Set;

public class MainActivity extends AppCompatActivity {
    Button btn0, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9,btnPlus,btnMen,btnDiv,btnPer,btnZar,btnEqu,btnC,btnLog,btnSin,btnCos,btnTan,btnPara,btnPow;
    TextView txtOp, txtResult;
    Button btnSign;
    Button btnDot;
    Double num1,num2;
    String op;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initUi();
        btn0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!txtResult.getText().toString().equals(0)) {
                    txtResult.append("0");
                }
            }
        });
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setNumber("1");

            }


        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setNumber("2");
            }


        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setNumber("3");
            }


        });
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setNumber("4");
            }


        });
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setNumber("5");
            }


        });
        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setNumber("6");
            }


        });
        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setNumber("7");
            }


        });
        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setNumber("8");
            }


        });
        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setNumber("9");
            }


        });
        btnZar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setNumber("*");

            }


        });
        btnPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setNumber("+");

            }


        });
        btnMen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setNumber("-");

            }


        });
        btnPer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setNumber("%");

            }
        });
        btnC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txtResult.setText("");

            }
        });
        btnPer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setNumber(")");
            }
        });
        btnLog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setNumber("log");
            }
        });
        btnSin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setNumber("sin");
            }
        });
       btnCos.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               setNumber("cos");

            }

       });
        btnPara.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setNumber("(");
            }
        });
        btnPow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setNumber("^");
            }
        });

        btnEqu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.println("Question:"+txtResult.getText().toString());
                String result=Mxparser.getREsult(txtResult.getText().toString());
                txtOp.setText(result);

            }




        });
        //button mosavi kojas?
        btnDiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setNumber("/");

            }


        });
        btnTan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setNumber("tan");
            }
        });

        btnSign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setNumber("%");
            }
        });

        btnDot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!txtResult.getText().toString().contains(".")) {
                    txtResult.append(".");
                }





                }


        });




    }
    private void setop(String op){
        this.op=op;
        op="+";
        num1 = Double.parseDouble(txtResult.getText().toString());
        txtResult.setText("0");
        txtOp.setText(num1 + op);
    }

    private void setNumber(String Number) {
        if (txtResult.getText().toString().equals("0")) {
            txtResult.setText(Number);
        } else {
            txtResult.append(Number);
        }
    }

    private void initUi() {
        btnPow=findViewById(R.id.btnPow);
        btnPara=findViewById(R.id.btnPara);
        btnTan=findViewById(R.id.btnTan);
        btnCos=findViewById(R.id.btnCos);
        btnSin=findViewById(R.id.btnSin);
        btnLog=findViewById(R.id.btnLog);
        btnPer=findViewById(R.id.btnPer);
        btnC=findViewById(R.id.btnC);
        btnEqu=findViewById(R.id.btnEqu);
        btnZar=findViewById(R.id.btnZar);
        btnMen=findViewById(R.id.btnMen);
        btnDiv=findViewById(R.id.btnDiv);
        btnPlus=findViewById(R.id.btnPlus);
        btnDot=findViewById(R.id.btndot);
        btnSign=findViewById(R.id.btnSign);
        txtOp = findViewById(R.id.txtop);
        txtResult = findViewById(R.id.txtresult);
        btn0 = findViewById(R.id.btn0);
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
        btn5 = findViewById(R.id.btn5);
        btn6 = findViewById(R.id.btn6);
        btn7 = findViewById(R.id.btn7);
        btn8 = findViewById(R.id.btn8);
        btn9 = findViewById(R.id.btn9);
        System.out.println("ok");
        // dirooz y shot ferestadi ha line164 khada dasht to oon shot  mikham oon safha ro biyaram
        //un to gesmate run bud ba///in ja bud  yedunm lofcat bud k un micharxid vali khata haro az run mishe peyda kard inja aslan khata naneveshte kollan chizaye k goftmm chap nnakarde
        //are ,ig, shyd khata nadare moshkel az android mikhy yebar baz baste konim?are emmtehan konim hale run konm beza kamel tashkil she
        //tmm shod run mikonm
    }
}
