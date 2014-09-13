package com.medmanagerui.fragments;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import com.medmanagerui.R;
import com.medmanagerui.adapters.GridViewAdapter;


public class BedViewFragment extends Fragment {


    private static final String ARG_SECTION_NUMBER = "section_number";
    private static final int DIALOG_ALERT = 10;

    /**
     * Returns a new instance of this fragment for the given section
     * number.
     */
    private Context ctx;

    public static BedViewFragment newInstance(Context context) {
        BedViewFragment fragment = new BedViewFragment();
        fragment.ctx=context;
        return fragment;
    }

    public BedViewFragment() {
    }

 //   public View onCreateView(LayoutInflater inflater, ViewGroup container,
  //                           Bundle savedInstanceState) {



    @Override
 public View onCreateView(LayoutInflater inflater, ViewGroup container,
                          Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View rootView = inflater.inflate(R.layout.fragment_bed_view, container, false);

     //   setContentView(R.layout.fragment_bed_view);

        GridView gridview = (GridView) rootView.findViewById(R.id.gridview);
        gridview.setAdapter(new GridViewAdapter(ctx));
        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
                Toast.makeText(ctx, "" + position, Toast.LENGTH_SHORT).show();
       //         showDialog(DIALOG_ALERT);

            }
        });
     return rootView;
    }

        }