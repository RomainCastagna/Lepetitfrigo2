package com.exercices.lepetitfrigo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Inscription2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inscription2);




    }

    public void checkInputs(View o){

        EditText prenomET = findViewById(R.id.inscr_prenom_input);
        EditText nomET = findViewById(R.id.inscr_nom_input);

        String prenom = prenomET.getText().toString();
        String nom = nomET.getText().toString();

        if(prenom.length()<1 || nom.length() < 1){
            Toast.makeText(this.getApplicationContext(),"Un ou plusieurs champs ne sont pas remplis.", Toast.LENGTH_LONG).show();
            return;
        }

        Intent intent = new Intent(getApplicationContext(), Inscription3.class);
        startActivity(intent);
        finish();
    }
}
