package com.example.malis_beauty.adapter;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.malis_beauty.R;
import com.example.malis_beauty.model.List;
import com.facebook.drawee.view.SimpleDraweeView;


public class ListViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    private TextView txtName;
    private TextView txtService;
    private TextView txtPrice;
    private SimpleDraweeView imgProfile;
    ListAdapter.OnNoteListener onNoteListener;
    public ListViewHolder(@NonNull View itemView, ListAdapter.OnNoteListener onNoteListener) {
        super(itemView);

        txtName = itemView.findViewById(R.id.txt_name);
        txtService = itemView.findViewById(R.id.txt_service);
        txtPrice = itemView.findViewById(R.id.txt_price);
        imgProfile = itemView.findViewById(R.id.img_profile);
        this.onNoteListener = onNoteListener;

        itemView.setOnClickListener(this);
    }

    public void bind(List list) {
        txtName.setText(list.getName());
        txtService.setText(list.getService());
        txtPrice.setText(list.getPrice());
        imgProfile.setImageURI(list.getUserProfile());
    }

    @Override
    public void onClick(View v) {
        onNoteListener.onNoteClick(getAdapterPosition());
    }
}
