package com.example.phill.restaurant;

import android.content.Context;
import android.content.Intent;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class CategoriesRequest implements Response.Listener<JSONObject>, Response.ErrorListener {

    private static CategoriesRequest instance;
    private String url = "https://resto.mprog.nl/categories";
    private Callback activity;

    // create arraylist for the categories
    ArrayList<String> catergoriesview = new ArrayList<>();
    private Context Context1;

    //    Write a constructor that accepts a Context type parameter
    CategoriesRequest(Context context) {
//        super(context);
        this.Context1 = context;
//        this.activity = activity;

    }

    //    is called when something goes awr
    @Override
    public void onErrorResponse(VolleyError error) {
//        VolleyLog.d("TAG", "Error: " + error.getMessage());
        activity.gotCategoriesError("foutje");
    }


    //    is called when everything goes as expected
    @Override
    public void onResponse(JSONObject response) {
        try {
            for(int i=0;i<response.length();i++){
                JSONObject jresponse = response.getJSONObject(String.valueOf(i));
                String Categoriesstring = jresponse.getString(String.valueOf(i));

                // add catergorie to Arraylist
                catergoriesview.add(Categoriesstring);

            }

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    //    attempt to retrieve the categories from the API
    public void getCategories(Callback activity){

        // use Volley to create a new RequestQueue
        RequestQueue queue = Volley.newRequestQueue(Context1);

        // create a JsonObjectRequest
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(url, null, this, this);
        queue.add(jsonObjectRequest);

        // pass the arrylist back
        activity.gotCategories(catergoriesview);

    }

    public interface Callback {
        void gotCategories(ArrayList<String> categories);
        void gotCategoriesError(String message);
    }
}
