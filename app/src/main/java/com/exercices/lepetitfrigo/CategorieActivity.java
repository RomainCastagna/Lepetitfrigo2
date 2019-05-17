package com.exercices.lepetitfrigo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.GridView;
import android.widget.ListView;

import com.exercices.lepetitfrigo.adapter.ProductAdapter;
import com.exercices.lepetitfrigo.model.Product;

import java.util.ArrayList;

public class CategorieActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_legume);
        ArrayList<Product>legmues = new ArrayList<Product>();
        Product pommeroyal = new Product("pomme royla",5,"pommeroyal.jpg");
        Product fraise = new Product("fraise",3,"fraise.jpg");


        // Construct the data source
        ArrayList<Product> arrayOfProducts = new ArrayList<Product>();
        arrayOfProducts.add(pommeroyal);
        arrayOfProducts.add(fraise);
// Create the adapter to convert the array to views
        ProductAdapter adapter = new ProductAdapter(this, arrayOfProducts);

    // Attach the adapter to a ListView
        GridView listView =  findViewById(R.id.gridlistproducts);
        listView.setAdapter(adapter);

    }
}
