package com.exercices.lepetitfrigo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.exercices.lepetitfrigo.model.Product;

import java.util.ArrayList;

public class LegumeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_legume);
        ArrayList<Product>legmues = new ArrayList<Product>();
        Product pommeroyal = new Product("pomme royla",5,"pomme.jpg");
        Product fraise = new Product("fraise",3,"fraise.jpg");


    }
}
