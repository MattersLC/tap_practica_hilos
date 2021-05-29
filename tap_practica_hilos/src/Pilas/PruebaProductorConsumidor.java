package Pilas;

/** @author Orlando Lucero */
public class PruebaProductorConsumidor {

    public static void main(String[] args) {
        Pilas pila = new Pilas(10);
        Productor p1 = new Productor(pila);
        Productor p2 = new Productor(pila);
        Thread prodT1 = new Thread(p1);
        prodT1.start();
        Thread prodT2 = new Thread(p2);
        prodT2.start();
        Consumidor c1 = new Consumidor(pila);
        Consumidor c2 = new Consumidor(pila);
        Consumidor c3 = new Consumidor(pila);
        Thread prodC1 = new Thread(c1);
        prodC1.start();
        Thread prodC2 = new Thread(c2);
        prodC2.start();
        Thread prodC3 = new Thread(c3);
        prodC3.start();
    }
}
