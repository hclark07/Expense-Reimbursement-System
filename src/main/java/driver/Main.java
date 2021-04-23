package driver;

import frontcontroller.FrontController;
import io.javalin.Javalin;

public class Main {
    public static void main(String[] args) {
        //This is where program will be run from



        //Server stuff <--- practice


        Javalin app = Javalin.create(
                config -> {config.addStaticFiles("/html-pages");
                            config.addStaticFiles("/css");
                            config.addStaticFiles("/js");
                }
        ).start(9227);

        FrontController fc = new FrontController(app);






    }
}
