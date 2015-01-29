package nimirum.Miinaharavainen.logiikka;

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
public class PelilautaTest {

    public PelilautaTest() {
    }

    @Test
    public void miinanAsetusToimii() {
        Miinaharavainen miinaharava = new Miinaharavainen(10, 10);
        Pelilauta lauta = miinaharava.getPelilauta();
        lauta.setMiina(0, 0);
        assertEquals(lauta.getRuutu(0, 0).getOnkoMiina(), true);
    }

    @Test
    public void miinaVasenYlanurkkaLaskuriToimii() {
        Miinaharavainen miinaharava = new Miinaharavainen(10, 10);
        Pelilauta lauta = miinaharava.getPelilauta();
        lauta.setMiina(0, 0);
        lauta.laskeNumerot();
        assertEquals(lauta.getRuutu(0, 1).getViereistenMiinojenMaara(), 1);
        assertEquals(lauta.getRuutu(1, 1).getViereistenMiinojenMaara(), 1);
        assertEquals(lauta.getRuutu(1, 0).getViereistenMiinojenMaara(), 1);
    }

    @Test
    public void miinaYlareunaLaskuriToimii() {
        Miinaharavainen miinaharava = new Miinaharavainen(10, 10);
        Pelilauta lauta = miinaharava.getPelilauta();
        lauta.setMiina(0, 5);
        lauta.laskeNumerot();
        assertEquals(lauta.getRuutu(0, 4).getViereistenMiinojenMaara(), 1);
        assertEquals(lauta.getRuutu(0, 6).getViereistenMiinojenMaara(), 1);
        assertEquals(lauta.getRuutu(1, 4).getViereistenMiinojenMaara(), 1);
        assertEquals(lauta.getRuutu(1, 5).getViereistenMiinojenMaara(), 1);
        assertEquals(lauta.getRuutu(1, 6).getViereistenMiinojenMaara(), 1);
    }

    @Test
    public void miinaOikeaYlanurkkaLaskuriToimii() {
        Miinaharavainen miinaharava = new Miinaharavainen(10, 10);
        Pelilauta lauta = miinaharava.getPelilauta();
        lauta.setMiina(0, 9);
        lauta.laskeNumerot();
        assertEquals(lauta.getRuutu(0, 8).getViereistenMiinojenMaara(), 1);
        assertEquals(lauta.getRuutu(1, 8).getViereistenMiinojenMaara(), 1);
        assertEquals(lauta.getRuutu(1, 9).getViereistenMiinojenMaara(), 1);
    }

    @Test
    public void miinaOikeaReunaLaskuriToimii() {
        Miinaharavainen miinaharava = new Miinaharavainen(10, 10);
        Pelilauta lauta = miinaharava.getPelilauta();
        lauta.setMiina(5, 9);
        lauta.laskeNumerot();
        assertEquals(lauta.getRuutu(4, 9).getViereistenMiinojenMaara(), 1);
        assertEquals(lauta.getRuutu(6, 9).getViereistenMiinojenMaara(), 1);
        assertEquals(lauta.getRuutu(4, 8).getViereistenMiinojenMaara(), 1);
        assertEquals(lauta.getRuutu(5, 8).getViereistenMiinojenMaara(), 1);
        assertEquals(lauta.getRuutu(6, 8).getViereistenMiinojenMaara(), 1);
    }

    @Test
    public void miinaVasenAlanurkkaLaskuriToimii() {
        Miinaharavainen miinaharava = new Miinaharavainen(10, 10);
        Pelilauta lauta = miinaharava.getPelilauta();
        lauta.setMiina(9, 0);
        lauta.laskeNumerot();
        assertEquals(lauta.getRuutu(8, 0).getViereistenMiinojenMaara(), 1);
        assertEquals(lauta.getRuutu(8, 1).getViereistenMiinojenMaara(), 1);
        assertEquals(lauta.getRuutu(9, 1).getViereistenMiinojenMaara(), 1);
    }

