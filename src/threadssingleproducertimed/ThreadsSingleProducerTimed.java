/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package threadssingleproducertimed;

/**
 *
 * @author Admin
 */
public class ThreadsSingleProducerTimed {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        SingleElementBufferTimed buffer = new SingleElementBufferTimed();
        new Thread(new ProducerTimed(1, 1000, buffer, 2000)).start();
        new Thread(new ConsumerTimed(buffer, 2000)).start();
    }
    
}
