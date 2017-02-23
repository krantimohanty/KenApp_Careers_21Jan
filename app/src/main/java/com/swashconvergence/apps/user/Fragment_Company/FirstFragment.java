package com.swashconvergence.apps.user.Fragment_Company;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.AppCompatEditText;
import android.text.InputFilter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;

import com.swashconvergence.apps.user.R;
import com.swashconvergence.apps.user.app_util.ValidationUtil;

import java.text.SimpleDateFormat;
import java.util.Calendar;


public class FirstFragment extends Fragment {
    private View rootView;
    private AppCompatButton btnNext;
    private AppCompatEditText name, emailid, editDob, phone, cellular, incpdate;
    private Calendar myCalendar = Calendar.getInstance();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootView= inflater.inflate(R.layout.fragment_first, container, false);
        name = (AppCompatEditText) rootView.findViewById(R.id.name);
        ValidationUtil.removeWhiteSpaceFromFront(name);
        name.setFilters(new InputFilter[]{ValidationUtil.filter});
        name.setFilters(new InputFilter[]{new InputFilter.LengthFilter(50)});
        name.setLongClickable(false);


        editDob = (AppCompatEditText) rootView.findViewById(R.id.dob);
        editDob.setKeyListener(null);
        editDob.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new DatePickerDialog(getActivity(), date, myCalendar
                        .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });

//        btnNext=(AppCompatButton)rootView.findViewById(R.id.next);
//        btnNext.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
////               // Create new fragment and transaction
//                Fragment newFragment = new SecondFragment();
//                FragmentTransaction transaction = getFragmentManager().beginTransaction();
//
//// Replace whatever is in the fragment_container view with this fragment,
//// and add the transaction to the back stack
//                transaction.replace(R.id.content_frame2, newFragment);
//                transaction.addToBackStack(null);
//
//// Commit the transaction
//                transaction.commit();
//            }
//        });

        return  rootView;
    }
    DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {

        @Override
        public void onDateSet(DatePicker view, int year, int monthOfYear,
                              int dayOfMonth) {
            // TODO Auto-generated method stub
            myCalendar.set(Calendar.YEAR, year);
            myCalendar.set(Calendar.MONTH, monthOfYear);
            myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
            updateLabel();
        }
    };
    private void updateLabel() {
        String myFormat = "MM/dd/yyyy";
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat);
        editDob.setText(sdf.format(myCalendar.getTime()));
    }
}

