/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.ArrayList;
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
public class TicketIOTest {
    
    public TicketIOTest() {
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
     * Test of writeInfo method, of class TicketIO.
     */
    @Test
    public void testWriteInfo() {
        System.out.println("writeInfo");
        Object obj = null;
        TicketIO instance = new TicketIO();
        boolean expResult = false;
        boolean result = instance.writeInfo(obj);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of readInfo method, of class TicketIO.
     */
    @Test
    public void testReadInfo() {
        System.out.println("readInfo");
        TicketIO instance = new TicketIO();
        ArrayList<Ticket> expResult = null;
        ArrayList<Ticket> result = instance.readInfo();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
