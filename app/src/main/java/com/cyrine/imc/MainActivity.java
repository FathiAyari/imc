package com.cyrine.imc;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

public class MainActivity extends AppCompatActivity {

    private EditText poids;
    private  EditText taille;
    private  EditText age;
    private RadioButton f;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        poids=findViewById(R.id.etpoids);
        taille=findViewById(R.id.ettaille);
        age=findViewById(R.id.etage);
       f=findViewById(R.id.rbf);
       Button btnImc=findViewById(R.id.buttonimc);
       Button btnImg=findViewById(R.id.buttonimg);
        btnImc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int s;
                float p;
                float  t;
                int a;
                float imc;

                p=Float.parseFloat(poids.getText().toString());
                t=Float.parseFloat(taille.getText().toString());
                a=Integer.parseInt(age.getText().toString());

                if(f.isChecked()){
                    s=0;
                }else{
                    s=1;
                }

                t=t/100;

                imc=p/(t*t);

                Intent intent=new Intent(MainActivity.this,TEST_IMC.class);
                Bundle bn =new Bundle();
                bn.putInt("age",a);
                bn.putFloat("taille",t);
                bn.putFloat("poids",p);
                bn.putInt("sexe",s);
                bn.putFloat("imc",imc);
                intent.putExtras(bn);
                startActivity(intent);

            }
        });

        btnImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

    }
}