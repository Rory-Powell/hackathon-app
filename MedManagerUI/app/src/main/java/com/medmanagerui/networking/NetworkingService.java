package com.medmanagerui.networking;

import android.os.AsyncTask;

import com.medmanagerui.models.Bed;
import com.medmanagerui.models.Patient;
import com.medmanagerui.models.Staff;
import com.medmanagerui.models.Ward;

import java.util.List;
import java.util.concurrent.Callable;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.http.Body;

/**
 * Created by gsayers on 13/09/2014.
 */
public class NetworkingService implements INetworking{

    static RestAdapter restAdapter = new RestAdapter.Builder()
            .setEndpoint("http://10.10.10.177:9000")
            .build();

    @Override
    public void allPatients(retrofit.Callback<List<Patient>> cb) {

        INetworking network = restAdapter.create(INetworking.class);
        network.allPatients(cb);
    }

    @Override
    public void allWards(retrofit.Callback<List<Ward>> cb) {

        INetworking network = restAdapter.create(INetworking.class);
        network.allWards(cb);
    }

    @Override
    public void allBeds(retrofit.Callback<List<Bed>> cb) {

        INetworking network = restAdapter.create(INetworking.class);
        network.allBeds(cb);
    }

    @Override
    public void allStaff(retrofit.Callback<List<Staff>> cb) {

        INetworking network = restAdapter.create(INetworking.class);
        network.allStaff(cb);
    }

    @Override
    public void savePatient(@Body Patient user, retrofit.Callback<Patient> cb) {
        INetworking network = restAdapter.create(INetworking.class);
        network.savePatient(user, cb);
    }

}
