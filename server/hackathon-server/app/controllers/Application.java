package controllers;

import com.fasterxml.jackson.databind.node.ObjectNode;
import models.Bed;
import models.Staff;
import models.Ward;
import play.*;

import play.data.DynamicForm;
import play.data.Form;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.*;

import java.util.List;
import java.util.Map;

public class Application extends Controller {

    public static Result index() {
        return ok(index.render());

    }

    public static Result nurse() {
        List<Ward> wards = Ward.find.all();
        List<Bed> beds = Bed.find.all();
        return ok(nurse.render(wards, beds));
    }

    public static Result login() {

        /** Bind the request data to a form. **/
        Map<String, String[]> data = Controller.request().body().asFormUrlEncoded();

        if (null == data) {
            flash("error", "Please provide login details");
            return ok(index.render());
        }

        final String userID = data.get("id")[0];
        final String password = data.get("password")[0];

        if (null == userID || null == password) {
            flash("error", "Please provide login details");
            return ok(index.render());
        }

        Staff staff = Staff.find.where().eq("id", userID).eq("password", password).findUnique();

        if (staff != null) {

            Controller.session("email", userID);
            /** TODO redirect to appropriate doctor or nurse screen **/
            return redirect(
                    controllers.routes.Application.nurse()
            );
        } else {
            flash("error", "Login details are not correct.");
            return ok(index.render());
        }
    }
    public static Result nursepatientdetails() {
        List<Bed> beds = Bed.find.all();
        List<Ward> wards = Ward.find.all();

        return ok(nursepatientdetails.render(wards, beds));
    }

    public static Result patient() {
        List<Bed> beds = Bed.find.all();
        List<Ward> wards = Ward.find.all();
        return ok(patient.render(wards, beds));
    }

}
