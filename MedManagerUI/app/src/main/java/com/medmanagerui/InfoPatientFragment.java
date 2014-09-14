package com.medmanagerui;

import android.app.AlertDialog;
import android.app.Fragment;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.medmanagerui.models.DataProvider;
import com.medmanagerui.models.Patient;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;


public class InfoPatientFragment extends Fragment {

    private Button btnAllergies;
    private EditText allergiesEditText;

    private static final String ARG_SECTION_NUMBER = "section_number";

    /**
     * Returns a new instance of this fragment for the given section
     * number.
     */
    private Context ctx;
    static Patient patient;

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
        allergiesEditText = (EditText) rootView.findViewById(R.id.patientAllergies);
        allergiesEditText.setText(patient.getAllergies());

        btnAllergies.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View view) {

                LayoutInflater li = LayoutInflater.from(ctx);
                View promtsView = li.inflate(R.layout.prompts, null);

                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(ctx);

                alertDialogBuilder.setView(promtsView);

                final EditText userInput = (EditText) promtsView.findViewById(R.id.editTextDialogUserInput);

                alertDialogBuilder.setCancelable(false)
                        .setPositiveButton("Save",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int id) {
                                        // get user input and set it to allergiesEditText
                                        // edit text
                                        allergiesEditText.setText(userInput.getText());
                                        patient.setAllergies(allergiesEditText.getText().toString());
                                        patient.save(new Callback() {
                                            @Override
                                            public void success(Object o, Response response) {

                                            }

                                            @Override
                                            public void failure(RetrofitError error) {

                                            }
                                        });

                                    }
                                })
                        .setNegativeButton("Cancel",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int id) {
                                        dialog.cancel();
                                    }
                                });

                //AlertDialog alertDialog = new AlertDialog.Builder(ctx).create(); //Read Update
                //alertDialog.setTitle("Allergies");
                //alertDialog.setMessage("Allergies Edit Window");


                //alertDialog.setButton(DialogInterface.BUTTON_NEGATIVE,"Okay", new DialogInterface.OnClickListener() {
                    //public void onClick(DialogInterface dialog, int which) {
                        // here you can add functions
                   // }
                //});

                AlertDialog alertDialog = alertDialogBuilder.create();
                alertDialog.show();  //<-- See This!

            }
        });
        //   setContentView(R.layout.fragment_bed_view);
        return rootView;
    }






}