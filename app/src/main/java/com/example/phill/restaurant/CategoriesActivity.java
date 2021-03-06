package com.example.phill.restaurant;

import android.content.Intent;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class CategoriesActivity extends AppCompatActivity  implements CategoriesRequest.Callback {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.categories_activity);

        //  instantiate your adapter
        CategoriesRequest ArrayAdapter = new CategoriesRequest(this);
        ArrayAdapter.getCategories(this);

        // Toast for test
        Toast.makeText(this, "started", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void gotCategories(ArrayList<String> categories) {

        // Toast for test
        Toast.makeText(this, categories.get(0), Toast.LENGTH_LONG).show();

        // attach the adapter to listview
        ArrayAdapter<String> Categoriesadapter = new ArrayAdapter<String>(this, R.layout.categories_layout, categories);
        ListView CListview = findViewById(R.id.CListView);
        CListview.setAdapter(Categoriesadapter);
        CListview.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            // when clicked on categorie
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                // Create intent en put choosen categorie in it
                String categori = (String) parent.getItemAtPosition(position);
                Intent intent = new Intent(getApplicationContext(), MenuActivity.class);
                intent.putExtra("categorie", categori);
                startActivity(intent);
            }
        });

    }

    // when error if load catergories failed
    @Override
    public void gotCategoriesError(String message) {

        // Toast to test
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }

}
