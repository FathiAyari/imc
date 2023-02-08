package com.cyrine.imc;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

public class TEST_IMG extends AppCompatActivity {
    private TextView pd, tl, age, sex, img;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_img);
        pd = findViewById(R.id.tvimgpoids);
        tl = findViewById(R.id.tvimgtaille);
        age = findViewById(R.id.tvimgage);
        sex = findViewById(R.id.tvimgsexe);
        img = findViewById(R.id.img);
        Bundle bndl = getIntent().getExtras();
        int age1 = bndl.getInt("age");
        Float pd1 = bndl.getFloat("poids");
        Float tl1 = bndl.getFloat("taille");
        Float img1 = bndl.getFloat("img");

        String sex1;
        int se;
        se = bndl.getInt("sexe");
        if (se == 0) {
            sex1 = "Femme";
        } else {
            sex1 = "Homme";
        }

        sex.setText("Vous êtes : " + sex1);
        pd.setText("Votre pouds est :" + pd1 + " Kg");
        tl.setText("Votre taille est :"+tl1*100+" Cm");
        img.setText("Votre IMG est :"+String.format("%.02f",img1));
        age.setText("Votre age est :"+age1+" Ans");


    }
}