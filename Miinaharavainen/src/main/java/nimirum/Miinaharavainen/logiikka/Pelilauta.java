package nimirum.Miinaharavainen.logiikka;

import java.util.ArrayList;
import java.util.Random;

/**
 * Muodostaa Pelilaudan, joka muodostuu ruuduista(x,y), miinoittaa ja laskee
 * numero arvot.
 *
 * @author nimirum
 */
public class Pelilauta {

    private final int x;
    private final int y;
    private int miinojenMaara;
    private final Ruutu pelilauta[][];
    private int klikatutRuudut = 0;

    /**
     * Muodostaa pelilaudan johon kuuluu x*y määrä ruutuja
     *
     * @param x Pelilaudan leveys
     * @param y Pelilaudan korkeus
     */
    public Pelilauta(int x, int y) {
        this.x = x;
        this.y = y;
        pelilauta = new Ruutu[this.x][this.y];

        for (int i = 0; i < this.x; i++) {
            for (int j = 0; j < this.y; j++) {
                pelilauta[i][j] = new Ruutu(i, j, this);
            }
        }
        viereisetRuudut();
    }

    /**
     *
     * @param x leveys koordinaatti
     * @param y korkeus koordinaatti
     * @return Ruutu
     */
    public Ruutu getRuutu(int x, int y) {
        if (0 <= x && x < this.x && 0 <= y && y < this.y) {
            return pelilauta[x][y];
        }
        return null;
    }

    /**
     *
     * @return Pelilauta kaksiulotteisena taulukkona
     */
    public Ruutu[][] getPelilauta() {
        return pelilauta;
    }

    /**
     *
     * @return Pelilaudan leveys
     */
    public int getX() {
        return x;
    }

    /**
     *
     * @return Pelilaudan korkeus
     */
    public int getY() {
        return y;
    }

    /**
     * Asettaa pelilaudan ruudulle(x,y) miinan
     *
     * @param x leveys koordinaatti
     * @param y korkeus koordinaatti
     */
    public void setMiina(int x, int y) {
        Ruutu ruutu = getRuutu(x, y);
        ruutu.setOnkoMiina(true);
    }

    /**
     * Lisää randomisti miinat ja lopuksi laskeNumerot()
     *
     * @param x
     * @param y
     */
    public void miinoita(int x, int y) {
        miinojenMaara = miinojenMaaraLaskuri();
        Ruutu ekaKlikkaus = getRuutu(x, y);

        Random random = new Random();
        int min = 0;
        int maxX = this.x - 1;
        int maxY = this.y - 1;

        for (int i = 0; i < miinojenMaara; i++) {
            int randomNumX = random.nextInt((maxX - min) + 1) + min;
            int randomNumY = random.nextInt((maxY - min) + 1) + min;
            Ruutu ruutu = getRuutu(randomNumX, randomNumY);
            if (!ruutu.getOnkoMiina() && ruutu.getX() != ekaKlikkaus.getX() && ruutu.getY() != ekaKlikkaus.getY() && viereisetRuudutEiMiinoitetaTarkitus(ruutu.getX(), ruutu.getY(), ekaKlikkaus)) {
                ruutu.setOnkoMiina(true);
            } else {
                //jos ehdot ei toteudu, arpominen toistetaan uudestaan
                i--;
            }
        }
        laskeNumerot();
    }

    private boolean viereisetRuudutEiMiinoitetaTarkitus(int x, int y, Ruutu ruutu) {
        for (Ruutu ruutuinen : ruutu.getViereisetRuudut()) {
            if (ruutuinen.getX() == x && ruutuinen.getY() == y) {
                return false;
            }
        }
        return true;
    }

    /**
     * Laskee numero arvot miinojen viereen, eli kuinka moneen miinaan kyseinen
     * ruutu koskee
     */
    public void laskeNumerot() {
        for (int i = 0; i < this.x; i++) {
            for (int j = 0; j < this.y; j++) {
                Ruutu ruutu = getRuutu(i, j);
                ruutu.laskeNumerot();
            }
        }
    }

    private int miinojenMaaraLaskuri() {
        return 1;
       //return (int) (0.15 * this.x * this.y);
    }

    /**
     *
     * @return Miinojen määrä
     */
    public int getMiinojenMaara() {
        return miinojenMaara;
    }

    private void viereisetRuudut() {
        ArrayList<Ruutu> viereiset = new ArrayList<>();
        for (int i = 0; i < this.x; i++) {
            for (int j = 0; j < this.y; j++) {
                Ruutu ruutu = getRuutu(i, j);
                if (getRuutu(i + 1, j) != null) {
                    viereiset.add(getRuutu(i + 1, j));
                }
                if (getRuutu(i + 1, j + 1) != null) {
                    viereiset.add(getRuutu(i + 1, j + 1));
                }
                if (getRuutu(i, j + 1) != null) {
                    viereiset.add(getRuutu(i, j + 1));
                }
                if (getRuutu(i, j - 1) != null) {
                    viereiset.add(getRuutu(i, j - 1));
                }
                if (getRuutu(i + 1, j - 1) != null) {
                    viereiset.add(getRuutu(i + 1, j - 1));
                }
                if (getRuutu(i - 1, j) != null) {
                    viereiset.add(getRuutu(i - 1, j));
                }
                if (getRuutu(i - 1, j + 1) != null) {
                    viereiset.add(getRuutu(i - 1, j + 1));
                }
                if (getRuutu(i - 1, j - 1) != null) {
                    viereiset.add(getRuutu(i - 1, j - 1));
                }
                ruutu.setViereisetRuudut(viereiset);
                viereiset = new ArrayList<>();
            }
        }
    }

    /**
     * Avaa kaikki ruudut, eli vaihtaa ne näkyviksi
     */
    public void avaaKaikkiRuudut() {
        for (int i = 0; i < this.x; i++) {
            for (int j = 0; j < this.y; j++) {
                Ruutu ruutu = getRuutu(i, j);
                ruutu.setOnkoRuutuNakyva(true);
            }
        }
    }
    
    public void paivitaKlikatutRuudut(){
        this.klikatutRuudut = 0;
        for (int i = 0; i < this.x; i++) {
            for (int j = 0; j < this.y; j++) {

                Ruutu ruutu = getRuutu(i, j);
                if (ruutu.getOnkoRuutuNakyva()) {
                    klikatutRuudut++;
                }
            }
        }
    }

    public boolean onkoPeliPaattynyt() {
        return (klikatutRuudut == (this.x * this.y - miinojenMaara));
    }
}