    @Test
    public void miinaVasenReunaLaskuriToimii() {
        Miinaharavainen miinaharava = new Miinaharavainen(10, 10);
        Pelilauta lauta = miinaharava.getPelilauta();
        lauta.setMiina(5, 0);
        lauta.laskeNumerot();
        assertEquals(lauta.getRuutu(5, 1).getViereistenMiinojenMaara(), 1);
        assertEquals(lauta.getRuutu(6, 1).getViereistenMiinojenMaara(), 1);
        assertEquals(lauta.getRuutu(4, 1).getViereistenMiinojenMaara(), 1);
        assertEquals(lauta.getRuutu(4, 0).getViereistenMiinojenMaara(), 1);
        assertEquals(lauta.getRuutu(6, 0).getViereistenMiinojenMaara(), 1);
    }

    @Test
    public void miinaAlareunaLaskuriToimii() {
        Miinaharavainen miinaharava = new Miinaharavainen(10, 10);
        Pelilauta lauta = miinaharava.getPelilauta();
        lauta.setMiina(9, 5);
        lauta.laskeNumerot();
        assertEquals(lauta.getRuutu(9, 4).getViereistenMiinojenMaara(), 1);
        assertEquals(lauta.getRuutu(9, 6).getViereistenMiinojenMaara(), 1);
        assertEquals(lauta.getRuutu(8, 4).getViereistenMiinojenMaara(), 1);
        assertEquals(lauta.getRuutu(8, 5).getViereistenMiinojenMaara(), 1);
        assertEquals(lauta.getRuutu(8, 6).getViereistenMiinojenMaara(), 1);
    }

    @Test
    public void kaksiMiinaaLaskuriToimii() {
        Miinaharavainen miinaharava = new Miinaharavainen(10, 10);
        Pelilauta lauta = miinaharava.getPelilauta();
        lauta.setMiina(4, 5);
        lauta.setMiina(6, 5);
        lauta.laskeNumerot();
        assertEquals(lauta.getRuutu(5, 5).getViereistenMiinojenMaara(), 2);
    }

    @Test
    public void miinaKeskellaLaskuriToimii() {
        Miinaharavainen miinaharava = new Miinaharavainen(10, 10);
        Pelilauta lauta = miinaharava.getPelilauta();
        lauta.setMiina(5, 5);
        lauta.laskeNumerot();
        assertEquals(lauta.getRuutu(4, 4).getViereistenMiinojenMaara(), 1);
        assertEquals(lauta.getRuutu(4, 5).getViereistenMiinojenMaara(), 1);
        assertEquals(lauta.getRuutu(4, 6).getViereistenMiinojenMaara(), 1);
        assertEquals(lauta.getRuutu(6, 5).getViereistenMiinojenMaara(), 1);
        assertEquals(lauta.getRuutu(4, 5).getViereistenMiinojenMaara(), 1);
        assertEquals(lauta.getRuutu(6, 4).getViereistenMiinojenMaara(), 1);
        assertEquals(lauta.getRuutu(6, 5).getViereistenMiinojenMaara(), 1);
        assertEquals(lauta.getRuutu(6, 6).getViereistenMiinojenMaara(), 1);
    }

    @Test
    public void miinaOikeaAlanurkkaLaskuriToimii() {
        Miinaharavainen miinaharava = new Miinaharavainen(10, 10);
        Pelilauta lauta = miinaharava.getPelilauta();
        lauta.setMiina(9, 9);
        lauta.laskeNumerot();
        assertEquals(lauta.getRuutu(8, 8).getViereistenMiinojenMaara(), 1);
        assertEquals(lauta.getRuutu(8, 9).getViereistenMiinojenMaara(), 1);
        assertEquals(lauta.getRuutu(9, 8).getViereistenMiinojenMaara(), 1);
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
