package com.medmanagerui.adapters;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;

import com.medmanagerui.R;

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
        return 10;
    }

    public Object getItem(int position) {

        //return patients.get(position);
        return null;
    }

    public long getItemId(int position) {

        //return patients.get(position)
        return 0;
    }

    // create a new ImageView for each item referenced by the Adapter
    public View getView(int position, View convertView, ViewGroup parent) {

         if(convertView==null){
                // inflate the layout
                LayoutInflater inflater = ((Activity) mContext).getLayoutInflater();
                convertView = inflater.inflate(R.layout.patient_cell, parent, false);
            }

         // object item based on the position
         //ObjectItem objectItem = data[position];


         // get the TextView and then set the text (item name) and tag (item ID) values
         TextView textViewItem = (TextView) convertView.findViewById(R.id.name);
         textViewItem.setText("Name");
         //textViewItem.setTag();

         return convertView;
    }

    private List<String> patients;

}

