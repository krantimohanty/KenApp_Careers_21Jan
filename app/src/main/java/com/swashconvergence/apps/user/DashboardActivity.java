package com.swashconvergence.apps.user;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.daimajia.slider.library.Animations.DescriptionAnimation;
import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.TextSliderView;
import com.daimajia.slider.library.Tricks.ViewPagerEx;
import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.OnTabSelectListener;
import com.swashconvergence.apps.user.app_adapter.PartnerAdapter;
import com.swashconvergence.apps.user.app_adapter.SnapAdapter;
import com.swashconvergence.apps.user.app_model.App;
import com.swashconvergence.apps.user.app_model.HApp;
import com.swashconvergence.apps.user.app_model.Snap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DashboardActivity extends BaseActivity implements BaseSliderView.OnSliderClickListener, ViewPagerEx.OnPageChangeListener ,View.OnClickListener {

//    public static final String ORIENTATION = "orientation";

    //http://kencloudpartnerapisaurendratest.azurewebsites.net/swagger/ui/index

    // http://kenapplicant.azurewebsites.net/Careers/PublicPages/Current_Openings.aspx

    private LinearLayoutManager lLayout;

    private List<HApp> app1;
    private PartnerAdapter adapter1;
    private RecyclerView mRecyclerView, mRecyclerView1;
    private RelativeLayout services_layout;
    private LinearLayout solutions_layout, products_layout;
    private AppCompatTextView news_press_text;
    private static int flag = 0;
    NavigationView navigationView;
    LinearLayout lin_drawer;
    DrawerLayout drawer;

//    private boolean mHorizontal;
private SliderLayout mDemoSlider;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("  Swash Apps");
        getSupportActionBar().setIcon(R.mipmap.ic_appbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);

//        lin_drawer=(LinearLayout) findViewById(R.id.lin_drawer);
        navigationView = (NavigationView) findViewById(R.id.nav_view);

// .......kranti

        List<ItemObject> rowListItem = getAllItemList();
        lLayout = new LinearLayoutManager(DashboardActivity.this);

        RecyclerView rView = (RecyclerView)findViewById(R.id.recycler_view);
        rView.setLayoutManager(lLayout);

        RecyclerViewAdapter rcAdapter = new RecyclerViewAdapter(DashboardActivity.this, rowListItem);
        rView.setAdapter(rcAdapter);

        //Bottom Bar implementation
        BottomBar bottomBar = (BottomBar) findViewById(R.id.bottomBar);
        bottomBar.setOnTabSelectListener(new OnTabSelectListener() {
            @Override
            public void onTabSelected(@IdRes int tabId) {
                if (tabId == R.id.tab_home) {
                    // The tab with id R.id.tab_favorites was selected,
                    // change your content accordingly.
                } else if (tabId == R.id.tab_career) {
                    // The tab with id R.id.tab_favorites was selected,
                    // change your content accordingly.
                } else if (tabId == R.id.tab_offers) {
                    // The tab with id R.id.tab_favorites was selected,
                    // change your content accordingly.
                }
            }
        });

//        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, null, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();
//        toolbar.inflateMenu(R.menu.main);
//        toolbar.setOnMenuItemClickListener(this);

        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        mRecyclerView1 = (RecyclerView) findViewById(R.id.recyclerView1);
        app1 = new ArrayList<>();
        adapter1 = new PartnerAdapter(this, app1);

        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(this, 2);
        mRecyclerView1.setLayoutManager(mLayoutManager);
        mRecyclerView1.addItemDecoration(new GridSpacingItemDecoration(2, dpToPx(10), true));
        mRecyclerView1.setItemAnimator(new DefaultItemAnimator());
        mRecyclerView1.setAdapter(adapter1);
        setupAdapter1();

        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setHasFixedSize(true);
        setupAdapter();

        // sliding images by suchi


        mDemoSlider = (SliderLayout)findViewById(R.id.slider);

//        HashMap<String,String> url_maps = new HashMap<String, String>();
//        url_maps.put("Hannibal", "http://static2.hypable.com/wp-content/uploads/2013/12/hannibal-season-2-release-date.jpg");
//        url_maps.put("Big Bang Theory", "http://tvfiles.alphacoders.com/100/hdclearart-10.png");
//        url_maps.put("House of Cards", "http://cdn3.nflximg.net/images/3093/2043093.jpg");
//        url_maps.put("Game of Thrones", "http://images.boomsbeat.com/data/images/full/19640/game-of-thrones-season-4-jpg.jpg");

        HashMap<String,Integer> file_maps = new HashMap<String, Integer>();
        file_maps.put("Banner1",R.drawable.banner01);
        file_maps.put("Banner2",R.drawable.banner02);
        file_maps.put("Banner3",R.drawable.banner03);
        file_maps.put("Banner4", R.drawable.banner04);
        file_maps.put("Banner5", R.drawable.banner05);
        file_maps.put("Banner6", R.drawable.banner06);

        for(String name : file_maps.keySet()){
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
                    .putString("extra",name);

            mDemoSlider.addSlider(textSliderView);
        }
        mDemoSlider.setPresetTransformer(SliderLayout.Transformer.Default);
        mDemoSlider.setPresetIndicator(SliderLayout.PresetIndicators.Center_Bottom);
        mDemoSlider.setCustomAnimation(new DescriptionAnimation());
        mDemoSlider.setDuration(4000);
        mDemoSlider.addOnPageChangeListener(this);


        solutions_layout = (LinearLayout)findViewById(R.id.solutions_layout);
        services_layout = (RelativeLayout) findViewById(R.id.services_layout);
        products_layout = (LinearLayout) findViewById(R.id.products_layout);

        //navigate to discussion page
        solutions_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                startActivity(new Intent(DashboardActivity.this, CareersActivity.class));
            }
        });
        services_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                startActivity(new Intent(DashboardActivity.this, EventzActivity.class));
            }
        });
        products_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(DashboardActivity.this, DashboardActivity.class));
            }
        });


        if (flag == 1) {
            this.finish();
            flag = 0;
        }

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

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
//        outState.putBoolean(ORIENTATION, mHorizontal);

    }
    private void setupAdapter() {
        List<App> apps = getApps();

        SnapAdapter snapAdapter = new SnapAdapter();

//            snapAdapter.addSnap(new Snap(Gravity.CENTER_HORIZONTAL, "Partners", apps));
//            snapAdapter.addSnap(new Snap(Gravity.START, "Products", apps));
            snapAdapter.addSnap(new Snap(Gravity.END, "Products:", apps));
//        } else {
//            snapAdapter.addSnap(new Snap(Gravity.CENTER_VERTICAL, "Snap center", apps));
//            snapAdapter.addSnap(new Snap(Gravity.TOP, "Snap top", apps));
//            snapAdapter.addSnap(new Snap(Gravity.BOTTOM, "Snap bottom", apps));
//        }

        mRecyclerView.setAdapter(snapAdapter);
    }
    private void setupAdapter1() {
//        List<HApp> apps1 = getApps1();
        int[] covers = new int[]{
                R.drawable.view1,
                R.drawable.view2,
                R.drawable.view3,
                R.drawable.view4,
//                R.drawable.product3,
////                R.drawable.product4,
//                R.drawable.product5,
//                R.drawable.product6,
//                R.drawable.product7,
//                R.drawable.product8,
//                R.drawable.product9
        };

        HApp model = new HApp( covers[0], "Smarter World");
        app1.add(model);
        model= new HApp(covers[1], "News Room");
        app1.add(model);
        model= new HApp(covers[2], "Innovation");
        app1.add(model);
        model= new HApp(covers[3], "Partner");
        app1.add(model);
        adapter1.notifyDataSetChanged();
        // tv.setTypeface(Typeface.SANS_SERIF);
        // tv.setTextSize(50);
        // android:fontFamily="san-serif"
        // android:textSize="@dimen/text_head"
    }


    private List<App> getApps() {
        List<App> apps = new ArrayList<>();
        apps.add(new App("KenResource", R.drawable.ic_aboutus, 4.6f));
        apps.add(new App("KenMoney", R.drawable.ic_aboutus, 4.8f));
        apps.add(new App("KenAsset", R.drawable.ic_aboutus, 4.5f));
        apps.add(new App("KenPoint", R.drawable.ic_aboutus, 4.2f));
        apps.add(new App("KenPlanner", R.drawable.ic_aboutus, 4.6f));
        apps.add(new App("KenRegister", R.drawable.ic_aboutus, 3.9f));
        apps.add(new App("KenRelations", R.drawable.ic_aboutus, 4.6f));
        apps.add(new App("KenReach", R.drawable.ic_aboutus, 4.2f));
        apps.add(new App("KenMedics", R.drawable.ic_aboutus, 4.2f));
        return apps;
    }
    private List<HApp> getApps1() {
        List<HApp> apps1 = new ArrayList<>();
        apps1.add(new HApp( R.drawable.banner01, ""));
        return apps1;
    }
