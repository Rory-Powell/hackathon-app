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
import android.widget.Toast;

import com.medmanagerui.models.DataProvider;
import com.medmanagerui.models.Patient;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;


public class InfoPatientFragment extends Fragment {

    private Button btnAllergies;
    private Button btnMedication;
    private Button btnVaccinations;
    private Button btnAliment;


    private EditText allergiesEditText;
    private EditText medicationEditText;
    private EditText vaccinationsEditText;
    private EditText alimentEditText;

    private static final String ARG_SECTION_NUMBER = "section_number";

    /**
     * Returns a new instance of this fragment for the given section
     * number.
     */
    private Context ctx;
    public static Patient patient;


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
        btnMedication = (Button) rootView.findViewById(R.id.buttonMedication);
        btnVaccinations = (Button) rootView.findViewById(R.id.buttonVaccinations);
        btnAliment = (Button) rootView.findViewById(R.id.buttonAliment);

        allergiesEditText = (EditText) rootView.findViewById(R.id.patientAllergies);
        allergiesEditText.setText(patient.getAllergies());

        medicationEditText = (EditText) rootView.findViewById(R.id.patientMedication);
        medicationEditText.setText(patient.getMedication());

        vaccinationsEditText = (EditText) rootView.findViewById(R.id.patientVaccinations);
        vaccinationsEditText.setText(patient.getVaccinations());

        alimentEditText = (EditText) rootView.findViewById(R.id.patientAliment);
        alimentEditText.setText(patient.getAilment());

        EditText patientEditTextWard = (EditText) rootView.findViewById(R.id.patientWard);
        EditText patientEditTextBed = (EditText) rootView.findViewById(R.id.patientBed);

        if (patient.getBed() != null)
        {
            patientEditTextBed.setText(patient.getBed().toString());
            patientEditTextWard.setText(patient.getBed().getWardName());
        }
        else
        {
            patientEditTextBed.setText("N/A");
            patientEditTextWard.setText("Unassigned");

        }



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
                                                Toast.makeText(ctx, "Success", Toast.LENGTH_SHORT).show();
                                            }

                                            @Override
                                            public void failure(RetrofitError error) {
                                                Toast.makeText(ctx, "Failure", Toast.LENGTH_SHORT).show();
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
                AlertDialog alertDialog = alertDialogBuilder.create();
                alertDialog.show();  //<-- See This!
            }
        });

        btnMedication.setOnClickListener(new View.OnClickListener() {
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
                                        medicationEditText.setText(userInput.getText()); //NEEDS CHANEGD
                                        patient.setMedication(medicationEditText.getText().toString()); //CHECK WITH GLENN
                                        patient.save(new Callback() {
                                            @Override
                                            public void success(Object o, Response response) {
                                                Toast.makeText(ctx, "Success", Toast.LENGTH_SHORT).show();
                                            }

                                            @Override
                                            public void failure(RetrofitError error) {
                                                Toast.makeText(ctx, "Failure", Toast.LENGTH_SHORT).show();
                                            }
                                        }); //NEEDS CHANGED

                                    }
                                })
                        .setNegativeButton("Cancel",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int id) {
                                        dialog.cancel();
                                    }
                                });



                AlertDialog alertDialog = alertDialogBuilder.create();
                alertDialog.show();  //<-- See This!

            }
        });

        btnVaccinations.setOnClickListener(new View.OnClickListener() {
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
                                        vaccinationsEditText.setText(userInput.getText()); //NEEDS CHANEGD
                                        patient.setVaccinations(vaccinationsEditText.getText().toString()); //CHECK WITH GLENN
                                        patient.save(new Callback() {
                                            @Override
                                            public void success(Object o, Response response) {
                                                Toast.makeText(ctx, "Success", Toast.LENGTH_SHORT).show();
                                            }

                                            @Override
                                            public void failure(RetrofitError error) {
                                                Toast.makeText(ctx, "Failure", Toast.LENGTH_SHORT).show();
                                            }
                                        }); //NEEDS CHANGED

                                    }
                                })
                        .setNegativeButton("Cancel",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int id) {
                                        dialog.cancel();
                                    }
                                });



                AlertDialog alertDialog = alertDialogBuilder.create();
                alertDialog.show();  //<-- See This!

            }
        });

        btnAliment.setOnClickListener(new View.OnClickListener() {
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
                                        alimentEditText.setText(userInput.getText()); //NEEDS CHANEGD
                                        patient.setAilment(alimentEditText.getText().toString()); //CHECK WITH GLENN
                                        patient.save(new Callback() {
                                            @Override
                                            public void success(Object o, Response response) {
                                                Toast.makeText(ctx, "Success", Toast.LENGTH_SHORT).show();
                                            }

                                            @Override
                                            public void failure(RetrofitError error) {
                                                Toast.makeText(ctx, "Failure", Toast.LENGTH_SHORT).show();
                                            }
                                        }); //NEEDS CHANGED

                                    }
                                })
                        .setNegativeButton("Cancel",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int id) {
                                        dialog.cancel();
                                    }
                                });



                AlertDialog alertDialog = alertDialogBuilder.create();
                alertDialog.show();  //<-- See This!

            }
        });
        //   setContentView(R.layout.fragment_bed_view);
        return rootView;
    }






}