package com.medmanagerui;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;



public class InfoPatientFragment extends Fragment {


    private static final String ARG_SECTION_NUMBER = "section_number";

    /**
     * Returns a new instance of this fragment for the given section
     * number.
     */
    private Context ctx;

    public static InfoPatientFragment newInstance(Context context) {
        InfoPatientFragment fragment = new InfoPatientFragment();
        fragment.ctx=context;
        return fragment;
    }

    public InfoPatientFragment() {
    }

    //   public View onCreateView(LayoutInflater inflater, ViewGroup container,
    //                           Bundle savedInstanceState) {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View rootView = inflater.inflate(R.layout.fragment_info_patient, container, false);

        //   setContentView(R.layout.fragment_bed_view);
        return rootView;
    }



}