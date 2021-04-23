package service;

import model.Reimbursement;

import java.util.List;

public interface ReimbServiceDAO {


    void updateTicketStatus (int reimbId, int reimb_status_id, int managerId); //<-- changing pending status and adding a resolver identifier
    List<Reimbursement> selectAllEmployeeTickets(int userId);
    List<Reimbursement> selectAllTickets ();


}
