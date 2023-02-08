package com.cyrine.imc;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class TEST_IMC extends AppCompatActivity {
    private TextView pd, tl, age, sex, imc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_imc);

        pd = findViewById(R.id.tvpoids);
        tl = findViewById(R.id.tvtaille);
        age = findViewById(R.id.tvage);
        sex = findViewById(R.id.tvsexe);
        imc = findViewById(R.id.tvimc);
        Bundle bndl = getIntent().getExtras();
        int age1 = bndl.getInt("age");
        Float pd1 = bndl.getFloat("poids");
        Float tl1 = bndl.getFloat("taille");
        Float imc1 = bndl.getFloat("imc");

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
        imc.setText("Votre IMC est :"+String.format("%.02f",imc1));
        age.setText("Votre age est :"+age1+" Ans");




    }
}