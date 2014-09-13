package controllers;

import jdk.nashorn.internal.ir.ObjectNode;
import models.Bed;
import models.Patient;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;

/**
 * Hnales all requests to/from the mobile client.
 * Created by gsayers on 13/09/2014.
 */
public class Mobile extends Controller {

    public static Result fetchAllPatients() {
        return ok(Json.toJson(Patient.find.all()));
    }

    public static Result fetchAllBeds() {
        return ok(Json.toJson(Bed.find.all()));
    }

}
