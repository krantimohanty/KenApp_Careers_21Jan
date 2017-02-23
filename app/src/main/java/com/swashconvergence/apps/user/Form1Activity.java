package com.swashconvergence.apps.user;

import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatEditText;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import com.swashconvergence.apps.user.Fragment_Company.FirstFragment;
import com.swashconvergence.apps.user.Fragment_Company.ForthFragment;
import com.swashconvergence.apps.user.Fragment_Company.SecondFragment;
import com.swashconvergence.apps.user.Fragment_Company.ThirdFragment;
import com.swashconvergence.apps.user.app_adapter.Form1Adapter;
import com.swashconvergence.apps.user.app_model.Form1;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Form1Activity extends AppCompatActivity {
    private ViewPager viewPager;
    private TabLayout tabLayout;
    Form1Adapter adapter;
    private int[] layouts;
    private RecyclerView recyclerView;
    private List<Form1> form1List;
    private TextView addnew;
    private Spinner spinner;
    private AppCompatEditText name, emailid, editDob, phone, cellular, incpdate;
    private Calendar myCalendar = Calendar.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form1);
        Typeface font = Typeface.createFromAsset(this.getAssets(), "fonts/icomoon.ttf");
        final int[] icons = {R.drawable.profile,
                R.drawable.company,
                R.drawable.bank_details,
                R.drawable.operator
        };
        String[] title = {
                "Personal", "Company", "Bank Details", "Operation deatils"

        };

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Application Form");
        viewPager = (ViewPager) findViewById(R.id.viewpager_c);
        setupViewPager(viewPager);
        viewPager.addOnPageChangeListener(viewPagerPageChangeListener);
        tabLayout = (TabLayout) findViewById(R.id.tabs_c);
        tabLayout.setupWithViewPager(viewPager);
        for (int i = 0; i < icons.length; i++) {
            tabLayout.getTabAt(i).setIcon(icons[i]);
            tabLayout.getTabAt(i).setText(title[i]);

        }
        tabLayout.getTabAt(0).select();
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                tab.getIcon().setColorFilter(Color.parseColor("#0d70e0"), PorterDuff.Mode.SRC_IN);

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                tab.getIcon().setColorFilter(Color.LTGRAY, PorterDuff.Mode.SRC_IN);
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

//        tabLayout.addTab(tabLayout.newTab().setText("Personal").setIcon(R.drawable.user));
//        tabLayout.addTab(tabLayout.newTab().setText("Company").setIcon(R.drawable.company));
//        tabLayout.addTab(tabLayout.newTab().setText("Bank Details").setIcon(R.drawable.bank_details));
//        tabLayout.addTab(tabLayout.newTab().setText("Operation").setIcon(R.drawable.operator));


        //Bottom Bar implementation
//
//        BottomBar bottomBar = (BottomBar) findViewById(R.id.bottomBar);
//        bottomBar.setTabTitleTypeface(font);
//        bottomBar.setOnTabSelectListener(new OnTabSelectListener() {
//            @Override
//            public void onTabSelected(@IdRes int tabId) {
//                if (tabId == R.id.personal_info) {
//
//
//                } else if (tabId == R.id.company_info) {
//                    startActivity(new Intent(Form1Activity.this,Form2Activity.class));
//                } else if (tabId == R.id.bank_details) {
////                    startActivity(new Intent(getApplicationContext(),AppliedActivity.class));
//                } else if (tabId == R.id.operation_details) {
////                    startActivity(new Intent(getApplicationContext(),Form2Activity.class));
//                }
//
//            }
//
//        });

