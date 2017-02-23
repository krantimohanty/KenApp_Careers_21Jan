package com.swashconvergence.apps.user.Fragment_individual;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.AppCompatEditText;
import android.support.v7.widget.AppCompatSpinner;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.InputFilter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.swashconvergence.apps.user.NewAddress_Comp;
import com.swashconvergence.apps.user.R;
import com.swashconvergence.apps.user.app_adapter.Form1Adapter;
import com.swashconvergence.apps.user.app_model.Form1;
import com.swashconvergence.apps.user.app_util.ValidationUtil;
import com.weiwangcn.betterspinner.library.material.MaterialBetterSpinner;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Contact extends Fragment {
    Form1Adapter adapter;
    private List<Form1> form1List;
private AppCompatSpinner spinnerEmail, spinnerPhone;
    private  RecyclerView recyclerView;
    private View rootView;
    private TextView addnew;
    private AppCompatEditText incpdate, emailid, phone;
    MaterialBetterSpinner materialEmailSpinner, materialPhoneSpinner ;
    private Calendar myCalendar = Calendar.getInstance();
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootView= inflater.inflate(R.layout.fragment_contact, container, false);
        //        Spinner
//        spinnerEmail = (AppCompatSpinner) rootView.findViewById(R.id.email_type);

        // Initializing a String Array
        String[] emailArray = new String[]{
                "Personal Id", "Official Id"

        };
String[] phoneArray= new String[]{
        "Cellular" , "Home Phone", "Office Phone", "Others"

};
        materialEmailSpinner = (MaterialBetterSpinner)rootView.findViewById(R.id.email_type);
        materialPhoneSpinner=(MaterialBetterSpinner) rootView.findViewById(R.id.phone_type);
//        // Initializing an ArrayAdapter
        ArrayAdapter<String> spinnerEmailAdapter = new ArrayAdapter<>(getActivity(),R.layout.spinner_item, emailArray
        );
        spinnerEmailAdapter.setDropDownViewResource(R.layout.spinner_item);
        materialEmailSpinner.setAdapter(spinnerEmailAdapter);

        ArrayAdapter<String> spinnerPhoneAdapter = new ArrayAdapter<String>(getActivity(), R.layout.spinner_item, phoneArray
        );
        spinnerPhoneAdapter.setDropDownViewResource(R.layout.spinner_item);
        materialPhoneSpinner.setAdapter(spinnerPhoneAdapter);

//        Button next = (Button) rootView.findViewById(R.id.next);
//        next.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(rootView.getContext(), Profile.class);
//                rootView.getContext().startActivity(intent);
//                getActivity().finish();
//            }
//        });
        addnew = (TextView) rootView.findViewById(R.id.add_new_address);
        addnew.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getContext(), NewAddress_Comp.class));
            }
        });
//
        emailid = (AppCompatEditText)rootView.findViewById(R.id.email);
        ValidationUtil.removeWhiteSpaceFromFront(emailid);
        emailid.setFilters(new InputFilter[]{ValidationUtil.filter});
        emailid.setFilters(new InputFilter[]{new InputFilter.LengthFilter(50)});
        emailid.setLongClickable(false);

        phone = (AppCompatEditText) rootView.findViewById(R.id.phone);
        ValidationUtil.removeWhiteSpaceFromFront(phone);
        phone.setFilters(new InputFilter[]{ValidationUtil.filter});
        phone.setFilters(new InputFilter[]{new InputFilter.LengthFilter(50)});
        phone.setLongClickable(false);

//        //click listener to open calender
//
//        incpdate = (AppCompatEditText) rootView.findViewById(R.id.incpdate);
//        incpdate.setKeyListener(null);
//        incpdate.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                new DatePickerDialog(getActivity(), date1, myCalendar
//                        .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
//                        myCalendar.get(Calendar.DAY_OF_MONTH)).show();
//            }
//        });
//
//
//
//         Address Recycle view
        recyclerView = (RecyclerView) rootView.findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        form1List = new ArrayList<>();
        adapter = new Form1Adapter(getContext(), form1List);
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(getContext());
//        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(Form1Activity.this);
        recyclerView.setLayoutManager(mLayoutManager);
        mLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mLayoutManager.scrollToPosition(0);
//        recyclerView.addItemDecoration(new GridSpacingItemDecoration(2, dpToPx(10), true));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);
        addressDetails();
        return rootView;
    }




    private void addressDetails() {
//        Intent i= new Intent(getApplicationContext(),NewAddressActivity.class);
//        Form1 list= new Form1();
//        list.setHeadline(i.getStringExtra("title"));
//        list.setAddress1(i.getStringExtra("address1"));
//        list.setAddress2(i.getStringExtra("address2"));
//        list.setCity(i.getStringExtra("city"));
//        list.setState(i.getStringExtra("state"));
//        list.setCountry(i.getStringExtra("country"));
//        list.setPin(i.getStringExtra("zip"));
//form1List.add(list);
        Form1 a = new Form1("Swash Convergence", "Plot No. B15, 2nd Floor",
                "Arihanth Plaza, Sahidnagar", "Bhubaneswar", "Odisha", "India", "751007", "0674-2542674");
        form1List.add(a);
        a = new Form1("ABC Pvt Ltd.", "Plot No. B15, 2nd Floor",
                "Arihanth Plaza, Sahidnagar", "Bhubaneswar", "Odisha", "India", "751007", "0674-2542674");
        form1List.add(a);

//        adapter.notifyDataSetChanged();
    }
    }



