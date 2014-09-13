package com.medmanagerui.fragments;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.Toast;

import com.medmanagerui.adapters.GridViewAdapter;
import com.medmanagerui.MainActivity;
import com.medmanagerui.R;


public class DoctorMainViewFragment extends Fragment {


    private static final String ARG_SECTION_NUMBER = "section_number";

    /**
     * Returns a new instance of this fragment for the given section
     * number.
     */
    private Context ctx;

    public static DoctorMainViewFragment newInstance(Context context) {
        DoctorMainViewFragment fragment = new DoctorMainViewFragment();
        fragment.ctx=context;
        return fragment;
    }

    public DoctorMainViewFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View rootView = inflater.inflate(R.layout.fragment_doctor_main_view, container, false);

        //   setContentView(R.layout.fragment_doctor_main_view);

        ListView listview = (ListView) getView().findViewById(R.id.listView);
        listview.setAdapter(new GridViewAdapter(ctx));
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
                Toast.makeText(ctx, "" + position, Toast.LENGTH_SHORT).show();
            }
        });
        return rootView;
    }
}