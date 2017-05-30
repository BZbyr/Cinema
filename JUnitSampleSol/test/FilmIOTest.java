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
public class FilmIOTest {
    
    public FilmIOTest() {
        
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
     * Test of readFilmInfo method, of class FilmIO.
     */
    @Test
    public void testReadFilmInfo() {
        System.out.println("readFilmInfo");
        String param = " ";
        FilmIO instance = new FilmIO();
        Film expResult = null;
        Film result = instance.readFilmInfo(param);
        //assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of writeFilmInfo method, of class FilmIO.
     */
    @Test
    public void testWriteFilmInfo() {
        System.out.println("writeFilmInfo");
        Film film = null;
        FilmIO instance = new FilmIO();
        //instance.writeFilmInfo(film);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of calfilmNum method, of class FilmIO.
     */
    @Test
    public void testCalfilmNum() {
        System.out.println("calfilmNum");
        FilmIO instance = new FilmIO();
        int expResult = 0;
        int result = instance.calfilmNum();
        //assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
}
