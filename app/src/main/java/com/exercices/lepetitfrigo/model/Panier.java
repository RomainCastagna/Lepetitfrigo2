package com.exercices.lepetitfrigo.model;

import android.content.ClipData;

import java.util.ArrayList;
import java.util.List;

public class Panier {

    public static List<Product> products = new ArrayList<>();

    Panier()
    {

    }

    public int GetNomberof(String ItemName,ArrayList<Product> productcategories)
    {
        int number=0;
        for (Product product:productcategories) {
            if(product.getName().equals(ItemName))
                number++;
        }
          return number;
    }


}
