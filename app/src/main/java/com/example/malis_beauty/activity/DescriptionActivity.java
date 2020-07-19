package com.example.malis_beauty.activity;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.malis_beauty.R;
import com.facebook.drawee.view.SimpleDraweeView;

public class DescriptionActivity extends AppCompatActivity {

    TextView txtName;
    TextView txtService;
    TextView txtPrice;
    SimpleDraweeView imgProfile;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_description);

        txtName  = (TextView) findViewById(R.id.txt_name);
        txtService = (TextView) findViewById(R.id.txt_service);
        txtPrice =  (TextView) findViewById(R.id.txt_price);
        imgProfile =  (SimpleDraweeView) findViewById(R.id.img_profile);

        String tmpName = getIntent().getStringExtra("txt_name");
        String tmpAmount = getIntent().getStringExtra("txt_service");
        String tmpDate = getIntent().getStringExtra("txt_price");
        String tmpImage = getIntent().getStringExtra("img_profile");

        txtName.setText(tmpName);
        txtService.setText(tmpAmount);
        txtPrice.setText(tmpDate);
        imgProfile.setImageURI(tmpImage);
    }
}
