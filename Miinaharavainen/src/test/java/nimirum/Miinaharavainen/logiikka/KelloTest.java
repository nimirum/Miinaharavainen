
package nimirum.Miinaharavainen.logiikka;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author nimirum
 */
public class KelloTest {
    
    public KelloTest() {
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

    @Test
    public void KellonAloitusarvoNolla(){
        Kello kello = new Kello();
        assertEquals(0, kello.getSekunti());
    }
    @Test
    public void KellonaikaKasvaa(){
        Kello kello = new Kello();
        kello.kasvataKelloa();
        assertEquals(1, kello.getSekunti());
    }
}
