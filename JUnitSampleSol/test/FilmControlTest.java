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
        //fail("The test case is a prototype.");
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
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getFilmByName method, of class FilmControl.
     */
    @Test
    public void testGetFilmByName() {
        System.out.println("getFilmByName");
        String filmName = "KONG";
        FilmControl instance = new FilmControl();
        Film temp1 = new Film("KONG", 118,Utility.Prepath+"pic/kong.jpg", "Skull ISLAND");

        String expResult = temp1.toString();
        
        Film temp = instance.getFilmByName(filmName);
        String result = temp.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of listFilm method, of class FilmControl.
     */
    @Test
    public void testListFilm() {
        System.out.println("listFilm");
        FilmControl instance = new FilmControl();
        ArrayList<String> result = new ArrayList<String>();
        ArrayList<String> expResult = new ArrayList<String>();
        
        ArrayList<Film> temp = instance.listFilm();
        
        Film temp2 = new Film("KONG", 118,"pic/kong.jpg", "Skull ISLAND");
        Film temp3 = new Film("LOGAN",135, "pic/logan.jpg","X-MAN");
        Film temp4 = new Film("Beauty And The Beast",130,"pic/bb.jpg","tell about a love story");
        Film temp5 = new Film("Moonlight",111,"pic/moonlight.jpg","A boy's story");
        Film temp6 = new Film("LA LA LAND",128,"pic/lala.jpg","Music Movie");
        
        expResult.add(temp2.toString());
        expResult.add(temp3.toString());
        expResult.add(temp4.toString());
        expResult.add(temp5.toString());
        expResult.add(temp6.toString());
        
        for (Film b : temp){
            result.add(b.toString());
        }
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
}
