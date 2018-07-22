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
public class ThreadsSingleProducer {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        SingleElementBuffer buffer = new SingleElementBuffer();
        new Thread(new Producer(1, 1000, buffer)).start();
        new Thread(new Consumer(buffer)).start();
    }
    
}
