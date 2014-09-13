package com.medmanagerui.networking;

import com.medmanagerui.models.Patient;
import com.medmanagerui.models.Ward;

import java.util.List;
import java.util.concurrent.Callable;

import javax.security.auth.callback.Callback;

import retrofit.http.GET;

/**
 * Created by gsayers on 13/09/2014.
 */
public interface INetworking {

    @GET("/mobile/allPatients")
    void allPatients(retrofit.Callback<List<Patient>> cb);

    @GET("/mobile/allWards")
    void allWards(retrofit.Callback<List<Ward>> cb);
}
