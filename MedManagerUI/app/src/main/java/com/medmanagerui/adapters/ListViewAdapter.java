package com.medmanagerui.adapters;

import android.app.Activity;
import android.app.FragmentManager;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.TextView;

import com.medmanagerui.InfoPatientFragment;
import com.medmanagerui.R;
import com.medmanagerui.models.DataProvider;
import com.medmanagerui.models.Patient;

import java.util.List;

/**
 * Created by rory on 13/09/14.
 */
public class ListViewAdapter extends BaseAdapter

    {
        private Context mContext;
        private FragmentManager mFrag;

        public ListViewAdapter(Context c, FragmentManager fragmentManager) {

        mContext = c;
        mFrag = fragmentManager;
    }

    public int getCount() {
        return DataProvider.patientList.size();
        //return 5;
    }

    public Object getItem(int position) {

        return patients.get(position);
    }

    public long getItemId(int position) {
        //return patients.get(position)
        String ID = patients.get(position).getId();
        Long id = Long.getLong(ID);
        return id;
    }

    // create a new View for each item referenced by the Adapter
    public View getView(final int position, View convertView, ViewGroup parent) {

         if(convertView==null){
                // inflate the layout
                LayoutInflater inflater = ((Activity) mContext).getLayoutInflater();
                convertView = inflater.inflate(R.layout.patient_cell, parent, false);
            }

        Patient thePatient = patients.get(position);

        TextView textViewName = (TextView) convertView.findViewById(R.id.patient_Name);
        if(thePatient.getName() != null)
            textViewName.setText(thePatient.getName());
        else
            textViewName.setText("First Last");

        TextView textViewBed = (TextView) convertView.findViewById(R.id.patient_Bed);
        if(thePatient.getBed() != null)
            textViewBed.setText(thePatient.getBed().toString());
        else
            textViewBed.setText("Unassigned");

        TextView textViewWard = (TextView) convertView.findViewById(R.id.patient_Ward);
        if(thePatient.getBed() != null)
            textViewWard.setText(thePatient.getBed().getWardName());
        else
            textViewWard.setText("Unassigned");

        ImageButton imageButton = (ImageButton) convertView.findViewById(R.id.imageButton);

        char initial = thePatient.getName().charAt(0);

        switch(initial)
        {
            case 'G':
                imageButton.setImageResource(R.drawable.letter_g);
                break;
            case 'R':
                imageButton.setImageResource(R.drawable.letter_r);
                break;
            case 'D':
                imageButton.setImageResource(R.drawable.letter_d);
                break;
            case 'A':
                imageButton.setImageResource(R.drawable.letter_a);
                break;
            default:
                imageButton.setImageResource(R.drawable.logo2);
                break;
        }

        imageButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view)
                    {

                        InfoPatientFragment.patient = patients.get(position);

                        mFrag.beginTransaction()
                                .replace(R.id.container, InfoPatientFragment.newInstance(mContext))
                                .commit();
                    }
                });

         return convertView;
    }

    public List<Patient> patients = DataProvider.patientList;

}

