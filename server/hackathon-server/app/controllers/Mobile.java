package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import models.Bed;
import models.Patient;
import models.Staff;
import models.Ward;
import play.data.DynamicForm;
import play.data.Form;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.index;

import java.util.Calendar;
import java.util.Map;

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

    public static Result fetchAllStaff() {
        return ok(Json.toJson(Staff.find.all()));
    }

    public static Result login() {

        /** Bind the request data to a form. **/
        DynamicForm requestData = Form.form().bindFromRequest();

        if (null == requestData) {
            flash("error", "Please provide login details");
            return ok(index.render());
        }

        final String userID = requestData.get("id");
        final String password = requestData.get("password");

        if (null == userID || null == password) {
            ObjectNode jsonResponse = Json.newObject();
            jsonResponse.put("success", false);
            return ok(jsonResponse);
        }

        Staff staff = Staff.find.where().eq("id", userID).eq("password", password).findUnique();

        if (staff != null) {

            ObjectNode jsonResponse = Json.newObject();
            jsonResponse.put("success", true);
            return ok(jsonResponse);
        } else {
            ObjectNode jsonResponse = Json.newObject();
            jsonResponse.put("success", false);
            return ok(jsonResponse);
        }
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
