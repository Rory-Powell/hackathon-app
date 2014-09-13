package controllers;

import play.*;

import views.html.*;

public class Application extends Controller {

    public static Result index() {
        return ok(index.render("Your new application is ready."));
    }

    public static Result nurse() {
        return ok(nurse.render("This is the nurse page"));
    }

}