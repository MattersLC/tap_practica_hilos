package Pila;

/** @author Orlando Lucero */
public class Pila {

    private int tope;
    private char[] datos;

    public Pila(int nd) {
        datos = new char[nd];
        tope = -1;
    }

    public boolean llena() {
        return tope==datos.length-1;
    }

    public boolean vacia() {
        return tope<0;
    }

    public synchronized void poner(char c) {
        if (llena()) {
            System.out.println("Pila llena, en espera el hilo "+Thread.currentThread().getName());
        }
        while (llena()) {
            try {
                this.wait();
            } catch (InterruptedException e) {}
        }
        tope++;
        datos[tope] = c;
        this.notify();
    }

    public synchronized char quitar() {
        char d = ' ';
        if (vacia()) {
            System.out.println("Pila vacía, en espera el hilo "+Thread.currentThread().getName());
        }
        while (vacia()) {
            try {
                this.wait();
            } catch (InterruptedException e) {}
        }
        d = datos[tope];
        tope--;
        this.notify();
        return d;
    }

    public char ver() {
        if (!vacia()) {
            return datos[tope];
        }

        return ' ';
    }
}
