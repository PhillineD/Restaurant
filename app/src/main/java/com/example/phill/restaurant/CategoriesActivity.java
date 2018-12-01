package com.example.phill.restaurant;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class CategoriesActivity extends AppCompatActivity  implements CategoriesRequest.Callback {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.categories_activity);
        CategoriesRequest x = new CategoriesRequest(this);
        x.getCategories(this);
        Toast.makeText(this, "started", Toast.LENGTH_SHORT).show();

        //    instantiate your adapter
        CategoriesRequest ArrayAdapter = new CategoriesRequest(this);

        // attach the adapter to listview
        ListView listView = findViewById(R.id.CListView);
        listView.setAdapter((ListAdapter) ArrayAdapter);
//        listView.setOnItemClickListener(new GridItemClickListener());



    }


    @Override
    public void  gotCategories(ArrayList<String> categories) {
        // add catergorie to listview
//            CategoriesActivity catergorie = new CategoriesActivity(String);
//            categories.add(String.valueOf(catergorie));
        Toast.makeText(this, categories.get(0), Toast.LENGTH_LONG).show();

    }

    @Override
    public void gotCategoriesError(String message) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();

    }
}
