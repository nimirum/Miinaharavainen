package nimirum.Miinaharavainen.logiikka;

import java.util.Random;

public class Pelilauta {

    //muodostuu ruuduista, ruutujen alla on sisältöä, miina, tyhjä tai numero
    //Ruutuja x*y kappaletta
    private int x;
    private int y;

    Ruutu pelilauta[][];

    public Pelilauta(int x, int y) {
        this.x = x;
        this.y = y;
        pelilauta = new Ruutu[this.x][this.y];

        for (int i = 0; i < this.x; i++) {
            for (int j = 0; j < this.y; j++) {
                pelilauta[i][j] = new Ruutu(i, j);
            }
        }
        System.out.println("Pelilaudan luominen onnistui");
    }

    public Ruutu getRuutu(int x, int y) {
        return pelilauta[x][y];
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setMiina(int x, int y) {
        //testausta varten
        Ruutu ruutu = pelilauta[x][y];
        ruutu.setOnkoMiina(true);
    }

    public int miinoita() {
        //lisää randomisti miinat ja laske numeroarvot
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
                //jos ruudussa jo miina, arvontojen määrää lisätään yhdellä
                i--;
            }
        }
        laskeNumerot();
        System.out.println("\nMiinoittaminen onnistui");
        return miinojenMaara;
    }

    public void laskeNumerot() {
        for (int i = 0; i < this.x; i++) {
            for (int j = 0; j < this.y; j++) {
                if (pelilauta[i][j].getOnkoMiina()) {
                    if (i == 0 && j == 0) {
                        //vasen ylänurkka
                        alas(i, j);
                        oikeaAlas(i, j);
                        oikea(i, j);
                        continue;
                    }
                    if (i == 0 && 0 < j && j < this.y - 1) {
                        //yläreuna
                        vasen(i, j);
                        vasenAlas(i, j);
                        alas(i, j);
                        oikeaAlas(i, j);
                        oikea(i, j);
                        continue;
                    }
                    if (i == 0 && j == this.y - 1) {
                        //oikea ylänurkka
                        vasen(i, j);
                        vasenAlas(i, j);
                        alas(i, j);
                        continue;
                    }
                    if (0 < i && i < this.x - 1 && j == 0) {
                        //vasen renua
                        ylos(i, j);
                        oikeaYlos(i, j);
                        oikea(i, j);
                        oikeaAlas(i, j);
                        alas(i, j);
                        continue;
                    }
                    if (0 < i && i < this.x - 1 && 0 < j && j < this.y - 1) {
                        //keskialueet, ei koske reunoihin
                        oikeaYlos(i, j);
                        ylos(i, j);
                        vasenYlos(i, j);
                        vasen(i, j);
                        vasenAlas(i, j);
                        alas(i, j);
                        oikeaAlas(i, j);
                        oikea(i, j);
                        continue;
                    }
                    if (0 < i && i < this.x - 1 && j == this.y - 1) {
                        //oikea reuna
                        ylos(i, j);
                        vasenYlos(i, j);
                        vasen(i, j);
                        vasenAlas(i, j);
                        alas(i, j);
                        continue;
                    }
                    if (i == this.x - 1 && 0 < j && j < this.y - 1) {
                        //alareuna
                        oikeaYlos(i, j);
                        ylos(i, j);
                        vasenYlos(i, j);
                        vasen(i, j);
                        oikea(i, j);
                        continue;
                    }
                    if (i == this.x - 1 && j == this.y - 1) {
                        // oikea alanurkka                       
                        ylos(i, j);
                        vasenYlos(i, j);
                        vasen(i, j);
                        continue;
                    }
                    if (i == this.x - 1 && j == 0) {
                        //vasen alanurkka
                        oikeaYlos(i, j);
                        ylos(i, j);
                        oikea(i, j);
                        continue;
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

}
