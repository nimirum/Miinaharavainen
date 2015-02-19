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

    private int x;
    private int y;
    private int miinojenMaara;
    private Ruutu pelilauta[][];

    /**
     * Muodostaa pelilaudan johon kuuluu x*y määrä ruutuja
     *
     * @param x pelilaudan leveys
     * @param y pelilaudan korkeus
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
     * @return Pelilauta
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
        //testausta varten
        Ruutu ruutu = getRuutu(x, y);
        ruutu.setOnkoMiina(true);
    }

    /**
     * Lisää randomisti miinat ja lopuksi laskeNumerot()
     *
     */
    public void miinoita() {
        miinojenMaara = miinojenMaaraLaskuri();

        Random rand = new Random();
        int min = 0;
        int maxX = this.x - 1;
        int maxY = this.y - 1;

        for (int i = 0; i < miinojenMaara; i++) {
            int randomNumX = rand.nextInt((maxX - min) + 1) + min;
            int randomNumY = rand.nextInt((maxY - min) + 1) + min;
            Ruutu ruutu = getRuutu(randomNumX, randomNumY);
            if (!ruutu.getOnkoMiina()) {
                ruutu.setOnkoMiina(true);
            } else {
                //jos ruudussa jo miina, arvontojen mÃƒÂ¤ÃƒÂ¤rÃƒÂ¤ÃƒÂ¤ lisÃƒÂ¤tÃƒÂ¤ÃƒÂ¤n yhdellÃƒÂ¤
                i--;
            }
        }
        laskeNumerot();
    }

    public void laskeNumerot() {
        for (int i = 0; i < this.x; i++) {
            for (int j = 0; j < this.y; j++) {
                Ruutu ruutu = getRuutu(i, j);
                ruutu.laskeNumerot();
            }
        }
    }

    private int miinojenMaaraLaskuri() {
        return (int) (0.15 * this.x * this.y);
    }

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
}
