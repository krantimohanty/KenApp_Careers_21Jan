package com.swashconvergence.apps.user;

import android.app.Dialog;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import com.swashconvergence.apps.user.Fragment_individual.BankDetails;
import com.swashconvergence.apps.user.Fragment_individual.Contact;
import com.swashconvergence.apps.user.Fragment_individual.Operation;
import com.swashconvergence.apps.user.Fragment_individual.Personal;
import com.swashconvergence.apps.user.Fragment_individual.Profile;
import com.swashconvergence.apps.user.app_adapter.Form2Adapter;
import com.swashconvergence.apps.user.app_model.Form2;

import java.util.ArrayList;
import java.util.List;

public class Form2Activity extends AppCompatActivity {
    private ViewPager viewPager;
    private TabLayout tabLayout;
    private Dialog dialog;
    private  ImageView profile_Pic;
    Form2Adapter adapter;
    private RecyclerView recyclerView;
    private List<Form2> form2List;
    private TextView addnew;
    private Spinner spinner_email, spinner_phone;
    private int REQUEST_CAMERA = 0, SELECT_FILE = 1;

    private String imgString = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form2);
        //Bottom Bar implementation
        int[] icons = {R.drawable.profile,
                R.drawable.phone_call,
                R.drawable.profile,
                R.drawable.bank_details,
                R.drawable.operator
        };
        String[] title = {
                "Personal Info", "Contact", "Profile","Bank Details" , "Operation deatils"

        };
//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);
//        getSupportActionBar().setTitle("Application Form");
        viewPager = (ViewPager) findViewById( R.id.viewpager);
        setupViewPager(viewPager);

        tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);
        for (int i = 0; i < icons.length; i++) {
            tabLayout.getTabAt(i).setIcon(icons[i]);
            tabLayout.getTabAt(i).setText(title[i]);

        }
        tabLayout.getTabAt(0).select();
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                tab.getIcon().setColorFilter(Color.parseColor("#0d70e0"),PorterDuff.Mode.SRC_IN);

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                tab.getIcon().setColorFilter(Color.LTGRAY, PorterDuff.Mode.SRC_IN);
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }
    private void setupViewPager(ViewPager viewPager) {
        Form2Activity.ViewPagerAdapter adapter = new Form2Activity.ViewPagerAdapter(getSupportFragmentManager());
        adapter.insertNewFragment(new Personal());
        adapter.insertNewFragment(new Contact());
        adapter.insertNewFragment(new Profile());
        adapter.insertNewFragment(new BankDetails());
        adapter.insertNewFragment(new Operation());
        viewPager.setAdapter(adapter);
    }

    class ViewPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        //        private final List<String> mFragmentTitleList = new ArrayList<>();
        public ViewPagerAdapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void insertNewFragment(Fragment fragment) {
            mFragmentList.add(fragment);
//            mFragmentTitleList.add(title);
        }
    }

    }

