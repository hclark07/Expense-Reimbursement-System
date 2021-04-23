package dao;

import model.User;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class TestDao {


    public static String url = "jdbc:h2:C:\\Users\\chake\\Desktop\\h2Test";
    public static String username = "sa";
    public static String password = "sa";


    public static void h2InitDao () {

        try(Connection conn=
                    DriverManager.getConnection(url,username, password))
        {
            String sql= "CREATE TABLE ers_user_roles (\n" +
                    "\ters_user_role_id int PRIMARY KEY \n" +
                    "\t,\tuser_role varchar (10)\n" +
                    ");\n" +
                    "\n" +
                    "INSERT INTO ers_user_roles (ers_user_role_id , user_role) VALUES (1, 'Employee');\n" +
                    "INSERT INTO ers_user_roles (ers_user_role_id , user_role) VALUES (2, 'Manager');\n" +
                    "\n" +
                    "\n" +
                    "CREATE TABLE ers_reimbursement_type (\n" +
                    "\treimb_type_id int PRIMARY KEY\n" +
                    "\t,\treimb_type varchar(10)\n" +
                    ");\n" +
                    "\n" +
                    "INSERT INTO ers_reimbursement_type (reimb_type_id, reimb_type) VALUES (1, 'Lodging');\n" +
                    "INSERT INTO ers_reimbursement_type (reimb_type_id, reimb_type) VALUES (2, 'Travel');\n" +
                    "INSERT INTO ers_reimbursement_type (reimb_type_id, reimb_type) VALUES (3, 'Food');\n" +
                    "INSERT INTO ers_reimbursement_type (reimb_type_id, reimb_type) VALUES (4, 'Other');\n" +
                    "\n" +
                    "\n" +
                    "CREATE TABLE ers_reimbursement_status (\n" +
                    "\treimb_status_id int PRIMARY KEY\n" +
                    "\t,\treimb_status varchar(10) \n" +
                    ");\n" +
                    "\n" +
                    "INSERT INTO ers_reimbursement_status (reimb_status_id , reimb_status) VALUES (1, 'Pending');\n" +
                    "INSERT INTO ers_reimbursement_status (reimb_status_id , reimb_status) VALUES (2, 'Approved');\n" +
                    "INSERT INTO ers_reimbursement_status (reimb_status_id , reimb_status) VALUES (3, 'Denied');\n" +
                    "\n" +
                    "\n" +
                    "CREATE TABLE ers_users (\n" +
                    "\ters_users_id SERIAL PRIMARY KEY\n" +
                    "\t,\ters_username varchar(50) \n" +
                    "\t,\ters_password varchar(100)\n" +
                    "\t,\tuser_first_name varchar(100)\n" +
                    "\t,\tuser_last_name varchar(100)\n" +
                    "\t,\tuser_email varchar(150) UNIQUE\n" +
                    "\t,\tuser_role_id int\n" +
                    "\t, \tCONSTRAINT ers_users_unv1 UNIQUE (ers_username, user_email)\n" +
                    "\t,\tCONSTRAINT user_roles_fk FOREIGN KEY (user_role_id) REFERENCES ers_user_roles (ers_user_role_id)\n" +
                    ");\n" +
                    "\n" +
                    "CREATE TABLE ers_reimbursement (\n" +
                    "\treimb_id SERIAL PRIMARY KEY\n" +
                    "\t,\treimb_amount int\n" +
                    "\t,\treimb_submitted date\n" +
                    "\t,\treimb_resolved date\n" +
                    "\t,\treimb_description varchar(250)\n" +
                    "\t,\treimb_receipt bytea\n" +
                    "\t,\treimb_author int\n" +
                    "\t,\treimb_resolver int\n" +
                    "\t,\treimb_status_id int\n" +
                    "\t,\treimb_type_id int\n" +
                    "\t,\tCONSTRAINT ers_users_fk_auth FOREIGN KEY (reimb_author) REFERENCES ers_users (ers_users_id)\n" +
                    "\t,\tCONSTRAINT ers_users_fk_reslvr FOREIGN KEY (reimb_resolver) REFERENCES ers_users (ers_users_id)\n" +
                    "\t,\tCONSTRAINT ers_reimbursement_status_fk FOREIGN KEY (reimb_status_id) REFERENCES ers_reimbursement_status (reimb_status_id)\n" +
                    "\t,\tCONSTRAINT ers_reimbursement_type_fk FOREIGN KEY (reimb_type_id) REFERENCES ers_reimbursement_type (reimb_type_id)\n" +
                    "); \n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "INSERT INTO ers_users (ers_username, ers_password, user_first_name, user_last_name, user_email, user_role_id)\n" +
                    "VALUES ('admin', 'admin', 'admin', 'admin', 'admin@admin', 1);\n" +
                    "\n" +
                    "INSERT INTO ers_users (ers_username, ers_password, user_first_name, user_last_name, user_email, user_role_id)\n" +
                    "VALUES ('admin2', 'admin', 'Bell', 'Clark', 'admin2@admin', 1);\n" +
                    "\n" +
                    "INSERT INTO ers_users (ers_username, ers_password, user_first_name, user_last_name, user_email, user_role_id)\n" +
                    "VALUES ('admin3', 'admin', 'Manager', 'Kun', 'manager@admin', 2);\n" +
                    "\n" +
                    "INSERT INTO ers_reimbursement (reimb_amount, reimb_submitted, reimb_description, reimb_author, reimb_status_id, reimb_type_id)\n" +
                    "VALUES (50, current_timestamp, 'Food from my travels', 1, 1, 4);\n" +
                    "\n" +
                    "INSERT INTO ers_reimbursement (reimb_amount, reimb_submitted, reimb_description, reimb_author, reimb_status_id, reimb_type_id)\n" +
                    "VALUES (80, current_timestamp, 'Slept like a king', 1, 1, 2);\n" +
                    "\n" +
                    "INSERT INTO ers_reimbursement (reimb_amount, reimb_submitted, reimb_description, reimb_author, reimb_status_id, reimb_type_id)\n" +
                    "VALUES (180, current_timestamp, 'Lost from my travels', 1, 1, 3);\n";


            Statement state = conn.createStatement();
            state.execute(sql);
        }catch(SQLException e) {
            e.printStackTrace();
        }

    }

    public static void h2DestroyDao() {
        try(Connection conn=
                    DriverManager.getConnection(url,username, password))
        {
            String sql= "" +
                    "DROP TABLE ers_reimbursement; " +
                    "DROP TABLE ers_users; " +
                    "DROP TABLE ers_user_roles; " +
                    "DROP TABLE ers_reimbursement_status; " +
                    "DROP TABLE ers_reimbursement_type; ";

            Statement state = conn.createStatement();
            state.execute(sql);
        }catch(SQLException e) {
            e.printStackTrace();
        }
    }

}
