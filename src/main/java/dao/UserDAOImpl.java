package dao;

import model.User;


import java.sql.*;


public class UserDAOImpl implements UserDAO{

    public static String url = "jdbc:postgresql://" + System.getenv("TRAINING_DB_ENDPOINT") + "/socialmedia";
    public static String username = System.getenv("TRAINING_DB_USERNAME");
    public static String password = System.getenv("TRAINING_DB_PASSWORD");

//    public static String url = TestDao.url;
//    public static String username = TestDao.username;
//    public static String password = TestDao.password;





    /**
     * Takes a new user and inserts the their information into the postgresql database
     * If the username or email is not unique return a false value;
     * @param user
     * @return true if addUser is successful
     */
    public boolean addUser (User user) {

        try (Connection conn = DriverManager.getConnection(url, this.username, this.password)) {

            String sql = "INSERT INTO ers_users (ers_username, ers_password, user_first_name, user_last_name, user_email, user_role_id)\n" +
                    "VALUES (?,?,?,?,?,?);";

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, user.getUsername());
            ps.setString(2, user.getPassword());
            ps.setString(3, user.getFname());
            ps.setString(4, user.getLname());
            ps.setString(5, user.getEmail());
            ps.setInt(6, user.getRoleId());

            ps.executeUpdate();
            System.out.println("Successfully added new user");
            return true;

            //add an error message whenever constraints are broken <--role id or unique username+email
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    };





}
