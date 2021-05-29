package Pila;

import Pilas.Pilas;

/** @author Orlando Lucero */
public class Consumidor implements Runnable{

    private Pila pila;
    private static int numCons = 0;

    public Consumidor(Pila p) {
        pila = p;
        numCons++;
    }

    @Override
    public void run() {
        char c;
        for (int i=0; i<20; i++) {
            c = pila.quitar();
            System.out.println("Hilo: Hilo_"+Thread.currentThread().getId()+"-consumidor Consumidor  "+numCons+": "+c);
            try {
                Thread.sleep((int)(Math.random()*777));
            } catch (InterruptedException e) {}
        }
    }
}
