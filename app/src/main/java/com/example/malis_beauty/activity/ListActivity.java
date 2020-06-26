package com.example.malis_beauty.activity;

import android.os.Bundle;
import android.os.PersistableBundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import androidx.recyclerview.widget.RecyclerView;

import com.example.malis_beauty.R;
import com.example.malis_beauty.adapter.ListAdapter;
import com.example.malis_beauty.model.List;

public class ListActivity extends AppCompatActivity {

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);

        setContentView(R.layout.activity_list);

        //Make a reference to the RecyclerView
        RecyclerView recyclerView = findViewById(R.id.recycler_view);

        //Create and set a layout manager
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        //Create and set an adapter
        List[] lists = loadList();
        ListAdapter adapter = new ListAdapter(lists);
        recyclerView.setAdapter(adapter);

    }

    private List[] loadList() {
        //Dummy data
        List list1 = new List();
        list1.setName("Bay Lok Lak");
        list1.setService("Beef, Green Tomatoes, Garlic, Spring Onion, Egg, Lime, Salt, Pepper, Sugar, Stock");
        list1.setPrice(10-20, "$");

        List list2 = new List();
        list2.setName("Bay Lok Lak");
        list2.setService("Beef, Green Tomatoes, Garlic, Spring Onion, Egg, Lime, Salt, Pepper, Sugar, Stock");
        list2.setPrice(10-20, "$");

        List list3 = new List();
        list3.setName("Bay Lok Lak");
        list3.setService("Beef, Green Tomatoes, Garlic, Spring Onion, Egg, Lime, Salt, Pepper, Sugar, Stock");
        list3.setPrice(10-20, "$");

        return new List[] {list1, list2, list3};
    }
}
