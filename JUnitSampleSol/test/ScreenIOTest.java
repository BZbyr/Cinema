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
public class ScreenIOTest {
    
    public ScreenIOTest() {
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
     * Test of calScreenNum method, of class ScreenIO.
     */
    @Test
    public void testCalScreenNum() {
        System.out.println("calScreenNum");
        ScreenIO instance = new ScreenIO();
        int expResult = 0;
        int result = instance.calScreenNum();
        //assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of writeScreenInfo method, of class ScreenIO.
     */
    @Test
    public void testWriteScreenInfo() {
        System.out.println("writeScreenInfo");
        Screen screen = null;
        boolean appendFlag = false;
        ScreenIO instance = new ScreenIO();
        //instance.writeScreenInfo(screen, appendFlag);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of readScreenInfo method, of class ScreenIO.
     */
    @Test
    public void testReadScreenInfo() {
        System.out.println("readScreenInfo");
        ScreenIO instance = new ScreenIO();
        ArrayList<Screen> expResult = null;
        ArrayList<Screen> result = instance.readScreenInfo();
        //assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
}
