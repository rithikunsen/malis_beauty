package com.example.malis_beauty.adapter;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.malis_beauty.R;
import com.example.malis_beauty.model.List;


public class ListAdapter extends RecyclerView.Adapter<ListViewHolder> {

    //Data
    private List[] lists;

    public ListAdapter(List[] lists) {
        this.lists = lists;
    }

    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //Load layout file
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View itemView = layoutInflater.inflate(R.layout.view_holder_list, parent, false);

        ListViewHolder viewHolder = new ListViewHolder(itemView);
        return new ListViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ListViewHolder holder, int position) {
        List list = lists[position];
        holder.bind(list);
    }

    @Override
    public int getItemCount() {
        return lists.length;
    }
}
