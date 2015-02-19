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

    private Miinaharavainen harava;
    private Ruutu ruutu;

    public RuutuTest() {
    }

    @Test
    public void ruudussaEiAluksiMiinaJaMiinanLisaysOnnistuu() {
        assertEquals(ruutu.getOnkoMiina(), false);
        ruutu.setOnkoMiina(true);
        assertEquals(ruutu.getOnkoMiina(), true);
    }

    @Test
    public void palauttaaRuudunNakyvyydenAluksiFalse() {
        assertEquals(ruutu.getOnkoRuutuNakyva(), false);
    }

    @Test
    public void ruudunNakyvyysVaihdettavissa() {
        ruutu.setOnkoRuutuNakyva(true);
        assertEquals(ruutu.getOnkoRuutuNakyva(), true);
    }

    @Test
    public void ruudunLiputtaminenToimii() {
        ruutu.setOnkoRuutuNakyva(false);
        ruutu.setOnkoLiputettu(true);
        assertEquals(ruutu.isOnkoLiputettu(), true);
    }
     @Test
    public void ruudunLiputtaminenEiToimii() {
        ruutu.setOnkoRuutuNakyva(true);
        ruutu.setOnkoLiputettu(true);
        assertEquals(ruutu.isOnkoLiputettu(), false);
    }
    
    @Test
    public void ruudunKoordinaatitToimii() {
        assertEquals(ruutu.getX(), 1);
        assertEquals(ruutu.getY(), 1);
    }

    @Test
    public void ruudussaMiinaTulostuuOikein() {
        ruutu.setOnkoMiina(true);
        ruutu.setViereistenMiinojenMaara(3);
        assertEquals(ruutu.toString(), " x");
    }

    @Test
    public void ruudussaLiikaaViereisiaMiinojaTulostuuOikein() {
        ruutu.setViereistenMiinojenMaara(9);
        assertEquals(ruutu.getViereistenMiinojenMaara(), 0);
        assertEquals(ruutu.toString(), " .");
    }

    @Test
    public void ruudussaNegatiivinenArvoMiinojenmaaraTulostuuOikein() {
        ruutu.setViereistenMiinojenMaara(-1);
        assertEquals(ruutu.getViereistenMiinojenMaara(), 0);
        assertEquals(ruutu.toString(), " .");
    }

    @Test
    public void viereistenMiinojenMaaraTulostuuOikein8() {
        ruutu.setViereistenMiinojenMaara(8);
        assertEquals(ruutu.getViereistenMiinojenMaara(), 8);
        assertEquals(ruutu.toString(), " 8");
    }

    @Test
    public void viereistenMiinojenMaaraTulostuuOikein0() {
        ruutu.setViereistenMiinojenMaara(0);
        assertEquals(ruutu.getViereistenMiinojenMaara(), 0);
        assertEquals(ruutu.toString(), " .");
    }

    @Test
    public void tyhjaRuutuTulostuuOikein() {
        assertEquals(ruutu.toString(), " .");
    }

    @Test
    public void ruudunKokoOikein() {
        assertEquals(ruutu.getRuudunKorkeus(), 24);
        assertEquals(ruutu.getRuudunLeveys(), 24);
    }

    @BeforeClass
    public static void setUpClass() {

    }

    @AfterClass
    public static void tearDownClass() {

    }

    @Before
    public void setUp() {
        harava = new Miinaharavainen(10, 10);
        ruutu = new Ruutu(1, 1, harava.getPelilauta());
    }

    @After
    public void tearDown() {
    }

}
