package service;

import dao.ReimbursementDAOImpl;
import dao.TestDao;
import model.Reimbursement;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;


import java.sql.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ReimbServiceDAOImplTest {
    ReimbServiceDAOImpl rServDAO = new ReimbServiceDAOImpl();

    @BeforeEach
    void setUp() {
        TestDao.h2InitDao();
    }

    @AfterEach
    void destroy() {
        TestDao.h2DestroyDao();
    }

    @Disabled
    @Test
    void updateTicketStatus() {
    }


    @Test
    void selectAllEmployeeTickets() {
        List<Reimbursement> tickets = rServDAO.selectAllEmployeeTickets(1);

        Date date = new Date(1617235200000L);

        Reimbursement r1 = new Reimbursement(50,date, null, "Food from my travels","null null",  "Pending", "Other");
        Reimbursement r2 = new Reimbursement(80,date, null, "Slept like a king","null null",  "Pending", "Travel");
        Reimbursement r3 = new Reimbursement(180,date, null, "Lost from my travels","null null",  "Pending", "Food");

        //One way to do list tests
        assertAll(
                ()-> assertEquals(r1.toString(), tickets.get(0).toString()),
                ()-> assertEquals(r2.toString(), tickets.get(1).toString()),
                ()-> assertEquals(r3.toString(), tickets.get(2).toString())
        );

    }

    @Disabled
    @Test
    void selectAllTickets() {
    }
}