package com.swashconvergence.apps.user.Fragment_Company;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.swashconvergence.apps.user.R;

public class ThirdFragment extends Fragment {
private View rootView;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootView= inflater.inflate(R.layout.fragment_third, container, false);
        return rootView;
    }

}
