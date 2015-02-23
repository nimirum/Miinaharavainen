package nimirum.Miinaharavainen.logiikka;

import java.util.Timer;
import java.util.TimerTask;
import nimirum.Miinaharavainen.gui.Piirtaja;

/**
 * Pelin ajanotto
 *
 * @author nimirum
 */
public class Kello implements Runnable {

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
                counter++;
                //piirtaja.repaint();
            }
        };

        //create thread to print counter value
        Thread t = new Thread(new Runnable() {

            @Override
            public void run() {
                while (true) {
                    if (counter == 999) {
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

    private static void sleepForcefully(int milliSecond) {
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
        if (counter < 10) {
            return "00" + counter;
        }
        if (counter < 100) {
            return "0" + counter;
        }
        return "" + counter;
    }

    public void stop() {
        timer.cancel();
    }

}
