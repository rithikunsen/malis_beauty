package com.example.malis_beauty.activity;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.Nullable;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.malis_beauty.R;
import com.example.malis_beauty.adapter.ListAdapter;
import com.example.malis_beauty.model.List;
import com.google.gson.Gson;


public class ListActivity extends AppCompatActivity {

    RecyclerView recyclerView;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);

        setContentView(R.layout.activity_list);

        //Make a reference to the RecyclerView
        recyclerView = findViewById(R.id.recycler_view);

        //Create and set a layout manager
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        loadList();

    }

    private void loadList() {
       //Load list from the server using Volley library
        String url = "http://localhost:8888/lists.php";

        //Create a request
        StringRequest request = new StringRequest(url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                //Convert json string to array of lists using Gson
                Gson gson = new Gson();
                List[] lists = gson.fromJson(response, List[].class);
                //Create and set adapter
                ListAdapter adapter = new ListAdapter(lists);
                recyclerView.setAdapter(adapter);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(ListActivity.this, "Something error while loading data from server!!!", Toast.LENGTH_LONG).show();
                Log.d("malis_beauty", "Load data error: " + error.getMessage());
            }
        });

        //Add the request to the queue
        Volley.newRequestQueue(this).add(request);
    }
}
