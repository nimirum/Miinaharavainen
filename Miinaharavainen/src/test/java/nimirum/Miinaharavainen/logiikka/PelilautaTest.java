package nimirum.Miinaharavainen.logiikka;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class PelilautaTest {

    Miinaharavainen miinaharava = new Miinaharavainen(10, 10);

    public PelilautaTest() {
    }

    @Test
    public void miinanAsetusToimii() {
        Pelilauta lauta = miinaharava.getPelilauta();
        lauta.setMiina(0, 0);
        assertEquals(lauta.getRuutu(0, 0).getOnkoRuudussaMiina(), true);
    }

    @Test
    public void palauttaaOikeanKokoisenPelilaudan() {
        Pelilauta lauta = miinaharava.getPelilauta();
        assertEquals(10, lauta.getX());
        assertEquals(10, lauta.getY());
    }

    @Test
    public void miinaVasenYlanurkkaLaskuriToimii() {
        Pelilauta lauta = miinaharava.getPelilauta();
        lauta.setMiina(0, 0);
        lauta.laskeNumerot();
        assertEquals(lauta.getRuutu(0, 1).getViereistenMiinojenMaara(), 1);
        assertEquals(lauta.getRuutu(1, 1).getViereistenMiinojenMaara(), 1);
        assertEquals(lauta.getRuutu(1, 0).getViereistenMiinojenMaara(), 1);
    }

    @Test
    public void miinaYlareunaLaskuriToimii() {
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
        Pelilauta lauta = miinaharava.getPelilauta();
        lauta.setMiina(0, 9);
        lauta.laskeNumerot();
        assertEquals(lauta.getRuutu(0, 8).getViereistenMiinojenMaara(), 1);
        assertEquals(lauta.getRuutu(1, 8).getViereistenMiinojenMaara(), 1);
        assertEquals(lauta.getRuutu(1, 9).getViereistenMiinojenMaara(), 1);
    }

    @Test
    public void miinaOikeaReunaLaskuriToimii() {
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
        Pelilauta lauta = miinaharava.getPelilauta();
        lauta.setMiina(9, 0);
        lauta.laskeNumerot();
        assertEquals(lauta.getRuutu(8, 0).getViereistenMiinojenMaara(), 1);
        assertEquals(lauta.getRuutu(8, 1).getViereistenMiinojenMaara(), 1);
        assertEquals(lauta.getRuutu(9, 1).getViereistenMiinojenMaara(), 1);
    }

    @Test
    public void miinaVasenReunaLaskuriToimii() {
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
        Pelilauta lauta = miinaharava.getPelilauta();
        lauta.setMiina(4, 5);
        lauta.setMiina(6, 5);
        lauta.laskeNumerot();
        assertEquals(lauta.getRuutu(5, 5).getViereistenMiinojenMaara(), 2);
    }

    @Test
    public void miinaKeskellaLaskuriToimii() {
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
        Pelilauta lauta = miinaharava.getPelilauta();
        lauta.setMiina(9, 9);
        lauta.laskeNumerot();
        assertEquals(lauta.getRuutu(8, 8).getViereistenMiinojenMaara(), 1);
        assertEquals(lauta.getRuutu(8, 9).getViereistenMiinojenMaara(), 1);
        assertEquals(lauta.getRuutu(9, 8).getViereistenMiinojenMaara(), 1);
    }

    @Test
    public void viereisiaRuutujaEiMiinoiteta() {
        Miinaharavainen harava = new Miinaharavainen(8, 8);
        harava.miinoitaLauta(1, 1);
        assertEquals(false, harava.getPelilauta().getRuutu(0, 0).getOnkoRuudussaMiina());
        assertEquals(false, harava.getPelilauta().getRuutu(1, 0).getOnkoRuudussaMiina());
        assertEquals(false, harava.getPelilauta().getRuutu(2, 0).getOnkoRuudussaMiina());
        assertEquals(false, harava.getPelilauta().getRuutu(0, 1).getOnkoRuudussaMiina());
        assertEquals(false, harava.getPelilauta().getRuutu(0, 2).getOnkoRuudussaMiina());
        assertEquals(false, harava.getPelilauta().getRuutu(1, 2).getOnkoRuudussaMiina());
        assertEquals(false, harava.getPelilauta().getRuutu(2, 2).getOnkoRuudussaMiina());
    }
    
    @Test
    public void klikattujenRuutujenMaaraOikein(){
        Pelilauta lauta = miinaharava.getPelilauta();
        miinaharava.miinoitaLauta(1, 1);
        assertEquals(0, lauta.getKlikatutRuudut());
        lauta.avaaKaikkiRuudut();
        lauta.paivitaKlikatutRuudut();
        assertEquals(100, lauta.getKlikatutRuudut());
    }
       @Test
    public void tulostusToimii(){
        Pelilauta lauta = miinaharava.getPelilauta();
        assertEquals("10x10", lauta.toString());
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
