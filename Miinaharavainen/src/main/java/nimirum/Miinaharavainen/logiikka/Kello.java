package nimirum.Miinaharavainen.logiikka;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Pelin ajanotto
 *
 * @author nimirum
 */
public class Kello implements Runnable {

    private int laskuri = 0;
    private Timer timer;

    @Override
    public void run() {
        //Timer task joka kasvattaa laskuria
        TimerTask timerTask = new TimerTask() {

            @Override
            public void run() {
                laskuri++;
            }
        };

        //Thread joka päivittää kelloa
        Thread t = new Thread(new Runnable() {

            @Override
            public void run() {
                while (true) {
                    if (laskuri == 999) {
                        timer.cancel();//timer pysähtyy
                        break;//looppi loppuu
                    }
                    sleepForcefully(1000);
                }
            }
        });

        timer = new Timer("MyTimer");//Ajastin

        timer.scheduleAtFixedRate(timerTask, 0, 1000);

        t.start();//Käynnistää kellon

    }

    private static void sleepForcefully(int milliSecond) {
        //Pakottaa kellon päivittymään tasan sekunnin välein
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
        if (laskuri < 10) {
            return "00" + laskuri;
        }
        if (laskuri < 100) {
            return "0" + laskuri;
        }
        return "" + laskuri;
    }

    public void stop() {
        timer.cancel();
    }

}
