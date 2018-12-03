package com.example.phill.restaurant;

import android.content.Context;
import android.net.Uri;
import android.provider.ContactsContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class MenuItemAdapter extends ArrayAdapter<MenuItem> {



    public MenuItemAdapter(Context context, int resource, ArrayList<MenuItem> objects) {
        super(context, resource,objects);
    }

    private static class viewholder{
        static TextView name;
        static TextView price;
        static ImageView image;

    }

    public View getView (int position, View convertView, ViewGroup parent){

        viewholder holder;

        if( convertView == null ){

            //  get the View object which you define in a layout
            LayoutInflater inflater = LayoutInflater.from(getContext());

            // create new holder
            holder = new viewholder();

            // create a new view:
            convertView = inflater.inflate(R.layout.item_activity, parent, false);


            holder.image = (ImageView) convertView.findViewById();
            holder.name = (TextView) convertView.findViewById();
            holder.price = (TextView) convertView.findViewById();

            convertView.setTag(holder);
        }

        // changes to the convertView, such as set a text on a TextView
        MenuItem piece = getItem(position);
        viewholder.name.setText(piece.getName());
        viewholder.price.setText(piece.getPrice());


        //or an image on an ImageView.
        DownloadImageTask UrltoImage = new DownloadImageTask(viewholder.image);
        UrltoImage.execute(piece.getImage());


        return convertView;
    }




}
