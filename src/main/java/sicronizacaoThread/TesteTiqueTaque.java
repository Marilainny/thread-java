package sicronizacaoThread;

public class TesteTiqueTaque {

    public static void main(String[] args) {

        TiqueTaque tiqueTaque = new TiqueTaque();

        ThreadTiqueTaque tique = new ThreadTiqueTaque("Tique", tiqueTaque);
        ThreadTiqueTaque taque = new ThreadTiqueTaque("Taque", tiqueTaque);

        try {
            tique.identificador.join();
            taque.identificador.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


    }

}
