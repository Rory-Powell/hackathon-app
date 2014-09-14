package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import jdk.nashorn.internal.ir.ObjectNode;
import models.Bed;
import models.Patient;
import models.Staff;
import models.Ward;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;

import java.util.Calendar;

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

    public static Result fetchAllWards() {
        return ok(Json.toJson(Ward.find.all()));
    }

    public static Result savePatient() {

        try {
            JsonNode json = request().body().asJson();
            Patient patient = Patient.find.byId(json.get("id").textValue());
            patient.name = json.get("name").textValue();
            Calendar cal = Calendar.getInstance();
            cal.setTimeInMillis(json.get("dob").asLong());
            patient.dob = cal;
            patient.address = json.get("address").textValue();

            patient.gp = json.get("gp").textValue();
            if(null != json.get("doctor")) {
                patient.doctor = Staff.find.byId(json.get("doctor").textValue());
            }
            if(null != json.get("previousDoctor")) {
                patient.previousDoctor = Staff.find.byId(json.get("previousDoctor").textValue());
            }
            patient.ailment = json.get("ailment").textValue();
            patient.allergies = json.get("allergies").textValue();
            patient.notes = json.get("notes").textValue();
            if(null != json.get("previousDoctor")) {
                patient.bed = Bed.find.byId(json.get("bed").textValue());
            }

            patient.update();
            return ok(Json.toJson(patient));
        }
        catch (Exception e){
            return badRequest(Json.toJson(e.getMessage()));
        }

    }

}