//        name = (AppCompatEditText) findViewById(R.id.name);
//        ValidationUtil.removeWhiteSpaceFromFront(name);
//        name.setFilters(new InputFilter[]{ValidationUtil.filter});
//        name.setFilters(new InputFilter[]{new InputFilter.LengthFilter(50)});
//        name.setLongClickable(false);
//
//        emailid = (AppCompatEditText) findViewById(R.id.email);
//        ValidationUtil.removeWhiteSpaceFromFront(emailid);
//        emailid.setFilters(new InputFilter[]{ValidationUtil.filter});
//        emailid.setFilters(new InputFilter[]{new InputFilter.LengthFilter(50)});
//        emailid.setLongClickable(false);
//
//        phone = (AppCompatEditText) findViewById(R.id.phone);
//        ValidationUtil.removeWhiteSpaceFromFront(phone);
//        phone.setFilters(new InputFilter[]{ValidationUtil.filter});
//        phone.setFilters(new InputFilter[]{new InputFilter.LengthFilter(50)});
//        phone.setLongClickable(false);
//
//
////        Spinner
//        spinner = (Spinner) findViewById(R.id.company_type);
//
//        // Initializing a String Array
//        String[] plants = new String[]{
//                "PVT LTD"
//
//        };
//
//        // Initializing an ArrayAdapter
//        ArrayAdapter<String> spinnerArrayAdapter = new ArrayAdapter<String>(
//                this, R.layout.spinner_item, plants
//        );
//        spinnerArrayAdapter.setDropDownViewResource(R.layout.spinner_item);
//        spinner.setAdapter(spinnerArrayAdapter);


        Button next = (Button) findViewById(R.id.next);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewPager.setCurrentItem(getItem(+1), true);
            }

        });
    }

    private int getItem(int i) {
        return viewPager.getCurrentItem() + i;
    }

    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.insertNewFragment(new FirstFragment());
        adapter.insertNewFragment(new SecondFragment());
        adapter.insertNewFragment(new ThirdFragment());
        adapter.insertNewFragment(new ForthFragment());
        viewPager.setAdapter(adapter);
    }

    ViewPager.OnPageChangeListener viewPagerPageChangeListener = new ViewPager.OnPageChangeListener() {

        @Override
        public void onPageSelected(int position) {


//            // changing the next button text 'NEXT' / 'GOT IT'
//            if (position == layouts.length - 1) {
//                // last page. make button text to GOT IT
//                btnNext.setText(getString(R.string.start));
//                btnSkip.setVisibility(View.GONE);
//            } else {
//                // still pages are left
//                btnNext.setText(getString(R.string.next));
//                btnSkip.setVisibility(View.VISIBLE);
//            }
        }

        @Override
        public void onPageScrolled(int arg0, float arg1, int arg2) {

        }

        @Override
        public void onPageScrollStateChanged(int arg0) {

        }
    };

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

//    public boolean onPrepareOptionsMenu(Menu menu) {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu., menu);
//
//        //notification
////        menu.findItem(R.id.action_enquiry).setIcon(
////                new IconDrawable(this, IcoMoonIcons.ic_notification)
////                        .colorRes(R.color.color_white)
////                        .sizeDp(20));
//
//        return true;
//    }
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        // Handle action bar item clicks here. The action bar will
//        // automatically handle clicks on the Home/Up button, so long
//        // as you specify a parent activity in AndroidManifest.xml.
//        int id = item.getItemId();
//
//        //noinspection SimplifiableIfStatement
////        if (id == R.id.action_bulletin) {
////            startActivity(new Intent(BulletinActivity.this, CreateBulletinActivity.class));
////            return true;
////        }
//
//        return super.onOptionsItemSelected(item);
//    }
//



//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);
//        getSupportActionBar().setTitle("Application Form");
//        final ViewPager pager = (ViewPager) findViewById(R.id.pager);
//        assert pager != null;
//        pager.setAdapter(new EmptyPagerAdapter(getSupportFragmentManager()));
//        viewPager = (ViewPager) findViewById(R.id.viewpager);
//        viewPager.setAdapter(pageAdapter);
//
//        StepperIndicator indicator = (StepperIndicator) findViewById(R.id.stepper_indicator);
//        assert indicator != null;
//        // We keep last page for a "finishing" page
//        indicator.setViewPager(viewPager, true);
//
//        indicator.addOnStepClickListener(new StepperIndicator.OnStepClickListener() {
//            @Override
//            public void onStepClicked(int step) {
//                viewPager.setCurrentItem(step, true);
//            }
//        });
//    }
//    private class MyPageAdapter extends FragmentPagerAdapter
//    {
//        public MyPageAdapter(FragmentManager fm)
//        {
//            super(fm);
//        }
//        @Override
//        public int getCount()
//        {
//            return 5;
//        }
//        @Override
//        public Fragment getItem(int position)
//        {
//            switch(position)
//            {
//                case 0: return new Personal();
//                case 1: return  new Contact();
//                case 2: return new Profile();
//                case 3: return new BankDetails();
//                default : return new Operation();
//            }
//        }
//    }
//    public static class PageFragment extends Fragment {
//
//        private TextView lblPage;
//
//        public static PageFragment newInstance(int page, boolean isLast) {
//            Bundle args = new Bundle();
//            args.putInt("page", page);
//            if (isLast)
//                args.putBoolean("isLast", true);
//            final PageFragment fragment = new PageFragment();
//            fragment.setArguments(args);
//            return fragment;
//        }
//
//        @Nullable
//        @Override
//        public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//            final View view = inflater.inflate(R.layout.fragment_page, container, false);
//            lblPage = (TextView) view.findViewById(R.id.lbl_page);
//            return view;
//        }
//
//        @Override
//        public void onActivityCreated(@Nullable Bundle savedInstanceState) {
//            super.onActivityCreated(savedInstanceState);
//            final int page = getArguments().getInt("page", 0);
//            if (getArguments().containsKey("isLast"))
//                lblPage.setText("You're done!");
//            else
//                lblPage.setText(Integer.toString(page));
//        }
//    }
//
//    private static class EmptyPagerAdapter extends FragmentPagerAdapter {
//
//        public EmptyPagerAdapter(FragmentManager fm) {
//            super(fm);
//        }
//
//        @Override
//        public int getCount() {
//            return 6;
//        }
//
//        @Override

//    }






