package threadExtends;

public class TesteExtends {

    public static void main(String[] args) {

        MinhaThread thread = new MinhaThread("Thread 1#", 100);
        MinhaThread thread2 = new MinhaThread("Thread 2#", 1000);

        MinhaThread t1 = new MinhaThread("#1 ", 100);
        MinhaThread t2 = new MinhaThread("#2 ", 500);
        MinhaThread t3 = new MinhaThread("#3 ", 800);

        //uma forma de fazer a Thread aguarda a execução para depois imprimir a mensagem finalização.
        while (t1.isAlive() || t2.isAlive() || t3.isAlive()) {
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("Programa finalizou!");

        MinhaThread t4 = new MinhaThread("#4 ", 900);
        MinhaThread t5 = new MinhaThread("#5 ", 1200);
        MinhaThread t6 = new MinhaThread("#6 ", 1400);

        //Outra forma de fazer a Thread aguarda a execução para depois imprimir a mensagem finalização.
        try {
            t4.join();
            t5.join();
            t6.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Programa finalizou!");

        //Imformar um prioridade de execução para a Thread.
        t4.setPriority(1);
        t5.setPriority(Thread.MAX_PRIORITY);

    }
}
