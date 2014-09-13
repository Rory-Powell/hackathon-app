package controllers;

import play.mvc.Http;
import play.mvc.Result;
import play.mvc.Security;

/**
 * Created by gsayers on 13/09/2014.
 */
public class Secured extends Security.Authenticator {

    /**
     * Fetches the users email from the current session.
     * @param ctx Application context
     * @return The current username
     */
    @Override
    public final String getUsername(final Http.Context ctx) {
        return ctx.session().get("id");
    }

    /**
     * If the user is unauthorised, redirect back to the login page.
     * @param ctx Application context
     * @return Result()
     */
    @Override
    public final Result onUnauthorized(final Http.Context ctx) {
        return redirect(controllers.routes.Application.login());
    }
}