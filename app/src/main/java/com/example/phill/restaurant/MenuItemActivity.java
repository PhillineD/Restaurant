package com.example.phill.restaurant;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MenuItemActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_activity);

        // get intent
        Intent items = getIntent();

        // declared views
        TextView viewname = findViewById();
        TextView viewdescription = findViewById();
        TextView viewprice = findViewById();
        ImageView viewimage = findViewById();

        String name = items.getStringExtra("name");
        String price = items.getStringExtra("price");
        String description = items.getStringExtra("description");


        viewname.setText(name);
        viewprice.setText(price);
        viewdescription.setText(description);

        // image moet nog


}
