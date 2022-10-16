package semaforo;

public enum CorSemaforo {

    VERDE(1000), AMARELO(500), VERMELHO(2000);

    private int tempoEspera;

    CorSemaforo(int tempoEspera){
        this.tempoEspera = tempoEspera;
    }

    public int getTempoEspera(){
        return tempoEspera;
    }
}
