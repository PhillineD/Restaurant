package com.example.phill.restaurant;


import android.content.Context;
import android.util.Log;
import android.view.Menu;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

//will retrieve the menu items for this category
public class MenuRequest implements Response.Listener<JSONObject>, Response.ErrorListener {

    Context Context2 ;
//    private String url = "https://resto.mprog.nl/menu";
    Callback activity;
//    ArrayList<com.example.phill.restaurant.MenuItem> MenuItem = new ArrayList<com.example.phill.restaurant.MenuItem>();

    MenuRequest(Context context) {
//        super(context);
        this.Context2 = context;
//        this.activity = activity;

    }

    @Override
    public void onErrorResponse(VolleyError error) {
        activity.gotMenuError(error.getMessage());
    }

    @Override
    public void onResponse(JSONObject response) {
        ArrayList<MenuItem> MenuItem = new ArrayList<MenuItem>();
        try {

            JSONArray items = response.getJSONArray("items");
            Log.d("MenuRequest1", "onResponse" + items);
            for(int i=0;i< items.length();i++){

                JSONObject menuitem = items.getJSONObject(i);

                Log.d("MenuRequet4", "Item: " + menuitem);

               int price = menuitem.getInt("price");
               String name = menuitem.getString("name");
               String description = menuitem.getString("description");
               String image = menuitem.getString("image_url");
               String catergory = menuitem.getString("category");

                MenuItem menui = new MenuItem(name, description, price, catergory, image);

                // add menu to Arraylist
                MenuItem.add(menui);
            }

            // pass the arrylist back
            activity.gotMenu(MenuItem);
            Log.d("MenuRequest2", "onResponse");

        } catch (JSONException e) {
            e.printStackTrace();
            Log.d("MenuRequest3", "onResponse");

        }


    }

    //    attempt to retrieve the categories from the API
    public void getMenu(Callback activity, String message){
        this.activity = activity;
        // use Volley to create a new RequestQueue
        RequestQueue queue = Volley.newRequestQueue(Context2);

        // create a JsonObjectRequest
        String url = "https://resto.mprog.nl/menu?category="+message;
        Log.d("MenuRequest", "Request url=" + url);
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(url, null, this, this);
        queue.add(jsonObjectRequest);

    }

    public interface Callback {
        void gotMenu(ArrayList<MenuItem> categories);
        void gotMenuError(String message);
    }


}
