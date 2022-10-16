package Calculadora;

public class Calculadora {

    private int soma;

    /**
     * Método que faz a soma do array
     * por ser um recurso compartilhado é informado o synchtonized.
     * apenas uma Thread pode acessar o método por vez
     */

    public synchronized int somaArray(int[] array){
        soma =0;
        for (int i=0; i < array.length; i++){
            soma += array[i];

            //informa a Thread atual que está executando a somaArray
            System.out.println("Executando a soma"+Thread.currentThread().getName()+
                    "somando o valor "+ array[i] + " com o total de "+ soma);

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        return soma;
    }
}