//    @Override
//    public boolean onMenuItemClick(MenuItem item) {
//        if (item.getItemId() == R.id.layoutType) {
//            mHorizontal = !mHorizontal;
//            setupAdapter();
//            item.setTitle(mHorizontal ? "Vertical" : "Horizontal");
//        }
//        return false;
//    }

//    @Override
//    public void onBackPressed() {
//        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
//        if (drawer.isDrawerOpen(GravityCompat.START)) {
//            drawer.closeDrawer(GravityCompat.START);
//        } else {
//            super.onBackPressed();
//        }
//    }

    @Override
    public void onClick(View v) {
//
//        switch (v.getId()){
//            case R.id.lin_drawer:
//                if (drawer.isDrawerOpen(GravityCompat.START)) {
//                    drawer.closeDrawer(GravityCompat.START);
//                }
//                else
//                    drawer.openDrawer(GravityCompat.START);
//                break;
//        }
    }

    public class GridSpacingItemDecoration extends RecyclerView.ItemDecoration {

        private int spanCount;
        private int spacing;
        private boolean includeEdge;

        public GridSpacingItemDecoration(int spanCount, int spacing, boolean includeEdge) {
            this.spanCount = spanCount;
            this.spacing = spacing;
            this.includeEdge = includeEdge;
        }

        @Override
        public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
            int position = parent.getChildAdapterPosition(view); // item position
            int column = position % spanCount; // item column

            if (includeEdge) {
                outRect.left = spacing - column * spacing / spanCount; // spacing - column * ((1f / spanCount) * spacing)
                outRect.right = (column + 1) * spacing / spanCount; // (column + 1) * ((1f / spanCount) * spacing)

                if (position < spanCount) { // top edge
                    outRect.top = spacing;
                }
                outRect.bottom = spacing; // item bottom
            } else {
                outRect.left = column * spacing / spanCount; // column * ((1f / spanCount) * spacing)
                outRect.right = spacing - (column + 1) * spacing / spanCount; // spacing - (column + 1) * ((1f /    spanCount) * spacing)
                if (position >= spanCount) {
                    outRect.top = spacing; // item top
                }
            }
        }
    }

    /**
     * Converting dp to pixel
     */
    private int dpToPx(int dp) {
        Resources r = getResources();
        return Math.round(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, r.getDisplayMetrics()));
    }

    private List<ItemObject> getAllItemList(){

        List<ItemObject> allItems = new ArrayList<ItemObject>();
        allItems.add(new ItemObject("Current Openings", R.drawable.newyork));
//        allItems.add(new ItemObject("Canada", R.drawable.canada));
//        allItems.add(new ItemObject("United Kingdom", R.drawable.uk));
//        allItems.add(new ItemObject("Germany", R.drawable.germany));
//        allItems.add(new ItemObject("Sweden", R.drawable.sweden));

        return allItems;
    }
}
