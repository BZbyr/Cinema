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
public class AdminTest {
    
    public AdminTest() {
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
     * Test of getUsername method, of class Admin.
     */
    @Test
    public void testGetUsername() {
        System.out.println("getUsername");
        Admin instance = new Admin();
        String expResult = "";
        String result = instance.getUsername();
        //assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setUsername method, of class Admin.
     */
    @Test
    public void testSetUsername() {
        System.out.println("setUsername");
        String username = "";
        Admin instance = new Admin();
        instance.setUsername(username);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getPassword method, of class Admin.
     */
    @Test
    public void testGetPassword() {
        System.out.println("getPassword");
        Admin instance = new Admin();
        String expResult = "";
        String result = instance.getPassword();
        //assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setPassword method, of class Admin.
     */
    @Test
    public void testSetPassword() {
        System.out.println("setPassword");
        String password = "";
        Admin instance = new Admin();
        //instance.setPassword(password);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of equals method, of class Admin.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Admin admin = null;
        Admin instance = new Admin();
        boolean expResult = false;
        //boolean result = instance.equals(admin);
        //assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
}
