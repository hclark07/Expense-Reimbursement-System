package controller;

import dao.UserDAO;
import dao.UserDAOImpl;
import io.javalin.Javalin;
import io.javalin.http.Context;
import model.User;
import service.UserServiceDAO;
import service.UserServiceDAOImpl;

public class UserController {

    Javalin app;
    private static UserDAO uDao = new UserDAOImpl();
    private static UserServiceDAO userServiceDAO = new UserServiceDAOImpl();

    public UserController () {

    }


    /**
     * Return a user object to user
     * @param context
     */
    public static void getUserInfo (Context context) {
        User user = context.sessionAttribute("currentUser");

        context.json(user);
    }


    /**
     * Upon successful login create a user session and redirect user to correct page depending if they are a manager or employee
     * @param context
     */
    public static void redirectUser (Context context) {

        User user;
        String email = context.formParam("email");
        String password = context.formParam("password");

        user = userServiceDAO.checkCredentials(email, password);

        context.sessionAttribute("currentUser", user);

        if(user == null) {
            context.sessionAttribute("loginFail", "true");
            context.redirect("/index.html");
        }else if(user.getRoleId()==1) {
            context.redirect("/employee.html");
        } else {
            context.redirect("/manager.html");
        }

    }

    /**
     * Accept new user input from a form and use to create a new user in the database
     * @param context
     */
    public static void addNewUser (Context context) {
        String fname = context.formParam("fname");
        String lname = context.formParam("lname");
        String email = context.formParam("email");
        String password = context.formParam("password");
        int typeId = Integer.parseInt(context.formParam("type"));

        uDao.addUser(new User ("",password,fname,lname,email,typeId));

        context.sessionAttribute("loginFail", null);
        context.redirect("/index.html");

    }

    /**
     * Boolean value that checks if user put in incorrect login information
     * Return boolean value back to client
     * @param context
     * @throws IllegalArgumentException
     */
    public static void wrongLoginInfo (Context context) {
        String loginBoolean = context.sessionAttribute("loginFail");

        if(loginBoolean == "true")
            context.json(loginBoolean);
    }

    /**
     * When going back to the login page reset session to null
     * @param context
     */
    public static void newSession (Context context) {

        context.sessionAttribute("currentUser", null);
    }

}
