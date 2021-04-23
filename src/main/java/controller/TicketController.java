package controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import dao.ReimbursementDAO;
import dao.ReimbursementDAOImpl;
import io.javalin.Javalin;
import io.javalin.http.Context;
import model.Reimbursement;
import model.TicketStatus;
import model.User;
import service.ReimbServiceDAO;
import service.ReimbServiceDAOImpl;


import java.util.List;



public class TicketController {

    Javalin app;
    private static ReimbursementDAO reimbDAO = new ReimbursementDAOImpl();
    private static ReimbServiceDAO reimbServiceDAO = new ReimbServiceDAOImpl();


    public TicketController() {

    }

    /**
     * Retrieve a list of tickets submitted by the employee user
     * @param context
     */
    public static void getEmployeeTickets(Context context) {
        User user = context.sessionAttribute("currentUser");

        int userId = user.getUserId();

        context.json(reimbServiceDAO.selectAllEmployeeTickets(userId));
    }

    /**
     * Add a new ticket submission to the database
     * @param context
     */
    public static void addNewTicket(Context context) {
        System.out.println("In the new ticket");
        User user = context.sessionAttribute("currentUser");
        int amount = Integer.parseInt(context.formParam("amount"));
        int option = Integer.parseInt(context.formParam("option"));
        String description = context.formParam("description");

        Reimbursement ticket = new Reimbursement(amount, description, user.getUserId(), 1, option);
        reimbDAO.addTicket(ticket);

        context.status(201);
        context.redirect("/employee.html");
    }

    /**
     * Get a list of all tickets for manager level users
     * @param context
     */
    public static void getAllTickets(Context context) {
        context.json(reimbServiceDAO.selectAllTickets());
    }

    /**
     * Update a ticket's status, current date, and manager id
     * @param context
     * @throws JsonProcessingException
     */
    public static void updateTicketStatus(Context context) throws JsonProcessingException {
        User user = context.sessionAttribute("currentUser");

        System.out.println("in the update ticket status method");

        ObjectMapper mapper = new ObjectMapper();

        String json = context.body();

        List<TicketStatus> statusList = mapper.readValue(json, new TypeReference<List<TicketStatus>>() {});

        for(TicketStatus ts : statusList) {
            reimbServiceDAO.updateTicketStatus(ts.getReimbId(), ts.getReimb_status_id(), user.getUserId());
        }




    }

}