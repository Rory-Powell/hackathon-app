package com.medmanagerui.adapters;

import android.app.Activity;
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

        public ListViewAdapter(Context c) {
        mContext = c;
    }

    public int getCount() {

        //return patients.size();
        return DataProvider.patientList.size();
    }

    public Object getItem(int position) {

        //return patients.get(position);
        return DataProvider.patientList.get(position);
    }

    public long getItemId(int position) {

        //return patients.get(position)
        return Long.getLong(DataProvider.patientList.get(position).getId());
    }

    // create a new View for each item referenced by the Adapter
    public View getView(int position, View convertView, ViewGroup parent) {

         if(convertView==null){
                // inflate the layout
                LayoutInflater inflater = ((Activity) mContext).getLayoutInflater();
                convertView = inflater.inflate(R.layout.patient_cell, parent, false);
            }

         // object item based on the position
            Patient patient = DataProvider.patientList.get(position);


         // get the TextView and then set the text (item name) and tag (item ID) values
         //TextView textViewItem = (TextView) convertView.findViewById(R.id.name);

        //ImageButton imageButton = (ImageButton) convertView.findViewById(R.)
         //textViewItem.setText("Name");
         //textViewItem.setTag();

         return convertView;
    }

    private List<String> patients;

}

