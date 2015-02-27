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
public class RuutuTest {

    private Miinaharavainen harava;
    private Ruutu ruutu;

    public RuutuTest() {
    }

    @Test
    public void ruudussaEiAluksiMiinaJaMiinanLisaysOnnistuu() {
        assertEquals(ruutu.getOnkoRuudussaMiina(), false);
        ruutu.setOnkoRuudussaMiina(true);
        assertEquals(ruutu.getOnkoRuudussaMiina(), true);
    }

    @Test
    public void palauttaaRuudunNakyvyydenAluksiFalse() {
        assertEquals(ruutu.getOnkoRuutuAvattu(), false);
    }

    @Test
    public void ruudunNakyvyysVaihdettavissa() {
        ruutu.setOnkoRuutuAvattu(true);
        assertEquals(ruutu.getOnkoRuutuAvattu(), true);
    }

    @Test
    public void ruudunLiputtaminenToimii() {
        ruutu.setOnkoRuutuAvattu(false);
        ruutu.setOnkoRuutuLiputettu(true);
        assertEquals(ruutu.isOnkoRuutuLiputettu(), true);
    }

    @Test
    public void ruudunLiputtaminenEiToimii() {
        ruutu.setOnkoRuutuAvattu(true);
        ruutu.setOnkoRuutuLiputettu(true);
        assertEquals(ruutu.isOnkoRuutuLiputettu(), false);
    }

    @Test
    public void ruudunKoordinaatitToimii() {
        assertEquals(ruutu.getX(), 1);
        assertEquals(ruutu.getY(), 1);
    }

    @Test
    public void ruudussaMiinaTulostuuOikein() {
        ruutu.setOnkoRuudussaMiina(true);
        ruutu.setViereistenMiinojenMaara(3);
    }

    @Test
    public void ruudussaLiikaaViereisiaMiinojaTulostuuOikein() {
        ruutu.setViereistenMiinojenMaara(9);
        assertEquals(ruutu.getViereistenMiinojenMaara(), 0);
    }

    @Test
    public void ruudussaNegatiivinenArvoMiinojenmaaraTulostuuOikein() {
        ruutu.setViereistenMiinojenMaara(-1);
        assertEquals(ruutu.getViereistenMiinojenMaara(), 0);
    }

    @Test
    public void viereistenMiinojenMaaraTulostuuOikein8() {
        ruutu.setViereistenMiinojenMaara(8);
        assertEquals(ruutu.getViereistenMiinojenMaara(), 8);
    }

    @Test
    public void viereistenMiinojenMaaraTulostuuOikein0() {
        ruutu.setViereistenMiinojenMaara(0);
        assertEquals(ruutu.getViereistenMiinojenMaara(), 0);
    }

    @Test
    public void ruudunKokoOikein() {
        assertEquals(ruutu.getRuudunKorkeus(), 24);
        assertEquals(ruutu.getRuudunLeveys(), 24);
    }

    @Test
    public void ruutuKlikattuMiinaEiToimi() {
        assertEquals(ruutu.isKlikattuMiina(), false);
        ruutu.setOnkoRuudussaMiina(false);
        ruutu.setKlikattuMiina(true);
        assertEquals(ruutu.isKlikattuMiina(), false);
    }

    @Test
    public void ruutuKlikattuMiinaToimii() {
        assertEquals(ruutu.isKlikattuMiina(), false);
        ruutu.setOnkoRuudussaMiina(true);
        ruutu.setKlikattuMiina(true);
        assertEquals(ruutu.isKlikattuMiina(), true);
    }

    @Test
    public void ruutuViereistenRuutujenAvaaminenToimii() {
        harava = new Miinaharavainen(8, 8);
        Ruutu ruutu = harava.getPelilauta().getRuutu(1, 1);
        ruutu.setOnkoRuutuAvattu(true);
        harava.getPelilauta().getRuutu(3, 0).setOnkoRuudussaMiina(true);
        harava.getPelilauta().getRuutu(3, 1).setOnkoRuudussaMiina(true);
        harava.getPelilauta().getRuutu(3, 2).setOnkoRuudussaMiina(true);
        harava.getPelilauta().getRuutu(3, 3).setOnkoRuudussaMiina(true);
        harava.getPelilauta().getRuutu(2, 3).setOnkoRuudussaMiina(true);
        harava.getPelilauta().getRuutu(1, 3).setOnkoRuudussaMiina(true);
        harava.getPelilauta().getRuutu(0, 3).setOnkoRuudussaMiina(true);
        ruutu.avaaViereisetRuudut();
        assertEquals(true, harava.getPelilauta().getRuutu(0, 0).getOnkoRuutuAvattu());
        assertEquals(true, harava.getPelilauta().getRuutu(1, 0).getOnkoRuutuAvattu());
        assertEquals(true, harava.getPelilauta().getRuutu(2, 0).getOnkoRuutuAvattu());
        assertEquals(true, harava.getPelilauta().getRuutu(0, 1).getOnkoRuutuAvattu());
        assertEquals(true, harava.getPelilauta().getRuutu(0, 2).getOnkoRuutuAvattu());
        assertEquals(true, harava.getPelilauta().getRuutu(1, 2).getOnkoRuutuAvattu());
        assertEquals(true, harava.getPelilauta().getRuutu(2, 2).getOnkoRuutuAvattu());
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
        ruutu = new Ruutu(1, 1);
    }

    @After
    public void tearDown() {
    }

}
