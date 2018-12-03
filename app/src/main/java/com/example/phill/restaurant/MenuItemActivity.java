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
        setContentView(R.layout.item_activity);

        // get intent
        Intent items = getIntent();

        // declared views
        TextView viewname = findViewById(R.id.ItemName);
        TextView viewdescription = findViewById(R.id.ItemDescription);
        TextView viewprice = findViewById(R.id.ItemPrice);
        ImageView viewimage = findViewById(R.id.ItemImage);

        // get specifiek parts from intent
        String name = items.getStringExtra("name");
        String price = items.getStringExtra("price");
        String description = items.getStringExtra("description");
        String image = items.getStringExtra("image");

        // set text for name price and description
        viewname.setText(name);
        viewprice.setText(price);
        viewdescription.setText(description);

        // set image
        DownloadImageTask load = new DownloadImageTask(viewimage);
        load.execute(image);

    }

}
