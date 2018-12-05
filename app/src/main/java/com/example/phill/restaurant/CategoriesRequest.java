package com.example.phill.restaurant;

import android.content.Context;
import android.util.Log;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class CategoriesRequest implements Response.Listener<JSONObject>, Response.ErrorListener {

//    private static CategoriesRequest instance;
//    private String url = "https://resto.mprog.nl/categories";
    private Callback activity;
    private Context Context1;

    //    Write a constructor that accepts a Context type parameter
    // We need access to a “context” object to send internet requests.
    public CategoriesRequest(Context context) {
        this.Context1 = context;
    }

    public interface Callback {
        void gotCategories(ArrayList<String> categories);
        void gotCategoriesError(String message);
    }

    //    attempt to retrieve the categories from the API
    public void getCategories(Callback activity){
        this.activity = activity;
        // use Volley to create a new RequestQueue
        RequestQueue queue = Volley.newRequestQueue(this.Context1);

        // create a JsonObjectRequest
        String url = "https://resto.mprog.nl/categories";
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(url, null, this, this);
        queue.add(jsonObjectRequest);

        // pass the arrylist back
//        activity.gotCategories(catergoriesview);
    }

    //    is called when something goes awr
    @Override
    public void onErrorResponse(VolleyError error) {
        this.activity.gotCategoriesError(error.getMessage());
    }


    //    is called when everything goes as expected
    @Override
    public void onResponse(JSONObject response) {
        // create arraylist for the categories
        ArrayList<String> catergoriesview = new ArrayList<String>();
        try {

//            we’d like to extract the array named "categories"
            JSONArray categories = response.getJSONArray("categories");

//            loop over it to extract the strings that are in it
            for(int i=0;i<categories.length();i++){

//                JSONObject jresponse = response.getJSONObject("categories");
                String Categoriesstring = categories.getString(i);

                // add catergorie to Arraylist
                catergoriesview.add(Categoriesstring);
                Log.d("foutje", "onResponse: ");
            }

            // pass the arraylist back
            this.activity.gotCategories(catergoriesview);

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }




}
