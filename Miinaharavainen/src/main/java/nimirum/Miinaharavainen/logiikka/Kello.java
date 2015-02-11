
package nimirum.Miinaharavainen.logiikka;

/**
 *Pelin ajanotto
 * 
 * @author nimirum
 */
public class Kello {
    
    private int sekunti =0;
    
    public void kasvataKelloa(){
        sekunti++;
    }

    public int getSekunti() {
        return sekunti;
    }
    
    
}
