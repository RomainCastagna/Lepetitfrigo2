package com.exercices.lepetitfrigo;

import android.graphics.Color;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.exercices.lepetitfrigo.model.Product;

import java.util.ArrayList;
import java.util.List;

public class StockActivity extends AppCompatActivity {

    private List<Product> legumes = new ArrayList<>();
    private List<Product> fruits = new ArrayList<>();
    private List<Product> epicerie = new ArrayList<>();
    private List<Product> pain = new ArrayList<>();
    private List<Product> produitslaitiers = new ArrayList<>();
    private List<Product> oeufs = new ArrayList<>();

    private int[] legumesQuantity = {12,3,4,5,6,12,23,12,12,3,4,5,6,12,23,12};
    private int[] fruitsQuantity = {12,3,4,5,6,12};
    private int[] epicerieQuantity = {12,3,4,5,6,12,23,12,12,3,4,5,6,12};
    private int[] painQuantity = {12,3};
    private int[] produitsLaitiersQuantity = {12,3,4,5,6,12,23,12};
    private int[] oeufsQuantity = {12,3};

    private LinearLayout linearLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stock);

        linearLayout  = findViewById(R.id.stock_linearLayout);
        legumes = ProductShopActivity.legumes;
        fruits = ProductShopActivity.fruits;
        epicerie = ProductShopActivity.epicerie;
        pain = ProductShopActivity.pain;
        produitslaitiers = ProductShopActivity.produitslaitiers;
        oeufs = ProductShopActivity.oeufs;

        legumesQuantity = ProductShopActivity.legumesQuantity;
        fruitsQuantity = ProductShopActivity.fruitsQuantity;
        epicerieQuantity = ProductShopActivity.epicerieQuantity;
        painQuantity = ProductShopActivity.painQuantity;
        produitsLaitiersQuantity = ProductShopActivity.produitsLaitiersQuantity;
        oeufsQuantity = ProductShopActivity.oeufsQuantity;

        addCategory("Légumes");
        addProducts(legumes,legumesQuantity);
        addCategory("Fruits");
        addProducts(fruits,fruitsQuantity);
        addCategory("Epicerie");
        addProducts(epicerie,epicerieQuantity);
        addCategory("Pain");
        addProducts(pain,painQuantity);
        addCategory("Produits Laitiers");
        addProducts(produitslaitiers,produitsLaitiersQuantity);
        addCategory("Oeufs");
        addProducts(oeufs,oeufsQuantity);


        /*
        <TextView
                    android:id="@+id/textView9"
                    android:layout_width="match_parent"
                    android:layout_height="wrap_content"
                    android:background="@android:color/black"
                    android:gravity="center"
                    android:text="Légumes"
                    android:textColor="@android:color/white"
                    android:textSize="24sp"
                    android:textStyle="bold" />
         */


    }

    private void addProducts(List<Product> products, int[] productsQuantity) {
        /*
        <LinearLayout
                    android:layout_width="match_parent"
                    android:layout_height="wrap_content"
                    android:orientation="horizontal">

                    <TextView
                        android:layout_width="wrap_content"
                        android:layout_height="match_parent"
                        android:layout_weight="0.6"
                        android:text="FRAMBOISES"
                        android:textAlignment="textStart"
                        android:textSize="18sp" />

                    <TextView
                        android:layout_width="wrap_content"
                        android:layout_height="match_parent"
                        android:layout_marginRight="20dp"
                        android:layout_weight="0.4"
                        android:text="17"
                        android:textAlignment="textEnd"
                        android:textSize="18sp" />
                </LinearLayout>
         */
        System.out.println(" TAILLE  " + products.size());


        for(int i = 0 ; i < products.size(); i++){
            LinearLayout linearLayout1 = new LinearLayout(getApplicationContext());
            linearLayout1.setOrientation(LinearLayout.VERTICAL);

            System.out.println(" ADDING PRODUCT ");

            TextView productName = new TextView(getApplicationContext());
            productName.setText(products.get(i).getName());
            productName.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT, 0.6f));
            productName.setTextSize(18);
            productName.setGravity(Gravity.START);

            TextView productQty = new TextView(getApplicationContext());
            productQty.setText(String.valueOf(productsQuantity[i]));
            productQty.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT, 0.4f));
            productQty.setTextSize(18);
            productQty.setGravity(Gravity.END);

            linearLayout1.addView(productName);
            linearLayout1.addView(productQty);
            linearLayout.addView(linearLayout1);
            
        }




    }

    private void addCategory(String name){


        TextView textView = new TextView(getApplicationContext());
        textView.setText(name);
        textView.setTextColor(Color.WHITE);
        textView.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT));
        textView.setGravity(Gravity.CENTER);
        textView.setBackgroundColor(Color.BLACK);
        textView.setTextSize(24);
        textView.setTypeface(null, Typeface.BOLD);

        linearLayout.addView(textView);
    }
}
