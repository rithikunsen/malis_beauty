package com.example.malis_beauty.adapter;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.malis_beauty.R;
import com.example.malis_beauty.model.List;


public class ListViewHolder extends RecyclerView.ViewHolder {

    private TextView txtName;
    private TextView txtService;
    private TextView txtPrice;

    public ListViewHolder(@NonNull View itemView) {
        super(itemView);

        txtName = itemView.findViewById(R.id.text_name);
        txtService = itemView.findViewById(R.id.txt_service);
        txtPrice = itemView.findViewById(R.id.txt_price);
    }

    public void bind(List list) {
        txtName.setText(list.getName());
        txtService.setText(list.getService());
        txtPrice.setText(list.getPrice());
    }

}
