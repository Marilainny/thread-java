package threadSoma;

import Calculadora.Calculadora;

public class ThreadSoma implements Runnable{

    private String nome;
    private int[] numerosCalculados;

    //A instância calculadora será compartilhada
    private static Calculadora calculadora = new Calculadora();

    public ThreadSoma(String nome, int[] numerosCalculados){
        this.nome = nome;
        this.numerosCalculados = numerosCalculados;
        new Thread(this, nome).start();

    }
    //Chamar a somaArray da classe Calculadora no run() da Thread
    @Override
    public void run() {
        System.out.println(this.nome+ "Iniciada");

        int soma = calculadora.somaArray(this.numerosCalculados);
        System.out.println("Resultado da soma: "+this.nome+ "= "+soma);

        System.out.println(this.nome+ "Finalizada");
    }
}
