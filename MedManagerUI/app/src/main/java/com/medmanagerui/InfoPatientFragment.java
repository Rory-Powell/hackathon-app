package com.medmanagerui;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Fragment;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;



public class InfoPatientFragment extends Fragment {

    private Button btnAllergies;
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
        final View rootView = inflater.inflate(R.layout.fragment_info_patient, container, false);


        btnAllergies = (Button) rootView.findViewById(R.id.buttonAllergies);
        btnAllergies.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog alertDialog = new AlertDialog.Builder(ctx).create(); //Read Update
                alertDialog.setTitle("Test Title");
                alertDialog.setMessage("this is my app");

                alertDialog.setButton("Continue..", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        // here you can add functions
                    }
                });

                alertDialog.show();  //<-- See This!

            }
        });
        //   setContentView(R.layout.fragment_bed_view);
        return rootView;
    }






}