package com.medmanagerui.fragments;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.app.Fragment;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.Spinner;
import android.widget.Toast;

import com.medmanagerui.MainActivity;
import com.medmanagerui.R;
import com.medmanagerui.adapters.GridViewAdapter;
import com.medmanagerui.models.Bed;
import com.medmanagerui.models.DataProvider;
import com.medmanagerui.models.Patient;
import com.medmanagerui.models.Staff;

import java.util.ArrayList;
import java.util.List;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;


public class BedViewFragment extends Fragment {


    private static final String ARG_SECTION_NUMBER = "section_number";

    /**
     * Returns a new instance of this fragment for the given section
     * number.
     */
    private Context ctx;
    private static final int DIALOG_ALERT = 10;
   // private EditText result;
    Patient patient;
    Bed bed;



    public static BedViewFragment newInstance(Context context) {
        BedViewFragment fragment = new BedViewFragment();
        fragment.ctx=context;
        return fragment;
    }

    public BedViewFragment() {
    }




    @Override
 public View onCreateView(LayoutInflater inflater, ViewGroup container,
                          Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View rootView = inflater.inflate(R.layout.fragment_bed_view, container, false);

        GridView gridview = (GridView) rootView.findViewById(R.id.gridview);

        gridview.setAdapter(new GridViewAdapter(ctx));
        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v, final int position, long id) {

                LayoutInflater li = LayoutInflater.from(ctx);
                View promtsView = li.inflate(R.layout.checkin_spinner, null);

                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(ctx);

                alertDialogBuilder.setView(promtsView);

                //Patient Spinner
                final Spinner patientSpinner = (Spinner) promtsView.findViewById(R.id.spinnerPatient);

                ArrayList<String> spinnerArray = new ArrayList<String>();
           //     List<Patient> myList = new ArrayList<Patient>();
                if(DataProvider.patientList!=null) {
                    for (int i = 0; i < DataProvider.patientList.size(); i++) {
                        spinnerArray.add(DataProvider.patientList.get(i).getName());
                    }
                }
         //*populate spinner
                ArrayAdapter<String> spinnerArrayAdapter = new ArrayAdapter<String>(ctx,android.R.layout.simple_spinner_dropdown_item,spinnerArray); //selected item will look like a spinner set from XML
                spinnerArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                patientSpinner.setAdapter(spinnerArrayAdapter);


                final Spinner doctorSpinner = (Spinner) promtsView.findViewById(R.id.spinnerDoctor);

                ArrayList<String> docspinnerArray = new ArrayList<String>();
                //     List<Patient> myList = new ArrayList<Patient>();
                final ArrayList<Staff> docnameArray = new ArrayList<Staff>();
                if(DataProvider.staffList!=null) {
                    for (int i = 0; i < DataProvider.staffList.size(); i++) {
                        if ( DataProvider.staffList.get(i).isDoctor) {
                            docspinnerArray.add(DataProvider.staffList.get(i).name);
                            docnameArray.add(DataProvider.staffList.get(i));
                        }
                    }
                }
                //*populate spinner
                ArrayAdapter<String> docspinnerArrayAdapter = new ArrayAdapter<String>(ctx,android.R.layout.simple_spinner_dropdown_item,docspinnerArray); //selected item will look like a spinner set from XML
                docspinnerArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                doctorSpinner.setAdapter(docspinnerArrayAdapter);


                alertDialogBuilder.setCancelable(false)
                        .setTitle("Patient Check-In")
                        .setPositiveButton("Save",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int id) {
                                        patient = DataProvider.patientList.get(patientSpinner.getSelectedItemPosition());
                                        patient.setBed(Integer.valueOf(DataProvider.bedList.get(position).id));
                                        patient.setDoctor(DataProvider.staffList.get(doctorSpinner.getSelectedItemPosition()).id);
                                        patient.save(new Callback() {
                                            @Override
                                            public void success(Object o, Response response) {
                                                Toast.makeText(ctx, "Success", Toast.LENGTH_SHORT).show();
                                            }

                                            @Override
                                            public void failure(RetrofitError error) {
                                                Toast.makeText(ctx, "Failure", Toast.LENGTH_SHORT).show();
                                            }
                                        });
                                        dialog.dismiss();

                                    }
                                })
                        .setNegativeButton("Cancel",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog,int id) {
                                        dialog.cancel();
                                    }
                                });



                AlertDialog alertDialog = alertDialogBuilder.create();
                alertDialog.show();  //<-- See This!


            }
        });
     return rootView;
    }

        }