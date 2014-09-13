package com.medmanagerui.networking;

import android.os.AsyncTask;

import com.medmanagerui.models.Patient;
import com.medmanagerui.models.Ward;

import java.util.List;
import java.util.concurrent.Callable;

import retrofit.Callback;
import retrofit.RestAdapter;

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
}
