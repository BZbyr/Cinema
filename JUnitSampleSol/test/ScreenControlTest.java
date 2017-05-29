/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.ArrayList;
import java.util.Date;
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
public class ScreenControlTest {
    
    public ScreenControlTest() {
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
     * Test of update method, of class ScreenControl.
     */
    @Test
    public void testUpdate() {
        System.out.println("update");
        int screenId = 0;
        String Date = "";
        int num = 0;
        ScreenControl instance = new ScreenControl();
        instance.update(screenId, Date, num);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTimeByFilm method, of class ScreenControl.
     */
    @Test
    public void testGetTimeByFilm() {
        System.out.println("getTimeByFilm");
        int filmId = 0;
        ScreenControl instance = new ScreenControl();
        ArrayList<Date> expResult = null;
        ArrayList<Date> result = instance.getTimeByFilm(filmId);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getScreenByDate method, of class ScreenControl.
     */
    @Test
    public void testGetScreenByDate() {
        System.out.println("getScreenByDate");
        String filmName = "";
        String date = "";
        ScreenControl instance = new ScreenControl();
        Screen expResult = null;
        Screen result = instance.getScreenByDate(filmName, date);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
