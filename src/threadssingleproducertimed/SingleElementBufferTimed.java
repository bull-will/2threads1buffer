/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package threadssingleproducertimed;

import java.util.concurrent.TimeoutException;

/**
 *
 * @author Admin
 */
class SingleElementBufferTimed {

    private Integer elem = null;

    public synchronized void put(Integer newElem, long timeOut) throws InterruptedException, TimeoutException {
        long waitTime = timeOut;
        while (elem != null && waitTime > 0) {
            long t0 = System.currentTimeMillis();
            wait(waitTime);
            long t1 = System.currentTimeMillis();
            long elapsedTime = t1 - t0;
            waitTime -= elapsedTime;
        }
        if (waitTime <= 0) {
            throw new TimeoutException("Still no work for producer. Good bye!");
        }
        this.elem = newElem;
        this.notifyAll();
    }

    public synchronized Integer get(long timeOut) throws InterruptedException, TimeoutException {
        long waitTime = timeOut;
        while (elem == null && waitTime > 0) {
            long t0 = System.currentTimeMillis();
            wait(waitTime);
            long t1 = System.currentTimeMillis();
            long elapsedTime = t1 - t0;
            waitTime -= elapsedTime;
        }
        if (waitTime <= 0) {
            throw new TimeoutException("Still no work for consumer. Good bye!");
        }
        int result = this.elem;
        this.elem = null;
        this.notifyAll();
        return result;
    }
}
