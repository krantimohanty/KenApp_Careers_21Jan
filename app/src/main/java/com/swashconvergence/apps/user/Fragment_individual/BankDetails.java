package com.swashconvergence.apps.user.Fragment_individual;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.swashconvergence.apps.user.R;


public class BankDetails extends Fragment {
View rootview;
   private Button paynow;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootview= inflater.inflate(R.layout.fragment_bankdetails, container, false);
paynow=(Button)rootview.findViewById(R.id.paynow);
        paynow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               Fragment newFragment = new Operation();
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.content_operation, newFragment);
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });
        return rootview;
    }


}
