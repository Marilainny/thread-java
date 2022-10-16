package sicronizacaoThread;

/**
 * Sincronização é a ato de coordenar as atividades de 2 ou mais Threads.
 * Quando compartilham o mesmo recurso. Uma thread pode acessar o recurso por vez. *
 */

public class ThreadTiqueTaque implements Runnable{

    TiqueTaque tiqueTaque;

    Thread identificador;

    final int NUMERO = 5;

    public ThreadTiqueTaque(String nome, TiqueTaque tiqueTaque){
        this.tiqueTaque = tiqueTaque;
        identificador = new Thread(this, nome);
        identificador.start();
    }

    @Override
    public void run() {

        if(identificador.getName().equalsIgnoreCase("Tique")){
            for(int i=0; i < NUMERO; i++){
                tiqueTaque.tique(true);
            }
            tiqueTaque.tique(false);
        }else{
            for(int i=0; i < NUMERO; i++){
                tiqueTaque.taque(true);
            }
            tiqueTaque.taque(false);
        }
    }
}
