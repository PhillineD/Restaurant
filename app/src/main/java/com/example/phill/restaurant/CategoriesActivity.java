package com.example.phill.restaurant;

import android.content.Intent;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public abstract class CategoriesActivity extends AppCompatActivity  implements CategoriesRequest.Callback, AdapterView.OnItemClickListener{


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.categories_activity);
        CategoriesRequest x = new CategoriesRequest(this);
        x.getCategories(this);
        Toast.makeText(this, "started", Toast.LENGTH_SHORT).show();

        //    instantiate your adapter
        CategoriesRequest ArrayAdapter = new CategoriesRequest(this);
        ArrayAdapter.getCategories(this);
//        ListView listView = findViewById(R.id.CListView);
//        listView.setAdapter((ListAdapter) ArrayAdapter);
//        listView.setOnItemClickListener(new GridItemClickListener());

    }

    @Override
    public void  gotCategories(ArrayList<String> categories) {

        // attach the adapter to listview
        ListView CListview = findViewById(R.id.CListView);
        ArrayAdapter<String> Categoriesadapter = new ArrayAdapter<String>(this, R.layout.categories_layout, categories);
        CListview.setAdapter(Categoriesadapter);
        CListview.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //  MenuActivity by way of an intent, making sure that you provide via putExtra a string with the category name
                CategoriesRequest categori = (CategoriesRequest) parent.getItemAtPosition(position);
                Intent intent = new Intent(getApplicationContext(), MenuActivity.class);
                intent.putExtra("categorie", (Parcelable) categori);
                startActivity(intent);
            }
        });
        Toast.makeText(this, categories.get(0), Toast.LENGTH_LONG).show();
    }

    @Override
    public void gotCategoriesError(String message) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }

}
