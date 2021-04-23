package frontcontroller;

import controller.TicketController;
import controller.UserController;
import io.javalin.Javalin;
import io.javalin.http.Context;
import model.User;

import java.util.Dictionary;

public class FrontController {

    Javalin app;
    Dispatcher dispatcher;

    public FrontController (Javalin app) {
        this.app = app;

        app.before("/user/*", FrontController::beforeHandler);
        app.before("/ticket/*", FrontController::beforeHandler);
        dispatcher = new Dispatcher(app);
    }

    /**
     * Before handler that authenticates if a user session exists
     * If a user session does not exists then redirect user back to login page
     * @param context
     */
    public static void beforeHandler (Context context) {

        User user = context.sessionAttribute("currentUser");
        if(user == null) {
            context.redirect("/index.html");
        } else {
            context.sessionAttribute("loginFail", null);
        }
    }

}
