package service;

import model.Reimbursement;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ReimbServiceDAOImpl implements ReimbServiceDAO {

    public static String url = "jdbc:postgresql://" + System.getenv("TRAINING_DB_ENDPOINT") + "/socialmedia";
    public static String username = System.getenv("TRAINING_DB_USERNAME");
    public static String password = System.getenv("TRAINING_DB_PASSWORD");
    private Reimbursement reimb;


    /**
     * Update an existing ticket status when a manager approves or denies reimbursement request
     * @param reimbId
     * @param reimb_status_id
     * @param managerId
     */
    public void updateTicketStatus (int reimbId, int reimb_status_id, int managerId) {
        try (Connection conn = DriverManager.getConnection(url, this.username, this.password)) {

            String sql = "UPDATE ers_reimbursement SET reimb_status_id = ?, reimb_resolver = ?, reimb_resolved = ? WHERE reimb_id = ?";


            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, reimb_status_id);
            ps.setInt(2, managerId);
            ps.setDate(3, java.sql.Date.valueOf(java.time.LocalDate.now()));
            ps.setInt(4, reimbId);


            ps.executeUpdate();


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    /**
     * Return a list of reimbursement tickets that the employee owns
     * @param userId
     * @return
     */
    public List<Reimbursement> selectAllEmployeeTickets(int userId) {
        List<Reimbursement> tickets = new ArrayList<>();

        try (Connection conn = DriverManager.getConnection(url, this.username, this.password)) {

            String sql = "SELECT  er.reimb_amount, er.reimb_submitted, reimb_resolved, er.reimb_description, eu2.user_first_name, eu2.user_last_name, ers.reimb_status , ert.reimb_type\n" +
                    "FROM ers_reimbursement er INNER JOIN ers_users eu ON er.reimb_author = eu.ers_users_id \n" +
                    "INNER JOIN ers_reimbursement_type ert ON er.reimb_type_id = ert.reimb_type_id \n" +
                    "INNER JOIN ers_reimbursement_status ers ON ers.reimb_status_id = er.reimb_status_id\n" +
                    "LEFT JOIN ers_users eu2 ON eu2.ers_users_id = er.reimb_resolver  WHERE eu.ers_users_id =?;\n";

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, userId);

            ResultSet rs = ps.executeQuery();

            String firstLastName="";


            while (rs.next()) {



                tickets.add(
                        new Reimbursement(
                                rs.getInt(1),
                                rs.getDate(2),
                                rs.getDate(3),
                                rs.getString(4),
                                firstLastName = rs.getString(5) + " " + rs.getString(6),
                                rs.getString(7),
                                rs.getString(8)
                        )
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (tickets == null) {
            System.out.println("No accounts have been assigned");
        }
        return tickets;
    }


    /**
     * Return a list of all tickets in the ers_reimbursement table
     * @return
     */
    public List<Reimbursement> selectAllTickets () {
        List<Reimbursement> tickets = new ArrayList<>();

        try (Connection conn = DriverManager.getConnection(url, this.username, this.password)) {

            String sql = "SELECT er.reimb_id, er.reimb_amount, er.reimb_submitted, reimb_resolved, er.reimb_description, eu.user_first_name, eu.user_last_name, ers.reimb_status , ert.reimb_type FROM ers_reimbursement er LEFT JOIN ers_users eu ON er.reimb_author = ers_users_id\n" +
                    "INNER JOIN  ers_reimbursement_type ert ON er.reimb_type_id = ert.reimb_type_id \n" +
                    "INNER JOIN ers_reimbursement_status ers ON ers.reimb_status_id = er.reimb_status_id";

            PreparedStatement ps = conn.prepareStatement(sql);


            ResultSet rs = ps.executeQuery();

            String firstLastName ="";

            while (rs.next()) {



                tickets.add(
                        new Reimbursement(
                                rs.getInt(1),
                                rs.getInt(2),
                                rs.getDate(3),
                                rs.getDate(4),
                                rs.getString(5),
                                firstLastName = rs.getString(6) + " " + rs.getString(7),
                                rs.getString(8),
                                rs.getString(9)
                        )
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (tickets == null) {
            System.out.println("No accounts have been assigned");
        }
        return tickets;
    }

}
