/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

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
public class SeatTest {
    
    public SeatTest() {
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
     * Test of isTakenFlag method, of class Seat.
     */
    @Test
    public void testIsTakenFlag() {
        System.out.println("isTakenFlag");
        Seat instance = new Seat();
        boolean expResult = false;
        boolean result = instance.isTakenFlag();
        //assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setTakenFlag method, of class Seat.
     */
    @Test
    public void testSetTakenFlag() {
        System.out.println("setTakenFlag");
        boolean takenFlag = false;
        Seat instance = new Seat();
        //instance.setTakenFlag(takenFlag);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getColNum method, of class Seat.
     */
    @Test
    public void testGetColNum() {
        System.out.println("getColNum");
        Seat instance = new Seat();
        int expResult = 0;
        int result = instance.getColNum();
        //assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setColNum method, of class Seat.
     */
    @Test
    public void testSetColNum() {
        System.out.println("setColNum");
        int colNum = 0;
        Seat instance = new Seat();
        //instance.setColNum(colNum);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getRowNum method, of class Seat.
     */
    @Test
    public void testGetRowNum() {
        System.out.println("getRowNum");
        Seat instance = new Seat();
        int expResult = 0;
        int result = instance.getRowNum();
        //assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setRowNum method, of class Seat.
     */
    @Test
    public void testSetRowNum() {
        System.out.println("setRowNum");
        int rowNum = 0;
        Seat instance = new Seat();
        //instance.setRowNum(rowNum);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of equals method, of class Seat.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object o = null;
        Seat instance = new Seat();
        boolean expResult = false;
        //boolean result = instance.equals(o);
        //assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of hashCode method, of class Seat.
     */
    @Test
    public void testHashCode() {
        System.out.println("hashCode");
        Seat instance = new Seat();
        int expResult = 0;
        int result = instance.hashCode();
        //assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
}
