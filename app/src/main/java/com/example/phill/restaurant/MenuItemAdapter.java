package com.example.phill.restaurant;

import android.content.Context;
import android.net.Uri;
import android.provider.ContactsContract;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class MenuItemAdapter extends ArrayAdapter<MenuItem> {
    ArrayList<MenuItem> menuItem;

    public MenuItemAdapter(Context context, int resource, ArrayList<MenuItem> objects) {
        super(context, resource,objects);
        menuItem = objects;
    }


    @NonNull
    @Override
    public View getView (int position, @Nullable View convertView, @NonNull ViewGroup parent){
        if( convertView == null ){

            //  get the View object which you define in a layout
            LayoutInflater inflater = LayoutInflater.from(getContext());

//            // create new holder
//             viewholder holder = new viewholder();

            // create a new view:
            convertView = inflater.inflate(R.layout.menu_layout, parent, false);
        }

            ImageView image = (ImageView) convertView.findViewById(R.id.MenuImage);
            TextView name = (TextView) convertView.findViewById(R.id.MenuName);
            TextView price = (TextView) convertView.findViewById(R.id.MenuPrice);


        // changes to the convertView, such as set a text on a TextView
        MenuItem piece = getItem(position);
        Log.d("MenuItemAdapter", "Piece = " + piece.getName());
        // from piece from menu, get name & price en set views
        name.setText(piece.getName());
        price.setText(String.valueOf(piece.getPrice()));

        //or an image on an ImageView.
        DownloadImageTask UrltoImage = new DownloadImageTask(image);
        UrltoImage.execute(piece.getImage());

        return convertView;
    }

}
