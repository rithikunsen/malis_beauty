package com.example.malis_beauty.activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.annotation.Nullable;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.malis_beauty.R;
import com.example.malis_beauty.adapter.ListAdapter;
import com.example.malis_beauty.model.List;
import com.google.gson.Gson;
import com.facebook.drawee.backends.pipeline.Fresco;



public class ListActivity extends AppCompatActivity implements ListAdapter.OnNoteListener {
    private List[] lists;
    private ProgressBar progressBar;
    private RecyclerView recyclerView;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {

//        Button button_list;

        super.onCreate(savedInstanceState);
        Fresco.initialize(this);
        setContentView(R.layout.activity_list);

//        button_list = (Button) findViewById(R.id.btn_book);

//        button_list.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(ListActivity.this, DescriptionActivity.class);
//                startActivity(intent);
//            }
//        });

        //Make a reference to the RecyclerView
        progressBar = findViewById(R.id.progress_bar);
        recyclerView = findViewById(R.id.recycler_view);

        //Create and set a layout manager
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        loadList(this);

        //create and set an adapter
//        List[] lists = loadList();
//        ListAdapter adapter = new ListAdapter(lists);
//        recyclerView.setAdapter(adapter);

    }

//    private List[] loadList() {
//        List list1 = new List();
//        list1.setName("Testing Salon");
//        list1.setService("Haircut");
//        list1.setPrice("100$");
//
//        List list2 = new List();
//        list2.setName("GG Salon");
//        list2.setService("Haircut");
//        list2.setPrice("100$");
//
//        return new List[]{list1, list2};
//    }

    private void loadList(final ListAdapter.OnNoteListener onNoteListener) {
        showLoading(true);

       //Load list from the server using Volley library
        String url = "https://my.api.mockaroo.com/users.json?key=fb310fc0";
        //Create a request
        StringRequest request = new StringRequest(url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                //Convert json string to array of lists using Gson
                Gson gson = new Gson();
                lists = gson.fromJson(response, List[].class);
                //Create and set adapter
                ListAdapter adapter = new ListAdapter(lists, onNoteListener);
                recyclerView.setAdapter(adapter);
                showLoading(false);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(ListActivity.this, "Something error while loading data from server!!!", Toast.LENGTH_LONG).show();
                Log.d("list", "Load data error: " + error.getMessage());

                showLoading(false);
            }
        });

        //Add the request to the queue
        Volley.newRequestQueue(this).add(request);
    }

    private void showLoading(boolean state){
        if(state){
            recyclerView.setVisibility(View.INVISIBLE);
            progressBar.setVisibility(View.VISIBLE);
        } else {
            progressBar.setVisibility(View.INVISIBLE);
            recyclerView.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void onNoteClick(int position) {
        Log.d("click","position: "+position);
        Intent intent = new Intent(this, DescriptionActivity.class);
        intent.putExtra("txt_name",lists[position].getName());
        intent.putExtra("txt_service",lists[position].getService());
        intent.putExtra("txt_price",lists[position].getPrice());
        intent.putExtra("img_profile",lists[position].getUserProfile());
        startActivity(intent);
    }
}
