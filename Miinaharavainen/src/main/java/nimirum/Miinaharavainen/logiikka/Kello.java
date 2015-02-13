
package nimirum.Miinaharavainen.logiikka;

/**
 *Pelin ajanotto
 * 
 * @author nimirum
 */
public class Kello {
    
    private int sekunti =0;
    
    /**
     *Kasvattaa kellon sekunti arvoa yhdellä
     */
    public void kasvataKelloa(){
        sekunti++;
    }

    /**
     * @return Palauttaa kellonajan
     */
    public int getSekunti() {
        return sekunti;
    }
    
    
}
