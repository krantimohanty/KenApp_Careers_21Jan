package com.swashconvergence.apps.user;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class JobOpenActivity extends AppCompatActivity implements View.OnClickListener {

    TextView textView_Pm,textView_Android,textView_TestIng;
    ImageView img_back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.carrer_apply_list);
        initView();
    }

    private void initView() {
        textView_Pm= (TextView) findViewById(R.id.textView_Pm);
        textView_Pm.setOnClickListener(this);
        textView_Android= (TextView) findViewById(R.id.textView_Android);
        textView_Android.setOnClickListener(this);
        textView_TestIng = (TextView) findViewById(R.id.textView_TestIng);
        textView_TestIng.setOnClickListener(this);
        img_back= (ImageView) findViewById(R.id.img_back);
        img_back.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.textView_Pm:
                Intent pmIntent=new Intent(JobOpenActivity.this,OpeningsPMActivity.class);
                startActivity(pmIntent);
                //finish();
                break;
            case R.id.textView_Android:
                Intent androidIntent=new Intent(JobOpenActivity.this,OpeningsAndroidActivity.class);
                startActivity(androidIntent);
                //finish();
                break;
            case R.id.textView_TestIng:
                Intent testingIntent=new Intent(JobOpenActivity.this,OpeningsTesterActivity.class);
                startActivity(testingIntent);
                //finish();
                break;

            case R.id.img_back:
                onBackPressed();
                break;
        }

    }
}
