package nimirum.Miinaharavainen.logiikka;

import nimirum.Miinaharavainen.logiikka.Pelilauta;
import nimirum.Miinaharavainen.logiikka.Ruutu;

public class Miinaharavainen {
    private Pelilauta pelilauta;
    private int miinojenMaara=0;

    public Miinaharavainen(int x, int y) {
        if (8 <= x && x <= 50 && 8 <= y && y <= 50) {
            pelilauta = new Pelilauta(x, y);
        }else{
            pelilauta = new Pelilauta(10, 10);
        }       
    }

    public void miinoitaLauta(){
        // ensimmäinen klikkaus eli (x,y) koordinaatti johon ei tule miinaa (MYÖHEMMIN LISÄTTÄVÄ)
        //ajanotto alkaa myös samalla hetkellä       
        miinojenMaara = pelilauta.miinoita();
    }

    public void tulostaLauta(){
        //väliaikainen tulostus
        System.out.println("\nTulostetaan pelilautaa");
        for (int i = 0; i < pelilauta.getX(); i++) {
            for (int j = 0; j < pelilauta.getY(); j++) {
                Ruutu ruutu = pelilauta.getRuutu(i, j);
                System.out.print(ruutu.toString());
            }
            System.out.println();
        }
    }
    
    public int getMiinojenMaara() {
        return miinojenMaara;
    }

    public Pelilauta getPelilauta() {
        return pelilauta;
    }   
}
