package com.exercices.lepetitfrigo.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.TextView;

import com.exercices.lepetitfrigo.CategorieActivity;
import com.exercices.lepetitfrigo.ProductShopActivity;
import com.exercices.lepetitfrigo.R;
import com.exercices.lepetitfrigo.model.Panier;
import com.exercices.lepetitfrigo.model.Product;

import java.util.ArrayList;

public class ProductButtonAdapter extends BaseAdapter {
        private Context mContext;
    ArrayList<Product> products;
        // Gets the context so it can be used later
        public ProductButtonAdapter(Context c, ArrayList<Product> products) {
            mContext = c;
            this.products=products;
        }

        // Total number of things contained within the adapter
       /* public int getCount() {
            return this.filenames.length;
        }*/

    @Override
    public int getCount() {
        return products.size();
    }

    // Require for structure, not really used in my code.
        public Object getItem(int position) {
            return null;
        }

        // Require for structure, not really used in my code. Can
        // be used to get the id of an item in the adapter for
        // manual control.
        public long getItemId(int position) {
            return position;
        }

        public View getView(int position,
                            View convertView, ViewGroup parent) {
            Button btn;
            if (convertView == null) {
                // if it's not recycled, initialize some attributes
                btn = new Button(mContext);
                btn.setLayoutParams(new GridView.LayoutParams(200, 200));
                btn.setPadding(10, 10, 10, 10);
               // convertView = LayoutInflater.from(mContext).inflate(R.layout.item_products, parent, false);
            }
            else {
                btn = (Button) convertView;
            }

            btn.setText(products.get(position).getName());
            // filenames is an array of strings
           // btn.setTextColor(Color.WHITE);
            btn.setBackgroundResource(products.get(position).getImage());
            btn.setId(position);

            btn.setOnClickListener(view -> {
                    Panier.products.add(products.get(position));
            });
            return btn;
        }
    }

