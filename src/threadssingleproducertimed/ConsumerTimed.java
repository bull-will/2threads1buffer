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
public class ConsumerTimed implements Runnable {

    private final SingleElementBufferTimed buffer;
    private final long timeOut;

    public ConsumerTimed(SingleElementBufferTimed buffer, long timeOut) {
        this.buffer = buffer;
        this.timeOut = timeOut;
    }

    @Override
    public void run() {

        try {
            while (true) {
                int elem = buffer.get(timeOut);
                System.out.println(elem + " consumed");
//                Thread.sleep(3000); // this makes the consumer lag and crashes the system
            }
        } catch (InterruptedException ex) {
            Logger.getLogger(ConsumerTimed.class.getName()).log(Level.SEVERE, null, ex);
        } catch (TimeoutException ex) {
            Logger.getLogger(ConsumerTimed.class.getName()).log(Level.SEVERE, null, ex);
            return;
        }
    }

}
