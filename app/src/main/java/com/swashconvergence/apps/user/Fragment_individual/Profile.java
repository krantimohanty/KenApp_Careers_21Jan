package com.swashconvergence.apps.user.Fragment_individual;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.AppCompatSpinner;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Spinner;

import com.swashconvergence.apps.user.R;

public class Profile extends Fragment {
    private View rootView;
    private Spinner qualification, occupation;
    AppCompatSpinner spinnerEmail, spinnerPhone;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootView = inflater.inflate(R.layout.fragment_profile, container, false);
        String[] emailArray = new String[]{
                "Addres Type"

        };
        String[] phoneArray = new String[]{
                "Cellular", "Home Phone", "Office Phone", "Others"};


        return rootView;



    }
}
