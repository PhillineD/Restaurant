package com.example.phill.restaurant;

import android.content.Context;
import android.icu.util.ULocale;
import android.util.Log;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import javax.security.auth.callback.Callback;

public class CategoriesRequest implements Response.Listener<JSONObject>, Response.ErrorListener {

    private static CategoriesRequest instance;
    private String url = "https://resto.mprog.nl/categories";

    // create arraylist for the categories
    ArrayList<CategoriesActivity> categories = new ArrayList<>();
    private Context Context1;

    //    Write a constructor that accepts a Context type parameter
    CategoriesRequest(Context context) {
//        super(context);
        Context1 = context;
    }

    //    is called when something goes awr
    @Override
    public void onErrorResponse(VolleyError error) {
        VolleyLog.d("TAG", "Error: " + error.getMessage());
    }


    //    is called when everything goes as expected
    @Override
    public void onResponse(JSONObject response) {
        try {
            for(int i=0;i<response.length();i++){
                JSONObject jresponse = response.getJSONObject(String.valueOf(i));
                String CategoriesActivity = jresponse.getString(String.valueOf(i));

                // add catergorie to listview
                CategoriesActivity catergorie = new CategoriesActivity(CategoriesActivity);
                categories.add(catergorie);
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

    }

    public interface Callback {
        void gotCategories(ArrayList<String> categories);
        void gotCategoriesError(String message);
    }
}
