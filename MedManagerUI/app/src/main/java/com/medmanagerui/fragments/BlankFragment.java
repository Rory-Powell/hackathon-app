package com.medmanagerui.fragments;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.ProgressDialog;
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
import com.medmanagerui.adapters.ListViewAdapter;
import com.medmanagerui.models.DataProvider;
import com.medmanagerui.models.Patient;
import com.medmanagerui.models.Ward;
import com.medmanagerui.networking.NetworkingService;

import java.util.List;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;


public class BlankFragment extends Fragment {


    private static final String ARG_SECTION_NUMBER = "section_number";
    ListView listview;
    /**
     * Returns a new instance of this fragment for the given section
     * number.
     */
    private static Context ctx;


    public static BlankFragment newInstance(Context context, final FragmentManager mgr) {

        final BlankFragment fragment = new BlankFragment();
        fragment.ctx=context;

        return fragment;
    }

    public BlankFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        View rootView = LayoutInflater.from(ctx).inflate(R.layout.fragment_blank, null);



        return rootView;
    }


}