package dao;


import model.Reimbursement;



import java.sql.*;


public class ReimbursementDAOImpl implements ReimbursementDAO {

    public static String url = "jdbc:postgresql://" + System.getenv("TRAINING_DB_ENDPOINT") + "/socialmedia";
    public static String username = System.getenv("TRAINING_DB_USERNAME");
    public static String password = System.getenv("TRAINING_DB_PASSWORD");

//    public static String url = TestDao.url;
//    public static String username = TestDao.username;
//    public static String password = TestDao.password;


    /**
     * Adding a new reimbursement ticket to the database
     * Keeps tracks of who submitted the ticket
     * @param reimb
     * @return true if successfully added
     */
    public boolean addTicket (Reimbursement reimb) {

        try (Connection conn = DriverManager.getConnection(url, this.username, this.password)) {

            String sql = "INSERT INTO ers_reimbursement (reimb_amount, reimb_description, reimb_submitted, reimb_author, reimb_status_id, reimb_type_id)\n" +
                    "VALUES (?, ?, ?, ?, ?, ?);";

            PreparedStatement ps = conn.prepareStatement(sql);


            ps.setInt(1, reimb.getAmount());
            ps.setString(2, reimb.getDescription());
            ps.setDate(3, java.sql.Date.valueOf(java.time.LocalDate.now()));
            ps.setInt(4, reimb.getAuthor());
            ps.setInt(5, reimb.getStatusId());
            ps.setInt(6, reimb.getTypeId());

            ps.executeUpdate();
            System.out.println("Successfully added new ticket");
            return true;


        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    };


}
