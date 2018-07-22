/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package threadssingleproducer;

/**
 *
 * @author Admin
 */
class SingleElementBuffer {
    private Integer elem = null;
    
    public synchronized void put (Integer newElem) throws InterruptedException {
        while (elem != null) {
            this.wait();
        }
        this.elem = newElem;
        this.notifyAll();
    }
    
    public synchronized Integer get () throws InterruptedException {
        while (elem == null) {
            this.wait();
        }
        int result = this.elem;
        this.elem = null;
        this.notifyAll();
        return result;
    }
}
