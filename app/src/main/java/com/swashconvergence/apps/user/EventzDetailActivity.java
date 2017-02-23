package com.swashconvergence.apps.user;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.widget.ContentLoadingProgressBar;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.AppCompatEditText;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.ScrollView;

import com.joanzapata.iconify.widget.IconButton;
import com.joanzapata.iconify.widget.IconTextView;
import com.swashconvergence.apps.user.app_widget.NonScrollListView;
import com.squareup.picasso.Picasso;

public class EventzDetailActivity extends BaseActivity {

    private AppCompatTextView events_head, events_date, events_subtitle, row_item_views, row_item_likes, row_item_comments;
    private ImageView row_item_image, profile_pic;
    private IconTextView highlight_one;
    private String title, short_text, photo, date, views, likes, comments, like_status;
    private IconButton btnLike, btnShare;
    private ScrollView content;
    private NonScrollListView highLightListView;
    private ContentLoadingProgressBar pgBar, post_progress;
    private AppCompatEditText edit_comments;
    private AppCompatButton btnPost;
    private int user_id;
    public int type;
    private int post_type;
    private int commntType;

    private ImageView detailImage;

    Context context;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eventz_detail);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Events Detail");
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });



        events_subtitle = (AppCompatTextView) findViewById(R.id.events_subtitle);
        events_date = (AppCompatTextView) findViewById(R.id.events_date);
        detailImage = (ImageView) findViewById(R.id.row_item_image);

        events_subtitle.setText(getIntent().getStringExtra("title"));
        events_date.setText(getIntent().getStringExtra("date"));

 try {
            Picasso.with(EventzDetailActivity.this)
                    .load(getIntent().getStringExtra("images"))

                    .into(detailImage);

        } catch (Exception e) {

        }




    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        supportFinishAfterTransition();
    }




}
