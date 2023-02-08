package com.cyrine.imc;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText poids;
    private EditText taille;
    private EditText age;
    private RadioButton f,h;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        poids = findViewById(R.id.etpoids);
        taille = findViewById(R.id.ettaille);
        age = findViewById(R.id.etage);
        f = findViewById(R.id.rbf);
        h = findViewById(R.id.rbh);
        Button btnImc = findViewById(R.id.buttonimc);
        Button btnImg = findViewById(R.id.buttonimg);
        btnImc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int s;
                float p;
                float t;
                int a;
                float imc;

                if (poids.getText().toString().isEmpty()) {
                    poids.setError("Champ obligatoire");
                }else if(taille.getText().toString().isEmpty()){
                    taille.setError("Champ obligatoire");

                }else if(age.getText().toString().isEmpty()){
                    age.setError("Champ obligatoire");

                }else if(!f.isChecked()&& !h.isChecked()){
                    Toast.makeText(MainActivity.this, "Sexe obligatoire", Toast.LENGTH_SHORT).show();
                }
                else{
                    p = Float.parseFloat(poids.getText().toString());
                    t = Float.parseFloat(taille.getText().toString());
                    a = Integer.parseInt(age.getText().toString());

                    if (f.isChecked()) {
                        s = 0;
                    } else {
                        s = 1;
                    }

                    t = t / 100;

                    imc = p / (t * t);

                    Intent intent = new Intent(MainActivity.this, TEST_IMC.class);
                    Bundle bn = new Bundle();
                    bn.putInt("age", a);
                    bn.putFloat("taille", t);
                    bn.putFloat("poids", p);
                    bn.putInt("sexe", s);
                    bn.putFloat("imc", imc);
                    intent.putExtras(bn);
                    startActivity(intent);
                }

            }
        });

        btnImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int s;
                float p;
                float t;
                int a;
                float img;
                if (poids.getText().toString().isEmpty()) {
                    poids.setError("Champ obligatoire");
                }else if(taille.getText().toString().isEmpty()){
                    taille.setError("Champ obligatoire");

                }else if(age.getText().toString().isEmpty()){
                    age.setError("Champ obligatoire");

                }else if(!f.isChecked()&& !h.isChecked()){
                    Toast.makeText(MainActivity.this, "Sexe obligatoire", Toast.LENGTH_SHORT).show();
                }else{
                    p = Float.parseFloat(poids.getText().toString());
                    t = Float.parseFloat(taille.getText().toString());
                    a = Integer.parseInt(age.getText().toString());
                    if (f.isChecked()) {
                        s = 0;
                    } else {
                        s = 1;
                    }

                    t = t / 100;

                    img = (float) ((1.29 * p / (t * t)) + 0.20 * a - (11.4 * s) - 8);
                    Intent intent = new Intent(MainActivity.this, TEST_IMG.class);
                    Bundle bn = new Bundle();
                    bn.putInt("age", a);
                    bn.putFloat("taille", t);
                    bn.putFloat("poids", p);
                    bn.putInt("sexe", s);
                    bn.putFloat("img", img);
                    intent.putExtras(bn);
                    startActivity(intent);

                }


            }
        });

    }
}