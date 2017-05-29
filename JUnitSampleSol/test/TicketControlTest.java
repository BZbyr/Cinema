/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.Date;
import java.util.HashSet;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author zbyki
 */
public class TicketControlTest {
    
    public TicketControlTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of generateTicket method, of class TicketControl.
     */
    @Test
    public void testGenerateTicket() {
        System.out.println("generateTicket");
        Screen chosenScreen = null;
        Seat chosenSeat = null;
        int ticketType = 0;
        TicketControl instance = new TicketControl();
        Ticket expResult = null;
        Ticket result = instance.generateTicket(chosenScreen, chosenSeat, ticketType);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of saveTicket method, of class TicketControl.
     */
    @Test
    public void testSaveTicket() {
        System.out.println("saveTicket");
        Ticket ticket = null;
        TicketControl instance = new TicketControl();
        boolean expResult = false;
        boolean result = instance.saveTicket(ticket);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTakenSeat method, of class TicketControl.
     */
    @Test
    public void testGetTakenSeat() {
        System.out.println("getTakenSeat");
        int screenID = 0;
        Date date = null;
        TicketControl instance = new TicketControl();
        HashSet<Seat> expResult = null;
        HashSet<Seat> result = instance.getTakenSeat(screenID, date);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
