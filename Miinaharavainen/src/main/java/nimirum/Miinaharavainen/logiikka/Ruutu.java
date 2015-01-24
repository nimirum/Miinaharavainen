package nimirum.Miinaharavainen.logiikka;

public class Ruutu {

    private boolean onkoMiina = false;
    private int viereistenMiinojenMaara; //8 lähintä ruutua
    private int x;//ruudun koko x*y
    private int y;

    //Ruutu voi olla miina, tyhjä tai
    //numero, joka kertoo vieressä olevien miinojen määrän
    public Ruutu() {
    }

    public Ruutu(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void setOnkoMiina(boolean onkoMiina) {
        this.onkoMiina = onkoMiina;
    }

    public boolean getOnkoMiina() {
        return onkoMiina;
    }

    public void setViereistenMiinojenMaara(int viereistenMiinojenMaara) {
        //arvot väliltä 0-8
        if (0 <= viereistenMiinojenMaara && viereistenMiinojenMaara <= 8) {
            this.viereistenMiinojenMaara = viereistenMiinojenMaara;
        }
    }

    public void addViereistenMiinojenMaaraa() {
        viereistenMiinojenMaara++;
    }

    public int getViereistenMiinojenMaara() {
        return viereistenMiinojenMaara;
    }

    @Override
    public String toString() {
        if (onkoMiina) {
            return " x";
        } //Jos on miina niin miinojenmäärä ei tulostu
        if (viereistenMiinojenMaara > 0) {
            return " " + viereistenMiinojenMaara;
        } //Tyhja ruutu
        else {
            return " .";
        }
    }

}
