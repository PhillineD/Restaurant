package com.example.phill.restaurant;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.view.menu.MenuAdapter;
import android.widget.TextView;

import java.util.ArrayList;

//In your MenuActivity’s onCreate, retrieve the category string and make sure that this string is part of the request for menu items.
public class MenuActivity extends AppCompatActivity implements MenuRequest.Callback{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_activity);

        // Get the Intent that started this activity and extract the string
        Intent intent = getIntent();
        String message = intent.getStringExtra("categorie");

        // get the menu
        MenuRequest request = new MenuRequest(this);
        request.getMenu(this);

        // Capture the layout's TextView and set the string as its text
        TextView textView = findViewById(R.id.textView);
        textView.setText(message);
    }

    @Override
    public void gotMenu(ArrayList<MenuItem> categories) {
//        custom view for the adapter, which will display as much info about the menu items as possible, including a picture!
        MenuAdapter adapter = new MenuAdapter(this,R.layout.categories_activity,MenuItem);

    }

    @Override
    public void gotMenuError(String message) {

    }
}
