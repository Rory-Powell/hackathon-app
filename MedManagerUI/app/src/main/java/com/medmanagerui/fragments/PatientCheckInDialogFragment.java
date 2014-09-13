package com.medmanagerui.fragments;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Spinner;

import com.medmanagerui.R;
import com.medmanagerui.adapters.ListViewAdapter;

/**
 * Created by dmurray on 13/09/2014.
 */
public class PatientCheckInDialogFragment extends DialogFragment{
        Context cxt;


        //@Override
        public Dialog onCreateDialog(LayoutInflater inflater, ViewGroup container,
                                     Bundle savedInstanceState) {
            // Use the Builder class for convenient dialog construction
            AlertDialog.Builder builder = new AlertDialog.Builder(cxt);
            View dialogView = inflater.inflate(R.layout.checkin_spinner, container, false);

                    builder.setView(dialogView)
                    .setPositiveButton(R.string.select_PatientDialog, new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                        }
                    })
                    .setNegativeButton(R.string.select_DoctorDialog, new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {

                        }

                    });


            // Create the AlertDialog object and return it
            return builder.create();
        }
    }

