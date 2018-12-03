package com.example.phill.restaurant;


import android.content.Context;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

//will retrieve the menu items for this category
public class MenuItemRequest implements Response.Listener<JSONObject>, Response.ErrorListener {

    private Context Context2 ;
    private String url = "https://resto.mprog.nl/menu";
    private Callback activity;
    ArrayList<com.example.phill.restaurant.MenuItem> MenuItem = new ArrayList<com.example.phill.restaurant.MenuItem>();

    MenuItemRequest(Context context) {
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
        try {
            for(int i=0;i<response.length();i++){


                JSONObject menuitem = response.getJSONObject(String.valueOf(i));
               int price = menuitem.getInt("price");
               String name = menuitem.getString("name");
               String description = menuitem.getString("description");
               String image = menuitem.getString("image");
               String catergory = menuitem.getString("catergory");

                MenuItem menui = new MenuItem(name, description, price, catergory, image);

                // add menu to Arraylist
                MenuItem.add(menui);
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }
        // pass the arrylist back
        activity.gotMenu(MenuItem);

    }

    //    attempt to retrieve the categories from the API
    public void getMenu(Callback activity){

        // use Volley to create a new RequestQueue
        RequestQueue queue = Volley.newRequestQueue(Context2);

        // create a JsonObjectRequest
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(url, null, this, this);
        queue.add(jsonObjectRequest);

    }

    public interface Callback {
        void gotMenu(ArrayList<com.example.phill.restaurant.MenuItem> categories);
        void gotMenuError(String message);
    }


}
