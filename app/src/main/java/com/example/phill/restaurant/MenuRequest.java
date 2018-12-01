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
public class MenuRequest implements Response.Listener<JSONObject>, Response.ErrorListener {

    private Context Context2 ;
    private String url = "https://resto.mprog.nl/menu";
    private Callback activity;
    ArrayList<String> MenuItem = new ArrayList<String>();

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
        try {
            for(int i=0;i<response.length();i++){
                JSONObject jresponse = response.getJSONObject(String.valueOf(i));
                String menui = jresponse.getString(String.valueOf(i));

                // add catergorie to Arraylist
                MenuItem.add(menui);
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }

    }

    //    attempt to retrieve the categories from the API
    public void getMenu(Callback activity){

        // use Volley to create a new RequestQueue
        RequestQueue queue = Volley.newRequestQueue(Context2);

        // create a JsonObjectRequest
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(url, null, this, this);
        queue.add(jsonObjectRequest);

        // pass the arrylist back
        activity.gotMenu(MenuItem);

    }

    public interface Callback {
        void gotMenu(ArrayList<String> categories);
        void gotMenuError(String message);
    }


}
