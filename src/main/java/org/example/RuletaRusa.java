package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RuletaRusa {
    private List<Integer> tambor;
    private int bala;
    private int posicionActual;
    Random random;

    public RuletaRusa() {
        tambor = new ArrayList<>();
        random = new Random();
        bala = random.nextInt(6) + 1;
        posicionActual = random.nextInt(6) + 1;
    }

    public RuletaRusa(Random random, int posicionActual, int bala, List<Integer> tambor) {
        this.random = random;
        this.posicionActual = posicionActual;
        this.bala = bala;
        this.tambor = new ArrayList<>();
    }

    public List<Integer> getTambor() {
        return tambor;
    }

    public void setTambor(List<Integer> tambor) {
        this.tambor = tambor;
    }

    public int getBala() {
        return bala;
    }

    public void setBala(int bala) {
        this.bala = bala;
    }

    public int getPosicionActual() {
        return posicionActual;
    }

    public void setPosicionActual(int posicionActual) {
        this.posicionActual = posicionActual;
    }

    public Random getRandom() {
        return random;
    }

    public void setRandom(Random random) {
        this.random = random;
    }

    @Override
    public String toString() {
        return "RuletaRusa{" +
                "tambor=" + tambor +
                ", bala=" + bala +
                ", posicionActual=" + posicionActual +
                ", random=" + random +
                '}';
    }

    public void iniciarJuego(){
        for (int i = 1; i <= 6; i++){
            tambor.add(i);
        }
    }

    public boolean disparar(){
        if (posicionActual == bala){
            return true;
        }else{
            posicionActual++;
            if (posicionActual > 6){
                posicionActual = 1;
            }
            return false;
        }

    }

    public void reiniciarJuego(){
        tambor.clear();
        for (int i = 1; i <= 6; i++){
            tambor.add(i);
        }
        bala = random.nextInt(6) + 1;
        posicionActual = random.nextInt(6) + 1;
    }

}
