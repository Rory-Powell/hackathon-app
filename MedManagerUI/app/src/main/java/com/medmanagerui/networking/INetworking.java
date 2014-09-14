package com.medmanagerui.networking;

import com.medmanagerui.models.Bed;
import com.medmanagerui.models.Patient;
import com.medmanagerui.models.Staff;
import com.medmanagerui.models.Ward;

import java.util.List;
import java.util.concurrent.Callable;

import javax.security.auth.callback.Callback;

import retrofit.http.Body;
import retrofit.http.GET;
import retrofit.http.POST;

/**
 * Created by gsayers on 13/09/2014.
 */
public interface INetworking {

    @GET("/mobile/allPatients")
    void allPatients(retrofit.Callback<List<Patient>> cb);

    @GET("/mobile/allWards")
    void allWards(retrofit.Callback<List<Ward>> cb);

    @GET("/mobile/allBeds")
    void allBeds(retrofit.Callback<List<Bed>> cb);

    @GET("/mobile/allStaff")
    void allStaff(retrofit.Callback<List<Staff>> cb);

    @POST("/mobile/savePatient")
    void savePatient(@Body Patient user, retrofit.Callback<Patient> cb);
}
