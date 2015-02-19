package nimirum.Miinaharavainen.logiikka;

import nimirum.Miinaharavainen.logiikka.Miinaharavainen;
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
public class MiinaharavainenTest {

    public MiinaharavainenTest() {
        
    }

    //Pelilaudan tulostamisen testaus ei mielekästä, koska väliaikainen
    
    @Test
    public void konstruktoriToimiiArvolla8() {
        Miinaharavainen testi = new Miinaharavainen(8, 8);
        assertEquals(testi.getPelilauta().getX(), 8);
        assertEquals(testi.getPelilauta().getY(), 8);
    }

    @Test
    public void konstruktoriToimiiArvolla20() {
        Miinaharavainen testi = new Miinaharavainen(50, 50);
        assertEquals(testi.getPelilauta().getX(), 50);
        assertEquals(testi.getPelilauta().getY(), 50);
    }
    
     @Test
    public void konstruktoriEiToimiVaarallaArvolla() {
        Miinaharavainen testi = new Miinaharavainen(3, 3);
        assertEquals(testi.getPelilauta().getX(), 10);
        assertEquals(testi.getPelilauta().getY(), 10);
    }

    @Test
    public void miinojenMaaraNollaEnnenKentänGenerointa() {
        Miinaharavainen testi = new Miinaharavainen(20, 20);
        assertEquals(testi.getMiinojenMaara(), 0);
    }
    
    @Test
    public void miinojenMaaraOikeinKentänGeneroinninJalkeen() {
        Miinaharavainen testi = new Miinaharavainen(20, 20);
        testi.miinoitaLauta();
        assertEquals(testi.getMiinojenMaara(), 60);
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

}
