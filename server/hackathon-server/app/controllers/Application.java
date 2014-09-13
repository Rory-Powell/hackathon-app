package controllers;

import com.fasterxml.jackson.databind.node.ObjectNode;
import models.Staff;
import play.*;

import play.data.DynamicForm;
import play.data.Form;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.*;

public class Application extends Controller {

    public static Result index() {
        return ok(index.render());

    }

    public static Result nurse() {
        return ok(nurse.render());
    }

    public static Result login() {

        /** Bind the request data to a form. **/
        DynamicForm requestData = Form.form().bindFromRequest();

        ObjectNode result = Json.newObject();

        if (null == requestData) {
            result.put("success", false);
            result.put(
                    "message",
                    "User credentials must be provided"
            );
            return ok(result);
        }

        final String userID = requestData.get("id");
        final String password = requestData.get("password");

        if (null == userID || null == password) {
            result.put("success", false);
            result.put(
                    "message",
                    "User credentials must be provided"
            );
            return ok(result);
        }

        Staff staff = Staff.find.where().eq("id", userID).eq("password", password).findUnique();

        if (staff != null) {

            Controller.session("email", userID);
            /** TODO redirect to appropriate doctor or nurse screen **/
            return redirect(
                    controllers.routes.Application.nurse()
            );
        } else {
            result.put("success", false);
            result.put(
                    "message",
                    "User credentials are not correct"
            );
            return ok(result);
        }
    }
    public static Result nursepatientdetails() {
        return ok(nursepatientdetails.render());
    }

}
