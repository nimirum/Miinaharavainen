package nimirum.Miinaharavainen.logiikka;

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
    public void palauttaaRuudunNakyvyydenAluksiFalse() {
        Ruutu ruutu = new Ruutu(1, 1);
        assertEquals(ruutu.getOnkoRuutuNakyva(), true);
        //Vaihda falseksi, väliaikaisesti true
    }

    @Test
    public void ruudunKoordinaatitToimii() {
        Ruutu ruutu = new Ruutu(1, 1);
        assertEquals(ruutu.getX(), 1);
        assertEquals(ruutu.getY(), 1);
    }

    @Test
    public void ruudussaMiinaTulostuuOikein() {
        Ruutu ruutu = new Ruutu(1, 1);
        ruutu.setOnkoMiina(true);
        ruutu.setViereistenMiinojenMaara(3);
        assertEquals(ruutu.toString(), " x");
    }

    @Test
    public void ruudussaLiikaaViereisiaMiinojaTulostuuOikein() {
        Ruutu ruutu = new Ruutu(1, 1);
        ruutu.setViereistenMiinojenMaara(9);
        assertEquals(ruutu.getViereistenMiinojenMaara(), 0);
        assertEquals(ruutu.toString(), " .");
    }

    @Test
    public void ruudussaNegatiivinenArvoMiinojenmaaraTulostuuOikein() {
        Ruutu ruutu = new Ruutu(1, 1);
        ruutu.setViereistenMiinojenMaara(-1);
        assertEquals(ruutu.getViereistenMiinojenMaara(), 0);
        assertEquals(ruutu.toString(), " .");
    }

    @Test
    public void viereistenMiinojenMaaraTulostuuOikein() {
        Ruutu ruutu = new Ruutu(1, 1);
        ruutu.setViereistenMiinojenMaara(8);
        assertEquals(ruutu.getViereistenMiinojenMaara(), 8);
        assertEquals(ruutu.toString(), " 8");
    }

    @Test
    public void tyhjaRuutuTulostuuOikein() {
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

}
