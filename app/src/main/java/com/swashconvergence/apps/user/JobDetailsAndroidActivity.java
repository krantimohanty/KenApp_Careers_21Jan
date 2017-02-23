package com.swashconvergence.apps.user;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatTextView;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;

public class JobDetailsAndroidActivity extends AppCompatActivity implements View.OnClickListener {

    AppCompatTextView apply_mode;
    ImageView img_back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.feed_android_row_item_details);
        initView();
    }

    private void initView() {
        apply_mode= (AppCompatTextView) findViewById(R.id.apply_mode);
        apply_mode.setOnClickListener(this);
        img_back= (ImageView) findViewById(R.id.img_back);
        img_back.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.apply_mode:
                Intent readMorIntent=new Intent(JobDetailsAndroidActivity.this,LoginActivity.class);
                startActivity(readMorIntent);
                finish();
//                Toast.makeText(JobDetailsPMActivity.this,"Comming Soon",Toast.LENGTH_LONG).show();
                break;
            case R.id.img_back:
                onBackPressed();
                break;
        }

    }
}
