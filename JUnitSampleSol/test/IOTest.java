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
public class IOTest {
    
    public IOTest() {
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
     * Test of readInfo method, of class IO.
     */
    @Test
    public void testReadInfo() {
        System.out.println("readInfo");
        IO instance = new IOImpl();
        ArrayList expResult = null;
        ArrayList result = instance.readInfo();
        //assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of writeInfo method, of class IO.
     */
    @Test
    public void testWriteInfo() {
        System.out.println("writeInfo");
        Object obj = null;
        IO instance = new IOImpl();
        boolean expResult = false;
        boolean result = instance.writeInfo(obj);
        //assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    public class IOImpl implements IO {

        public ArrayList readInfo() {
            return null;
        }

        public boolean writeInfo(Object obj) {
            return false;
        }
    }
    
}
