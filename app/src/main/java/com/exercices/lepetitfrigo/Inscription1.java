package com.exercices.lepetitfrigo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Inscription1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inscription1);
    }

    public void launchSubPart2(){
        if(checkInputs()){
            Intent intent = new Intent(getApplicationContext(), Inscription1.class);
            startActivity(intent);
        }
    }

    private boolean checkInputs(){
        return true;
    }
}
