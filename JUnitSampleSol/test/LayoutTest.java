/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

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
public class LayoutTest {
    
    public LayoutTest() {
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
     * Test of getLayoutId method, of class Layout.
     */
    @Test
    public void testGetLayoutId() {
        System.out.println("getLayoutId");
        Layout instance = new Layout();
        int expResult = 0;
        int result = instance.getLayoutId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setLayoutId method, of class Layout.
     */
    @Test
    public void testSetLayoutId() {
        System.out.println("setLayoutId");
        int lyoutId = 0;
        Layout instance = new Layout();
        instance.setLayoutId(lyoutId);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getRowNum method, of class Layout.
     */
    @Test
    public void testGetRowNum() {
        System.out.println("getRowNum");
        Layout instance = new Layout();
        int expResult = 0;
        int result = instance.getRowNum();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setRowNum method, of class Layout.
     */
    @Test
    public void testSetRowNum() {
        System.out.println("setRowNum");
        int rowNum = 0;
        Layout instance = new Layout();
        instance.setRowNum(rowNum);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getColNum method, of class Layout.
     */
    @Test
    public void testGetColNum() {
        System.out.println("getColNum");
        Layout instance = new Layout();
        int expResult = 0;
        int result = instance.getColNum();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setColNum method, of class Layout.
     */
    @Test
    public void testSetColNum() {
        System.out.println("setColNum");
        int colNum = 0;
        Layout instance = new Layout();
        instance.setColNum(colNum);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getMissSeatSet method, of class Layout.
     */
    @Test
    public void testGetMissSeatSet() {
        System.out.println("getMissSeatSet");
        Layout instance = new Layout();
        HashSet<Seat> expResult = null;
        HashSet<Seat> result = instance.getMissSeatSet();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setMissSeatSet method, of class Layout.
     */
    @Test
    public void testSetMissSeatSet() {
        System.out.println("setMissSeatSet");
        HashSet<Seat> missSeatSet = null;
        Layout instance = new Layout();
        instance.setMissSeatSet(missSeatSet);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
