package com.exercices.lepetitfrigo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;

import com.exercices.lepetitfrigo.model.Categorie;
import com.exercices.lepetitfrigo.model.Product;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);




        Product courgette = new Product("courgette",6,R.drawable.courgette);
    }

    public void launchSubscription(View o){
        Intent intent = new Intent(getApplicationContext(), Inscription1.class);
        startActivity(intent);
    }

    public void onLoginClick(View o){
        Intent intent = new Intent(getApplicationContext(), ProductShopActivity.class);
        startActivity(intent);
        finish();
    }
}
