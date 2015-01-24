package nimirum.Miinaharavainen.logiikka;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import nimirum.Miinaharavainen.logiikka.Ruutu;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author nexu770
 */
public class RuutuTest {

    public RuutuTest() {
    }

    @Test
    public void ruudussaEiAluksiMiinaJaMiinanLisaysOnnistuu() {
        Ruutu ruutu = new Ruutu(1, 1);
        assertEquals(ruutu.getOnkoMiina(), false);
        ruutu.setOnkoMiina(true);
        assertEquals(ruutu.getOnkoMiina(), true);
    }

    @Test
    public void ruudussaMiinaTulostuuOikein() {
        //väliaikainen
        Ruutu ruutu = new Ruutu(1, 1);
        ruutu.setOnkoMiina(true);
        ruutu.setViereistenMiinojenMaara(3);
        assertEquals(ruutu.toString(), " x");
    }

    @Test
    public void viereistenMiinojenMaaraTulostuuOikein() {
        //väliaikainen
        Ruutu ruutu = new Ruutu(1, 1);
        ruutu.setViereistenMiinojenMaara(3);
        assertEquals(ruutu.getViereistenMiinojenMaara(), 3);
        assertEquals(ruutu.toString(), " 3");
    }
    
     @Test
    public void tyhjaRuutuTulostuuOikein() {
        //väliaikainen
        Ruutu ruutu = new Ruutu(1, 1);
        assertEquals(ruutu.toString(), " .");
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

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
