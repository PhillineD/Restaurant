package com.example.phill.restaurant;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class MenuItemAdapter extends ArrayAdapter<MenuItem> {

    viewholder holder;

    public MenuItemAdapter(Context context, int resource) {
        super(context, resource);
    }

    class viewholder{
        static TextView name;
        static TextView price;
        ImageView image;

    }

    public View getView (int position, View convertView, ViewGroup parent){
        if( convertView == null ){
            //  get the View object which you define in a layout
            LayoutInflater inflater = LayoutInflater.from(getContext());

            holder = new viewholder();

            //We must create a View:
            convertView = inflater.inflate(R.layout.my_list_item, parent, false);

            holder.image = (ImageView) convertView.findViewById();
            holder.name = (TextView) convertView.findViewById();
            holder.price = (TextView) convertView.findViewById();

            convertView.setTag(holder);

        }
        //Here we can do changes to the convertView, such as set a text on a TextView
        //or an image on an ImageView.
        viewholder.name.setText(getItem().getName());
        viewholder.price.setText(getItem().getPrice());

        return convertView;
    }




}
