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
public class FilmControlTest {
    
    public FilmControlTest() {
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
     * Test of addFilm method, of class FilmControl.
     */
    @Test
    public void testAddFilm() {
        System.out.println("addFilm");
        Film film = null;
        FilmControl instance = new FilmControl();
        instance.addFilm(film);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of deleteFilm method, of class FilmControl.
     */
    @Test
    public void testDeleteFilm() {
        System.out.println("deleteFilm");
        Film film = null;
        FilmControl instance = new FilmControl();
        instance.deleteFilm(film);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getFilmByName method, of class FilmControl.
     */
    @Test
    public void testGetFilmByName() {
        System.out.println("getFilmByName");
        String filmName = "";
        FilmControl instance = new FilmControl();
        Film expResult = null;
        Film result = instance.getFilmByName(filmName);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of listFilm method, of class FilmControl.
     */
    @Test
    public void testListFilm() {
        System.out.println("listFilm");
        FilmControl instance = new FilmControl();
        ArrayList<Film> expResult = null;
        ArrayList<Film> result = instance.listFilm();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
