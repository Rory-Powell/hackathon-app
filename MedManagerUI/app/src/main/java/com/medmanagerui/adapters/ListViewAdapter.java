package com.medmanagerui.adapters;

import android.app.Activity;
import android.app.FragmentManager;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListAdapter;
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

         // object item based on the position
         //Patient patient = DataProvider.patientList.get(position);

         // get the TextView and then set the text (item name) and tag (item ID) values
         //TextView textViewItem = (TextView) convertView.findViewById(R.id.name);

        Patient thePatient = patients.get(position);

        TextView textViewName = (TextView) convertView.findViewById(R.id.patient_Name);
        textViewName.setText(thePatient.getName());

//        TextView textViewWard = (TextView) convertView.findViewById(R.id.patient_Ward);
//        textViewWard.setText(thePatient.getBed().getWardName());

//        TextView textViewBed = (TextView) convertView.findViewById(R.id.patient_Bed);
//        textViewBed.setText(patients.get(position).getBed().toString());

        ImageButton imageButton = (ImageButton) convertView.findViewById(R.id.imageButton);

        imageButton.setImageResource(R.drawable.logo2);

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
         //textViewItem.setText("Name");
         //textViewItem.setTag();

         return convertView;
    }

    public List<Patient> patients = DataProvider.patientList;

}

