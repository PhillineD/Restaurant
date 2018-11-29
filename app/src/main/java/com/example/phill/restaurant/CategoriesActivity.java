package com.example.phill.restaurant;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;

public class CategoriesActivity extends AppCompatActivity  implements CategoriesRequest.Callback {

    public CategoriesActivity(String categoriesActivity) {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.categories_activity);
    }


    @Override
    public void gotCategories(ArrayList<String> categories) {
        // add catergorie to listview
            CategoriesActivity catergorie = new CategoriesActivity(String);
            categories.add(String.valueOf(catergorie));


    }

    @Override
    public void gotCategoriesError(String message) {

    }
}
