package nimirum.Miinaharavainen.logiikka;

import java.util.Timer;
import java.util.TimerTask;
import nimirum.Miinaharavainen.gui.Piirtaja;

/**
 * Pelin ajanotto
 *
 * @author nimirum
 */
public class Kello implements Runnable{

    static int counter = 0;
    static Timer timer;
    Piirtaja piirtaja;
    Miinaharavainen harava;

    @Override
    public void run() {
        //create timer task to increment counter
        TimerTask timerTask = new TimerTask() {

            @Override
            public void run() {
                 System.out.println("TimerTask executing counter is: " + counter);
                counter++;
                //piirtaja.repaint();
            }
        };

        //create thread to print counter value
        Thread t = new Thread(new Runnable() {

            @Override
            public void run() {
                while (true) {
                    System.out.println("Thread reading counter is: " + counter);
                    if (counter == 25) {
                        //  System.out.println("Counter has reached 13 now will terminate");
                        timer.cancel();//end the timer
                        break;//end this loop
                    }
                    sleepForcefully(1000);
                }
            }
        });

        timer = new Timer("MyTimer");//create a new timer

        timer.scheduleAtFixedRate(timerTask, 0, 1000);

        t.start();//start thread to display counter

    }

    public void setParametrit(Piirtaja piirtaja, Miinaharavainen harava) {
        this.piirtaja = piirtaja;
        this.harava = harava;
    }

    public static void sleepForcefully(int milliSecond) {
        final long endingTime = System.currentTimeMillis() + milliSecond;
        long remainingTime = milliSecond;
        while (remainingTime > 0) {
            try {
                Thread.sleep(remainingTime);
            } catch (InterruptedException ignore) {
            }
            remainingTime = endingTime - System.currentTimeMillis();
        }
    }

    @Override
    public String toString() {
        return "" + counter;
    }

}
