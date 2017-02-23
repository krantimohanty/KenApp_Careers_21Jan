package com.swashconvergence.apps.user;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.daimajia.slider.library.Animations.DescriptionAnimation;
import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.TextSliderView;
import com.daimajia.slider.library.Tricks.ViewPagerEx;

import java.util.HashMap;

public class FormMainActivity extends AppCompatActivity implements BaseSliderView.OnSliderClickListener, ViewPagerEx.OnPageChangeListener {
    private SliderLayout mDemoSlider;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_main);
        Typeface font = Typeface.createFromAsset(this.getAssets(), "fonts/Roboto-Regular.ttf");
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        TextView toolbarTitle = (TextView) toolbar.findViewById(R.id.toolbar_title);
        toolbarTitle.setTypeface(font);
        final RadioGroup radioGroup = (RadioGroup) findViewById(R.id.radioCatagory);
        // Sliding Images
        mDemoSlider = (SliderLayout) findViewById(R.id.slider);

//        HashMap<String,String> url_maps = new HashMap<String, String>();
//        url_maps.put("Hannibal", "http://static2.hypable.com/wp-content/uploads/2013/12/hannibal-season-2-release-date.jpg");
//        url_maps.put("Big Bang Theory", "http://tvfiles.alphacoders.com/100/hdclearart-10.png");
//        url_maps.put("House of Cards", "http://cdn3.nflximg.net/images/3093/2043093.jpg");
//        url_maps.put("Game of Thrones", "http://images.boomsbeat.com/data/images/full/19640/game-of-thrones-season-4-jpg.jpg");

        HashMap<String, Integer> file_maps = new HashMap<String, Integer>();
        file_maps.put("Banner1", R.drawable.banner01);
        file_maps.put("Banner2", R.drawable.banner02);
        file_maps.put("Banner3", R.drawable.banner03);
        file_maps.put("Banner4", R.drawable.banner04);
        file_maps.put("Banner5", R.drawable.banner06);
        file_maps.put("Banner6", R.drawable.banner10);

        for (String name : file_maps.keySet()) {
            TextSliderView textSliderView = new TextSliderView(this);
            // initialize a SliderLayout
            textSliderView
                    .description(name)
                    .image(file_maps.get(name))
                    .setScaleType(BaseSliderView.ScaleType.Fit)
                    .setOnSliderClickListener(this);

            //add your extra information
            textSliderView.bundle(new Bundle());
            textSliderView.getBundle()
                    .putString("extra", name);

            mDemoSlider.addSlider(textSliderView);
        }
        mDemoSlider.setPresetTransformer(SliderLayout.Transformer.Default);
        mDemoSlider.setPresetIndicator(SliderLayout.PresetIndicators.Center_Bottom);
        mDemoSlider.setCustomAnimation(new DescriptionAnimation());
        mDemoSlider.setDuration(4000);
        mDemoSlider.addOnPageChangeListener(this);


        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                // find which radio button is selects
                if (checkedId == R.id.radioIndividual) {

                } else {

                }

                Button button = (Button) findViewById(R.id.btnSubmit);
                final RadioButton individual = (RadioButton) findViewById(R.id.radioIndividual);
                final RadioButton company = (RadioButton) findViewById(R.id.radioCompany);

                button.setOnClickListener(new View.OnClickListener() {
                    @Override

                    public void onClick(View v) {

                        int selectedId = radioGroup.getCheckedRadioButtonId();


                        // find which radioButton is checked by id

                        if (selectedId == individual.getId()) {
                            startActivity(new Intent(FormMainActivity.this, Form2Activity.class));
                        } else if (selectedId == company.getId()) {
                            startActivity(new Intent(FormMainActivity.this, Form1Activity.class));
                        }


                    }
                });

            }

        });
    }

                    @Override
                    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {}

                    @Override
                    public void onPageSelected(int position) {
                        Log.d("Slider Demo", "Page Changed: " + position);
                    }

                    @Override
                    public void onPageScrollStateChanged(int state) {}

                    @Override
                    protected void onStop() {
                        // To prevent a memory leak on rotation, make sure to call stopAutoCycle() on the slider before activity or fragment is destroyed
                        mDemoSlider.stopAutoCycle();
                        super.onStop();
                    }

                    @Override
                    public void onSliderClick(BaseSliderView slider) {
                        Toast.makeText(this,slider.getBundle().get("extra") + "",Toast.LENGTH_SHORT).show();
                    }



                    public boolean onPrepareOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
            MenuInflater inflater = getMenuInflater();
            inflater.inflate(R.menu.option_menu, menu);
            return true;
        //notification
//        menu.findItem(R.id.action_enquiry).setIcon(
//                new IconDrawable(this, IcoMoonIcons.ic_notification)
//                        .colorRes(R.color.color_white)
//                        .sizeDp(20));


    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        String message = "";
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        if (item.getItemId() == R.id.save) {
            message = "Saved Succeessfully";
        }
        else if (item.getItemId() == R.id.close) {
            message = "Do you want to close the application";
        }
//        else {
//            message = "Why would you select that!?";
//        }


        return super.onOptionsItemSelected(item);
    }

}

