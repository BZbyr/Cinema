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
public class AdminIOTest {
    
    public AdminIOTest() {
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
     * Test of readAdminInfo method, of class AdminIO.
     */
    @Test
    public void testReadAdminInfo() {
        System.out.println("readAdminInfo");
        AdminIO instance = new AdminIO();
        Admin instance1 = new Admin();
        Admin instance2 = new Admin();
        ArrayList<String> result = new ArrayList<String>();
        ArrayList<String> expResult = new ArrayList<String>();
        
        instance1.setUsername("wc");
        instance2.setUsername("tom");
        instance1.setPassword("2345");
        instance2.setPassword("123");
        
        expResult.add(instance2.toString());
        expResult.add(instance1.toString());
        
        ArrayList<Admin> temp = instance.readAdminInfo();
        
        for (Admin b : temp){
            result.add(b.toString());
        }
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
}
