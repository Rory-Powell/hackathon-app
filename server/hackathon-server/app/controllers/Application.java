package controllers;

import play.*;

import play.mvc.Controller;
import play.mvc.Result;
import views.html.*;

public class Application extends Controller {

    public static Result index() {
        return ok(index.render("Your new application is ready."));
    }

    public static Result nurse() {
        return ok(nurse.render());
    }

    public static Result nursepatientdetails() {
        return ok(nursepatientdetails.render());
    }

}