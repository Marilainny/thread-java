package deadlock;

import javax.sound.midi.Soundbank;

public class Deadlock {

    public static void main(String[] args) {

        final String RECURSO1 = "Recurso #1";
        final String RECURSO2 = "Recurso #2";

        Thread thread = new Thread(){
            public void run(){
                synchronized (RECURSO1){
                    System.out.println("Thread #1 bloqueou recurso 1");
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    System.out.println("Thread #1: tentando acessar o recurso 2");

                    synchronized (RECURSO2){
                        System.out.println("Thread #1 bloqueou recurso 2");
                    }
                }
            }

        };

        Thread thread1 = new Thread(){
            public void run(){
                synchronized (RECURSO2){
                    System.out.println("Thread #2 bloqueou recurso 1");
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    System.out.println("Thread #2: tentando acessar o recurso 1");

                    synchronized (RECURSO1){
                        System.out.println("Thread #2 bloqueou recurso 1");
                    }
                }
            }
        };

        thread.start();
        thread1.start();

    }
}
