package com.exercices.lepetitfrigo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

public class Inscription3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inscription3);



    }

    public void onCheckBoxClicked(View o){
        CheckBox checkBox = (CheckBox) o;

        if(checkBox.isChecked()){
            Button button = findViewById(R.id.inscr_btn_next3);
            button.setEnabled(true);
        }
    }

    public void onButtonClick(View o){
        Intent intent = new Intent(getApplicationContext(), ProductShopActivity.class);
        startActivity(intent);
        finish();
    }
}
