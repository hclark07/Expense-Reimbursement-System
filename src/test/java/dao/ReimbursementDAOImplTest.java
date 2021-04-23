package dao;

import model.Reimbursement;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ReimbursementDAOImplTest {

    ReimbursementDAOImpl reimbDAO = new ReimbursementDAOImpl();

    @BeforeEach
    void setUp () {
        TestDao.h2InitDao();
    }

    @AfterEach
    void destroy () {
        TestDao.h2DestroyDao();
    }

    @Test
    void addTicket () {
        assertTrue(reimbDAO.addTicket(new Reimbursement(100, "Hello", 1, 1,3)));

        assertTrue(reimbDAO.addTicket(new Reimbursement(250, "Hello", 1, 1,4)));

        assertFalse(reimbDAO.addTicket(new Reimbursement(80, "Hello", 6, 1,3)));
    }
}