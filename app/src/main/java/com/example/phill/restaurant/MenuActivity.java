package com.example.phill.restaurant;


import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;

//In your MenuActivity’s onCreate, retrieve the category string and make sure that this string is part of the request for menu items.
class MenuActivity implements MenuRequest.Callback{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_activity);

        // Get the Intent that started this activity and extract the string
        Intent intent = getIntent();
        String message = intent.getStringExtra("categorie");

        // Capture the layout's TextView and set the string as its text
        TextView textView = findViewById(R.id.textView);
        textView.setText(message);
    }

    @Override
    public void gotMenu(ArrayList<String> categories) {
//        custom view for the adapter, which will display as much info about the menu items as possible, including a picture!
    }

    @Override
    public void gotMenuError(String message) {

    }
}
