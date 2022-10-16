package threadExtends;

/**
 * Ciclo de vida da Thread
 * new Thread() - criação da instânica
 * start() - Runnable pronta para execução
 * sleep() - notify() - notifyAll() - resume() - sleep() - wait() - suspend()
 * yield()
 *
 */
public class MinhaThread extends Thread{

    private String nome;
    private int tempo;

    public MinhaThread(String nome, int tempo){
        this.nome = nome;
        start();
    }

    /**
     * Sobreescrever o método run
     */
    public void run(){

            try {
                for(int i=0; i< 6; i++) {
                    System.out.println(nome + "contador" + i);
                    Thread.sleep(tempo);
                }

        } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        System.out.println("Thread terminou a execução...");
    }

}
