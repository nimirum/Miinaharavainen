package nimirum.Miinaharavainen.logiikka;

/**
 * Miinharava peli luokka, joka luo pelilaudan
 * @author nimirum
 */
public final class Miinaharavainen {
    private Pelilauta pelilauta;
    private int miinojenMaara=0;

    /**
     *Miinaharavan konstruktori, missä luodaan pelilauta annetuista arvoista
     * 
     * @param leveys Pelilaudan leveys
     * @param korkeus Pelilaudan korkeus
     */
    public Miinaharavainen(int leveys, int korkeus) {
        setPelilaudanKoko(leveys, korkeus);
    }
    
    /**
     * Pelilaudan koko pitää olla väliltä 8-50 korkeus- ja leveyssuunnassa.
     * Jos koko on väärä, niin luodaan automaattisesti 10*10 pelilauta.
     *
     * @param x Pelilaudan leveys
     * @param y Pelilaudan korkeus
     */
    public void setPelilaudanKoko(int x, int y){
         if (8 <= x && x <= 50 && 8 <= y && y <= 50) {
            pelilauta = new Pelilauta(x, y);
        }else{
            pelilauta = new Pelilauta(10, 10);
        }  
    }
            
    /**
     * Miinoittaa pelilaudan random lukujen avulla ensimmäisen klikkauksen jälkeen.
     * Asetttaa miinojen määrän muistiin, jota tarvitsee pelin voittamiseen. 
     * Ajanoton pitäisi alkaa tämän metodin käynnistämisen jälkeen
     *
     */
    public void miinoitaLauta(){
        pelilauta.miinoita();
        miinojenMaara = pelilauta.getMiinojenMaara();
    }

    /**
     * Väliaikainen tulostusmetodi pelilaudan testausta varten.
     *
     */
    public void tulostaLauta(){
        for (int i = 0; i < pelilauta.getX(); i++) {
            for (int j = 0; j < pelilauta.getY(); j++) {
                Ruutu ruutu = pelilauta.getRuutu(i, j);
                System.out.print(ruutu.toString());
            }
            System.out.println();
        }
    }
    
    /**
     *
     * @return Pelilaudan miinojen määrä
     */
    public int getMiinojenMaara() {
        return miinojenMaara;
    }

    /**
     *
     * @return Pelilauta
     */
    public Pelilauta getPelilauta() {
        return pelilauta;
    }   
    
    public void gameOver(){
        
    }
}
