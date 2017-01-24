package practice.coding.threads;

/**
 * Created by rnuka on 10/18/15.
 */
class A extends Thread{

    /*A(){

        this.setDaemon(true);

    }*/

    public void run(){

        new B().start();

    }

}
