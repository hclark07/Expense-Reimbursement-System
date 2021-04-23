package service;

import dao.TestDao;
import model.User;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserServiceDAOImplTest {
    UserServiceDAOImpl uServDAO = new UserServiceDAOImpl();

    @BeforeEach
    void setUp() {
        TestDao.h2InitDao();
    }

    @AfterEach
    void destroy() {
        TestDao.h2DestroyDao();
    }

    @Test
    void testCheckCredentials() {

        User user1 = new User(2, "admin2", "admin", "Bell", "Clark", "admin2@admin", 1);
        User user2 = uServDAO.checkCredentials("admin2@admin", "admin");

        assertEquals(user1.toString(), user2.toString());

        User user3 = new User(1, "admin", "admin", "admin", "admin", "admin@admin", 1);
        User user4 = uServDAO.checkCredentials("admin@admin", "admin");

        assertEquals(user3.toString(), user4.toString());

    }

}
