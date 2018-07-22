/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package threadssingleproducertimed;

import java.util.concurrent.TimeoutException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Admin
 */
public class ProducerTimed implements Runnable {

    private int startValue;
    private final int period;
    private final SingleElementBufferTimed buffer;
    private final long timeOut;

    public ProducerTimed(int startValue, int period, SingleElementBufferTimed buffer, long timeOut) {
        this.buffer = buffer;
        this.period = period;
        this.startValue = startValue;
        this.timeOut = timeOut;
    }

    @Override
    public void run() {
//        for (int i = 0; i < 15; i++) {
        while (true) {
            System.out.println(startValue + " produced");
            try {
                buffer.put(startValue++, timeOut);
                Thread.sleep(period);
            } catch (InterruptedException ex) {
                Logger.getLogger(ProducerTimed.class.getName()).log(Level.SEVERE, null, ex);
            } catch (TimeoutException ex) {
                Logger.getLogger(ProducerTimed.class.getName()).log(Level.SEVERE, null, ex);
                return;
            }
        }
    }

}
