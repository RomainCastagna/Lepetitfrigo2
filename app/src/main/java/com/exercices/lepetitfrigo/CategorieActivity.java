package com.exercices.lepetitfrigo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.exercices.lepetitfrigo.adapter.ProductAdapter;
import com.exercices.lepetitfrigo.adapter.ProductButtonAdapter;
import com.exercices.lepetitfrigo.model.Panier;
import com.exercices.lepetitfrigo.model.Product;

import java.util.ArrayList;
import java.util.List;

public class CategorieActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_legume);
        ArrayList<Product>legmues = new ArrayList<Product>();
        Product pommeroyal = new Product("pomme royla",5,R.drawable.pommeroyal);
        Product fraise = new Product("fraise",3,R.drawable.fraise);


        // Construct the data source
        ArrayList<Product> arrayOfProducts = new ArrayList<Product>();
        arrayOfProducts.add(pommeroyal);
        arrayOfProducts.add(fraise);
// Create the adapter to convert the array to views
        ProductButtonAdapter adapter = new ProductButtonAdapter(this, arrayOfProducts);

    // Attach the adapter to a ListView
        GridView listView =  findViewById(R.id.gridlistproducts);
        listView.setAdapter(adapter);
        //linearLayout_Achats
        LinearLayout linearLayout = findViewById(R.id.linearLayout_Achats);

        linearLayout.setOrientation(LinearLayout.VERTICAL);
        List<String> namealreadyuse= new ArrayList<String>();
        for(int i = 0; i < Panier.products.size(); i++ )
        {
            if(!namealreadyuse.contains(Panier.products.get(i).getName())) {
                TextView textView = new TextView(this);
                textView.setText(Panier.products.get(i).getName());
                linearLayout.addView(textView);
                namealreadyuse.add(Panier.products.get(i).getName());
            }

        }
    }
}
