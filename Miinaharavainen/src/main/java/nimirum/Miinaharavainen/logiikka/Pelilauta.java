package nimirum.Miinaharavainen.logiikka;

import java.util.Random;

/**
 * Muodostaa Pelilaudan, joka muodostuu ruuduista(x,y), miinoittaa ja laskee numero arvot.
 * @author nimirum
 */
public class Pelilauta {

    //muodostuu ruuduista, ruutujen alla on sisÃƒÂ¤ltÃƒÂ¶ÃƒÂ¤, miina, tyhjÃƒÂ¤ tai numero
    //Ruutuja x*y kappaletta
    private int x;
    private int y;

    Ruutu pelilauta[][];

    /**
     *
     * @param x
     * @param y
     */
    public Pelilauta(int x, int y) {
        this.x = x;
        this.y = y;
        pelilauta = new Ruutu[this.x][this.y];

        for (int i = 0; i < this.x; i++) {
            for (int j = 0; j < this.y; j++) {
                pelilauta[i][j] = new Ruutu(i, j);
            }
        }
        //  System.out.println("Pelilaudan luominen onnistui");
    }

    /**
     *
     * @param x
     * @param y
     * @return Pelilauta
     */
    public Ruutu getRuutu(int x, int y) {
        return pelilauta[x][y];
    }

    public Ruutu[][] getPelilauta() {
        return pelilauta;
    }

    
    /**
     *
     * @return
     */
    public int getX() {
        return x;
    }

    /**
     *
     * @return
     */
    public int getY() {
        return y;
    }

    /**
     *
     * @param x
     * @param y
     */
    public void setMiina(int x, int y) {
        //testausta varten
        Ruutu ruutu = pelilauta[x][y];
        ruutu.setOnkoMiina(true);
    }

    /**
     *Lisää randomisti miinat  ja laskeNumerot()
     * 
     * @return
     */
    public int miinoita() {
        int miinojenMaara = (int) (0.15 * this.x * this.y);

        Random rand = new Random();
        int min = 0;
        int maxX = this.x - 1;
        int maxY = this.y - 1;

        for (int i = 0; i < miinojenMaara; i++) {
            int randomNumX = rand.nextInt((maxX - min) + 1) + min;
            int randomNumY = rand.nextInt((maxY - min) + 1) + min;
            Ruutu ruutu = pelilauta[randomNumX][randomNumY];
            if (!ruutu.getOnkoMiina()) {
                ruutu.setOnkoMiina(true);
            } else {
                //jos ruudussa jo miina, arvontojen mÃƒÂ¤ÃƒÂ¤rÃƒÂ¤ÃƒÂ¤ lisÃƒÂ¤tÃƒÂ¤ÃƒÂ¤n yhdellÃƒÂ¤
                i--;
            }
        }
        laskeNumerot();
        return miinojenMaara;
    }

    /**
     *Käy koko pelilaudan läpi ja numeroi viereisiin ruutuihin viereisten miinojen määrät
     */
    public void laskeNumerot() {
        for (int i = 0; i < this.x; i++) {
            for (int j = 0; j < this.y; j++) {
                if (pelilauta[i][j].getOnkoMiina()) {

                    if (i == 0 && j == 0) {
                        vasenYlanurkka(i, j);
                        continue;
                    }
                    if (i == 0 && 0 < j && j < this.y - 1) {
                        ylareuna(i, j);
                        continue;
                    }
                    if (i == 0 && j == this.y - 1) {
                        oikeaYlanurkka(i, j);
                        continue;
                    }
                    if (0 < i && i < this.x - 1 && j == 0) {
                        vasenReuna(i, j);
                        continue;
                    }
                    if (0 < i && i < this.x - 1 && 0 < j && j < this.y - 1) {
                        keskialue(i, j);
                        continue;
                    }
                    if (0 < i && i < this.x - 1 && j == this.y - 1) {
                        oikeaReuna(i, j);
                        continue;
                    }
                    if (i == this.x - 1 && 0 < j && j < this.y - 1) {
                        alareuna(i, j);
                        continue;
                    }
                    if (i == this.x - 1 && j == this.y - 1) {
                        oikeaAlanurkka(i, j);
                        continue;
                    }
                    if (i == this.x - 1 && j == 0) {
                        vasenAlanurkka(i, j);
                    }
                }
            }
        }
    }

    private void alas(int i, int j) {
        pelilauta[i + 1][j].addViereistenMiinojenMaaraa();
    }

    private void oikeaAlas(int i, int j) {
        pelilauta[i + 1][j + 1].addViereistenMiinojenMaaraa();
    }

    private void oikea(int i, int j) {
        pelilauta[i][j + 1].addViereistenMiinojenMaaraa();
    }

    private void vasen(int i, int j) {
        pelilauta[i][j - 1].addViereistenMiinojenMaaraa();
    }

    private void vasenAlas(int i, int j) {
        pelilauta[i + 1][j - 1].addViereistenMiinojenMaaraa();
    }

    private void ylos(int i, int j) {
        pelilauta[i - 1][j].addViereistenMiinojenMaaraa();
    }

    private void oikeaYlos(int i, int j) {
        pelilauta[i - 1][j + 1].addViereistenMiinojenMaaraa();
    }

    private void vasenYlos(int i, int j) {
        pelilauta[i - 1][j - 1].addViereistenMiinojenMaaraa();
    }

    private void vasenYlanurkka(int i, int j) {
        alas(i, j);
        oikeaAlas(i, j);
        oikea(i, j);
    }

    private void ylareuna(int i, int j) {
        vasen(i, j);
        vasenAlas(i, j);
        alas(i, j);
        oikeaAlas(i, j);
        oikea(i, j);
    }

    private void oikeaYlanurkka(int i, int j) {
        vasen(i, j);
        vasenAlas(i, j);
        alas(i, j);
    }

    private void vasenReuna(int i, int j) {
        ylos(i, j);
        oikeaYlos(i, j);
        oikea(i, j);
        oikeaAlas(i, j);
        alas(i, j);
    }

    private void keskialue(int i, int j) {
        oikeaYlos(i, j);
        ylos(i, j);
        vasenYlos(i, j);
        vasen(i, j);
        vasenAlas(i, j);
        alas(i, j);
        oikeaAlas(i, j);
        oikea(i, j);
    }

    private void oikeaReuna(int i, int j) {
        ylos(i, j);
        vasenYlos(i, j);
        vasen(i, j);
        vasenAlas(i, j);
        alas(i, j);
    }

    private void alareuna(int i, int j) {
        oikeaYlos(i, j);
        ylos(i, j);
        vasenYlos(i, j);
        vasen(i, j);
        oikea(i, j);
    }

    private void oikeaAlanurkka(int i, int j) {
        ylos(i, j);
        vasenYlos(i, j);
        vasen(i, j);
    }

    private void vasenAlanurkka(int i, int j) {
        oikeaYlos(i, j);
        ylos(i, j);
        oikea(i, j);
    }

}
