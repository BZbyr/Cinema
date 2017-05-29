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
public class FilmTest {
    
    public FilmTest() {
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
     * Test of getFilmId method, of class Film.
     */
    @Test
    public void testGetFilmId() {
        System.out.println("getFilmId");
        Film instance = new Film();
        int expResult = 0;
        int result = instance.getFilmId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getfilmName method, of class Film.
     */
    @Test
    public void testGetfilmName() {
        System.out.println("getfilmName");
        Film instance = new Film();
        String expResult = "";
        String result = instance.getfilmName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTimeInterval method, of class Film.
     */
    @Test
    public void testGetTimeInterval() {
        System.out.println("getTimeInterval");
        Film instance = new Film();
        int expResult = 0;
        int result = instance.getTimeInterval();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPictureSrc method, of class Film.
     */
    @Test
    public void testGetPictureSrc() {
        System.out.println("getPictureSrc");
        Film instance = new Film();
        String expResult = "";
        String result = instance.getPictureSrc();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getFilmIntro method, of class Film.
     */
    @Test
    public void testGetFilmIntro() {
        System.out.println("getFilmIntro");
        Film instance = new Film();
        String expResult = "";
        String result = instance.getFilmIntro();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setFilmId method, of class Film.
     */
    @Test
    public void testSetFilmId() {
        System.out.println("setFilmId");
        int filmId = 0;
        Film instance = new Film();
        instance.setFilmId(filmId);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setFilmName method, of class Film.
     */
    @Test
    public void testSetFilmName() {
        System.out.println("setFilmName");
        String filmName = "";
        Film instance = new Film();
        instance.setFilmName(filmName);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setTimeInterval method, of class Film.
     */
    @Test
    public void testSetTimeInterval() {
        System.out.println("setTimeInterval");
        int timeInterval = 0;
        Film instance = new Film();
        instance.setTimeInterval(timeInterval);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setPictureSrc method, of class Film.
     */
    @Test
    public void testSetPictureSrc() {
        System.out.println("setPictureSrc");
        String pictureSrc = "";
        Film instance = new Film();
        instance.setPictureSrc(pictureSrc);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setFilmIntro method, of class Film.
     */
    @Test
    public void testSetFilmIntro() {
        System.out.println("setFilmIntro");
        String filmIntro = "";
        Film instance = new Film();
        instance.setFilmIntro(filmIntro);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
