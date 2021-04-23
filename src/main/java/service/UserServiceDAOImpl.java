package service;

import dao.TestDao;
import model.User;

import java.sql.*;

public class UserServiceDAOImpl implements UserServiceDAO {

    public static String url = "jdbc:postgresql://" + System.getenv("TRAINING_DB_ENDPOINT") + "/socialmedia";
    public static String username = System.getenv("TRAINING_DB_USERNAME");
    public static String password = System.getenv("TRAINING_DB_PASSWORD");


//    public static String url = TestDao.url;
//    public static String username = TestDao.username;
//    public static String password = TestDao.password;

    /**
     * Takes in a string username and password and returns a User
     * If username and password do not exist then returns null
     * @param email
     * @param password
     * @return
     */
    public User checkCredentials (String email, String password) {

        User user = null;

        try (Connection conn = DriverManager.getConnection(url, this.username, this.password)) {

            String sql = "SELECT * FROM ers_users WHERE user_email =? AND ers_password =?";

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, email);
            ps.setString(2, password);


            ResultSet rs = ps.executeQuery();

            while(rs.next()) {
                user = new User (
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getInt(7)
                );
            }

            //add an error message whenever constraints are broken <--role id or unique username+email
        } catch (SQLException e) {
            System.out.println("wrong login or password");
        }
        if (user == null) {
            return null;
        }
        return user;
    };


    /**
     * Retrieve a User object with just a username value. Param username is username of user object
     * @param username
     * @return
     */
    public User getUserByUsername(String username) {

        User getUser = null;

        try (Connection conn = DriverManager.getConnection(url, this.username, this.password)) {

            String sql = "SELECT * FROM ers_users WHERE ers_username =?";

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, username);



            ResultSet rs = ps.executeQuery();

            while(rs.next()) {
                getUser = new User (
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getInt(7)
                );
            }


            //add an error message whenever constraints are broken <--role id or unique username+email
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return getUser;
    }


}
