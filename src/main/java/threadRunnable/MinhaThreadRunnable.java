package threadRunnable;

public class MinhaThreadRunnable implements Runnable {

    private String nome;
    private int tempo;

    public MinhaThreadRunnable(String nome, int tempo){
        this.nome = nome;
        this.tempo= tempo;
        Thread t = new Thread(this);
        t.start();
    }

    @Override
    public void run() {


            try {
                for(int i = 0; i<6; i++) {
                    System.out.println(nome + "contador " + i);
                    Thread.sleep(1000);
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
        }

        System.out.println(nome+"Teminou a Execução...");

    }
}
