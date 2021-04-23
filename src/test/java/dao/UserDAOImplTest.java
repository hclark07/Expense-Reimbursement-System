package dao;

import model.User;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


/**
 * Test methods in the UserDAO class
 */
class UserDAOImplTest {

    UserDAOImpl userDao = new UserDAOImpl();


    @BeforeEach
    void setUp () {
        TestDao.h2InitDao();
    }

    @AfterEach
    void destroy () {
        TestDao.h2DestroyDao();
    }

    @Test
    void addUser() {
        assertTrue(userDao.addUser(new User("admin4", "password", "admin4", "admin4", "admin4@gmail.com", 1)));

        assertFalse(userDao.addUser(new User("admin4", "password", "admin4", "admin4", "admin4@gmail.com", 1)));
    }


}