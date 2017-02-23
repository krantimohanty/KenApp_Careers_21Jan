package com.swashconvergence.apps.user.Fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonArrayRequest;
import com.swashconvergence.apps.user.R;
import com.swashconvergence.apps.user.app_adapter.EnquiryAdapter;
import com.swashconvergence.apps.user.app_model.EnquiryModel;
import com.swashconvergence.apps.user.network_utils.VolleySingleton;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class EnquiryFragment extends Fragment {


    private RecyclerView mRecyclerView;
    private View rootView;
    List<EnquiryModel> enquiryModels;
    EnquiryAdapter enquiryAdapter;

    LinearLayoutManager mLinearLayoutManager;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootView = inflater.inflate(R.layout.fragment_enquiry, container, false);

        //recycle view

        //mRecyclerView = (RecyclerView) rootView.findViewById(R.id.upcoming_list);
        // mRecyclerView.addItemDecoration(new DividerItemDecoration(getActivity(), DividerItemDecoration.VERTICAL_LIST));
       /* mRecyclerView.setHasFixedSize(true);*/

        enquiryModels = new ArrayList<>();
        getBultieen();
        return rootView;
    }
// Serverside connection // Kranti
    public void getBultieen() {

//        String url = "http://babylonia.in/BabyLoniaWebApi/api/Enquiry";
        String url = "http://kencloudpartnerapisaurendratest.azurewebsites.net/api/JobPostingApi";
//        String url = "http://kencloudcustomer-staging.azurewebsites.net/CheckSubscription.svc/rest/GetAllCity";
        JsonArrayRequest req = new JsonArrayRequest(url,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        Log.d("Result", response.toString());


                        for (int i = 0; i < response.length(); i++) {
                            try {

                                JSONObject obj = response.getJSONObject(i);
                                EnquiryModel enquiryModel = new EnquiryModel();
                                //enquiryModel.setName(obj.getString("EnquiryId"));

                                enquiryModel.setEnquiryNo(obj.getString("JobTitle"));
                                enquiryModel.setName(obj.getString("OrganizationName"));
                                enquiryModel.setEmailId(obj.getString("Keywords"));
                                enquiryModel.setEnquiryType(obj.getString("WorkExpMin"));
                                enquiryModel.setPhoneNo(obj.getString("WorkExpMax"));
                                enquiryModel.setArea(obj.getString("AnnualCTCMin"));
                                enquiryModel.setQueries(obj.getString("AnnualCTCMax"));
                                enquiryModel.setSource(obj.getString("OtherSalaryDtls"));



//                                enquiryModel.setName(obj.getString("CityName"));
//                                enquiryModel.setEmailId(obj.getString("ClientId"));
//                                enquiryModel.setEnquiryType(obj.getString("DistictId"));
//                                enquiryModel.setPhoneNo(obj.getString("StateId"));
//                                enquiryModel.setArea(obj.getString("T_cln_cd_Distict"));
//                                enquiryModel.setQueries(obj.getString("T_cln_cd_State"));




                                // Genre is json array


                                // adding eventModel to eventModels array
                                enquiryModels.add(enquiryModel);

                            } catch (JSONException e) {
                                e.printStackTrace();
                            }

                        }

                        mRecyclerView = (RecyclerView) rootView.findViewById(R.id.upcoming_list);
                        mRecyclerView.setHasFixedSize(true);
                        mLinearLayoutManager = new LinearLayoutManager(getActivity());
                        mLinearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
                        mLinearLayoutManager.scrollToPosition(0);
                        mRecyclerView.setLayoutManager(mLinearLayoutManager);
                        enquiryAdapter=new EnquiryAdapter(getContext(),enquiryModels,mRecyclerView);
                        mRecyclerView.setAdapter(enquiryAdapter);
                        // notifying list adapter about data changes
                        // so that it renders the list view with updated data
                        // adapter.notifyDataSetChanged();
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                VolleyLog.d("Result Error", "Error: " + error.getMessage());

            }
        });


        req.setRetryPolicy(new DefaultRetryPolicy(
                90000,
                DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
        VolleySingleton.getInstance(getActivity()).addToRequestQueue(req);

    }


    }