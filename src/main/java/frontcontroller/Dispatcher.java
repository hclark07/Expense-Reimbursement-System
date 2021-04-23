package frontcontroller;

import controller.TicketController;
import controller.UserController;
import io.javalin.Javalin;


public class Dispatcher {

    UserController myUser;
    TicketController myTicket;

    public Dispatcher (Javalin app) {

        setUpAllPaths(app);

    }

    public static void setUpAllPaths(Javalin app) {
        ticketDispatcher(app);
        userDispatcher(app);
    }

    public static void ticketDispatcher (Javalin app) {

        app.get("/ticket/list/", TicketController::getEmployeeTickets);
        app.get("/ticket/allTickets/", TicketController::getAllTickets);
        app.post("/ticket/add/", TicketController::addNewTicket);
        app.post("/ticket/statusUpdate/", TicketController::updateTicketStatus);

    }

    public static void userDispatcher(Javalin app) {
        app.get("/newSession/", UserController::newSession);
        app.get("/login/wrongLoginInfo/", UserController::wrongLoginInfo);
        app.post("/login/redirect/", UserController::redirectUser);
        app.get("/user/info/", UserController::getUserInfo);
        app.post("/login/newUser/", UserController::addNewUser);


//        app.routes(() -> {
//            path("/login/", () ->{
//                path("redirect/", () -> {
//                    post(UserController::redirectUser);
//                });
//                path("newUser/", () -> {
//                    post(UserController::addNewUser);
//                });
//                path("wrongLoginInfo/", () -> {
//                    post(UserController::wrongLoginInfo);
//                });
//            });
//            path("/user/", () ->{
//                path("info/", () -> {
//                    get(UserController::getUserInfo);
//                });
//            });
//            path("/newSession", () -> {
//                get(UserController::newSession);
//            });
//        });

    }

}
