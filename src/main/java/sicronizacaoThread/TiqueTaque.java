package sicronizacaoThread;

public class TiqueTaque {

    boolean tique;

    synchronized void tique(boolean estaExecutando) {

        if (!estaExecutando) {
            tique = true;
            notify();
            return;
        }

        System.out.print("Tique ");

        tique = true;
        notify();

        try {
            while (tique) {
                wait();
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

    synchronized void taque(boolean estaExecutando) {

        if (!estaExecutando) {
            tique = false;
            notify();
            return;
        }

        System.out.println("Taque ");

        tique = false;
        notify();

        try {
            while (!tique) {
                wait();
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

}

