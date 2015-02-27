package nimirum.Miinaharavainen.logiikka;

import nimirum.Miinaharavainen.gui.Kayttoliittyma;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class MiinaharavainenTest {

    private Miinaharavainen testi;

    public MiinaharavainenTest() {

    }

    @Test
    public void konstruktoriToimiiArvolla8() {
        testi = new Miinaharavainen(8, 8);
        assertEquals(testi.getPelilauta().getX(), 8);
        assertEquals(testi.getPelilauta().getY(), 8);
    }

    @Test
    public void konstruktoriToimiiArvolla40() {
        testi = new Miinaharavainen(40, 40);
        assertEquals(testi.getPelilauta().getX(), 40);
        assertEquals(testi.getPelilauta().getY(), 40);
    }

    @Test
    public void konstruktoriEiToimiVaarallaArvolla() {
        testi = new Miinaharavainen(3, 3);
        assertEquals(testi.getPelilauta().getX(), 10);
        assertEquals(testi.getPelilauta().getY(), 10);
    }

    @Test
    public void miinojenMaaraNollaEnnenKentänGenerointa() {
        testi = new Miinaharavainen(20, 20);
        assertEquals(testi.getMiinojenMaara(), 0);
    }

    @Test
    public void miinojenMaaraOikeinKentänGeneroinninJalkeen() {
        testi = new Miinaharavainen(20, 20);
        testi.miinoitaLauta(10, 10);
        assertEquals(testi.getMiinojenMaara(), 60);
        assertEquals(true, testi.isPelilautaMiinoitettu());
    }

    @Test
    public void pelissaMukanaKello() {
        testi = new Miinaharavainen(20, 20);
        assertEquals(0, testi.getKello().getAika());
    }

    @Test
    public void peliGameOverArvotToimivat() {
        testi = new Miinaharavainen(20, 20);
        testi.miinoitaLauta(10, 10);
        testi.gameOver("Voitto");
        assertEquals("Voitto", testi.getGameOver());
        testi.gameOver("Havio");
        assertEquals("Havio", testi.getGameOver());
    }

    @Test
    public void peliGameOverVoittoToimii() {
        testi = new Miinaharavainen(20, 20);
        testi.miinoitaLauta(10, 10);
        testi.gameOver("Voitto");
        assertEquals("Voitto", testi.getGameOver());
        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 20; j++) {
                Ruutu ruutu = testi.getPelilauta().getRuutu(i, j);
                assertEquals(true, ruutu.getOnkoRuutuAvattu());
            }
        }
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
