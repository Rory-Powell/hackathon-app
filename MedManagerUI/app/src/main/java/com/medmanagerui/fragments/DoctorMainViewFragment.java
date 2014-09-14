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


public class DoctorMainViewFragment extends Fragment {


    private static final String ARG_SECTION_NUMBER = "section_number";
    ListView listview;
    /**
     * Returns a new instance of this fragment for the given section
     * number.
     */
    private static Context ctx;


    public static DoctorMainViewFragment newInstance(Context context, final FragmentManager mgr) {

        final DoctorMainViewFragment fragment = new DoctorMainViewFragment();
        fragment.ctx=context;
        final ProgressDialog dialog = ProgressDialog.show(context, "",
                "Loading. Please wait...", true);
        new NetworkingService().allPatients(new Callback<List<Patient>>() {
            @Override
            public void success(List<Patient> patients, Response response) {
                DataProvider.patientList = patients;
                dialog.hide();
                View rootView = LayoutInflater.from(ctx).inflate(R.layout.fragment_doctor_main_view, null);

                ListView listview= (ListView) rootView.findViewById(R.id.listView);
                ListViewAdapter lstAdapter = new ListViewAdapter(ctx, mgr);
                listview.setAdapter(lstAdapter);
                listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
                        Toast.makeText(ctx, "" + position, Toast.LENGTH_SHORT).show();
                    }
                });
                lstAdapter.patients = DataProvider.patientList;
                lstAdapter.notifyDataSetChanged();
            }

            @Override
            public void failure(RetrofitError error) {
                dialog.hide();
            }
        });

        new NetworkingService().allWards(new Callback<List<Ward>>() {
            @Override
            public void success(List<Ward> wards, Response response) {
                DataProvider.wardList = wards;
                dialog.hide();
            }

            @Override
            public void failure(RetrofitError error) {
                dialog.hide();
            }
        });
        return fragment;
    }

    public DoctorMainViewFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //   setContentView(R.layout.fragment_doctor_main_view);

        View rootView = LayoutInflater.from(ctx).inflate(R.layout.fragment_doctor_main_view, container,false);

        return rootView;
    }


}