package com.exercices.lepetitfrigo.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.exercices.lepetitfrigo.R;
import com.exercices.lepetitfrigo.model.Product;
import com.exercices.lepetitfrigo.model.User;

import java.util.ArrayList;

public class ProductAdapter extends ArrayAdapter<Product> {
    public ProductAdapter(Context context, ArrayList<Product> products) {
        super(context, 0, products);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        Product product = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_products, parent, false);
        }
        // Lookup view for data population
        Button productb = convertView.findViewById(R.id.productButon);
        TextView productname = (TextView) convertView.findViewById(R.id.productName);
        TextView productprice = (TextView) convertView.findViewById(R.id.productPrice);
        // Populate the data into the template view using the data object
        productname.setText(product.getName());
        productprice.setText(String.valueOf(product.getPrice()));
        productb.setBackground("@draw");

        // Return the completed view to render on screen
        return convertView;
    }
}