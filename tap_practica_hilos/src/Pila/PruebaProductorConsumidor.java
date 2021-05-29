package Pila;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/** @author Orlando Lucero */
public class PruebaProductorConsumidor {

    public static void main(String[] args) {
        Pila pila = new Pila(10);
        Productor p1 = new Productor(pila);
        Productor p2 = new Productor(pila);
        Consumidor c1 = new Consumidor(pila);
        Consumidor c2 = new Consumidor(pila);
        Consumidor c3 = new Consumidor(pila);

        ExecutorService ejecutor = Executors.newCachedThreadPool();
        ejecutor.execute(p1);
        ejecutor.execute(p2);
        ejecutor.execute(c1);
        ejecutor.execute(c2);
        ejecutor.execute(c3);
        ejecutor.shutdown();

        try {
            // Espera 1 minuto de los consumidores-productores en su ejecución
            boolean tareasTerminaron = ejecutor.awaitTermination(
                    1, TimeUnit.MINUTES
            );
            if (tareasTerminaron) {
                System.out.println("Todas las tareas se terminaron"); // Imprime el contenido
            } else {
                System.out.println("Se agotó el tiempo esperando a que las tareas terminaran.");
                System.exit(1);
            }
        } catch (InterruptedException ex) {
            System.out.println("Hubo una interrupción mientras esperaba a que terminaran las tareas.");
        }
    }
}
